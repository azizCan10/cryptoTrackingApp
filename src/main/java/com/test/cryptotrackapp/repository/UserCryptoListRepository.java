package com.test.cryptotrackapp.repository;

import com.test.cryptotrackapp.entity.UserCryptoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCryptoListRepository extends JpaRepository<UserCryptoList, Long> {

    List<UserCryptoList> getByUserId(Long id);
}
