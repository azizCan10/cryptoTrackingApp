package com.test.cryptotrackapp.service;

import com.test.cryptotrackapp.core.result.DataResult;
import com.test.cryptotrackapp.core.result.Result;
import com.test.cryptotrackapp.core.result.SuccessDataResult;
import com.test.cryptotrackapp.core.result.SuccessResult;
import com.test.cryptotrackapp.dto.Crypto;
import com.test.cryptotrackapp.dto.converter.UserConverter;
import com.test.cryptotrackapp.dto.user.CreateUserRequest;
import com.test.cryptotrackapp.dto.user.UserDto;
import com.test.cryptotrackapp.dto.userCryptoList.UserCryptoListDto;
import com.test.cryptotrackapp.entity.User;
import com.test.cryptotrackapp.exception.NotFoundException;
import com.test.cryptotrackapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter converter;
    private final UserCryptoListService userCryptoListService;
    private final CryptoService cryptoService;

    public Result add(CreateUserRequest user) {
        userRepository.save(converter.convert(user));
        return new SuccessResult("Account created. Happy tracking!");
    }

    public DataResult<UserDto> getById(long id) {

        return new SuccessDataResult<>(convert(findUserById(id)));
    }

    public DataResult<UserDto> signIn(String username, String password) {
        User user = userRepository.getByUsernameAndPassword(username, password)
                .orElseThrow(() -> new NotFoundException("Username or password is incorrect."));

        return new SuccessDataResult<>(convert(user));
    }

    public Result delete(long id) {
        findUserById(id);

        userRepository.deleteById(id);
        return new SuccessResult("Account removed.");
    }

    private User findUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Account couldn't find by id: " + id));
    }

    private UserDto convert(User user) {
        UserDto userDto = converter.convert(user);

        List<String> symbols = userCryptoListService.findByUserId(user.getId()).stream()
                .map(UserCryptoListDto::getSymbol)
                .collect(Collectors.toList());

        List<Crypto> cryptos = symbols.stream()
                .map(cryptoService::getAvgPrice)
                .collect(Collectors.toList());

        userDto.setTrackedCryptos(cryptos);

        return userDto;
    }
}
