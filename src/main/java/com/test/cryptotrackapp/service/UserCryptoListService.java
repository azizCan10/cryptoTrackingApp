package com.test.cryptotrackapp.service;

import com.test.cryptotrackapp.core.result.Result;
import com.test.cryptotrackapp.core.result.SuccessResult;
import com.test.cryptotrackapp.dto.converter.UserCryptoListConverter;
import com.test.cryptotrackapp.dto.userCryptoList.CreateUserCryptoListRequest;
import com.test.cryptotrackapp.dto.userCryptoList.UserCryptoListDto;
import com.test.cryptotrackapp.entity.UserCryptoList;
import com.test.cryptotrackapp.exception.NotFoundException;
import com.test.cryptotrackapp.repository.UserCryptoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserCryptoListService {

    private final UserCryptoListRepository userCryptoListRepository;
    private final UserCryptoListConverter converter;

    public Result add(CreateUserCryptoListRequest userCryptoList) {
        userCryptoListRepository.save(converter.convert(userCryptoList));
        return new SuccessResult("Tracking: " + userCryptoList.getSymbol());
    }

    public Result delete(long id) {
        findUserCryptoListById(id);

        userCryptoListRepository.deleteById(id);
        return new SuccessResult("Tracking removed.");
    }

    private UserCryptoList findUserCryptoListById(long id) {
        return userCryptoListRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tracking couldn't find by id: " + id));
    }

    public List<UserCryptoListDto> findByUserId(Long id) {
        return userCryptoListRepository.getByUserId(id)
                .stream().map(converter::convert).collect(Collectors.toList());
    }
}
