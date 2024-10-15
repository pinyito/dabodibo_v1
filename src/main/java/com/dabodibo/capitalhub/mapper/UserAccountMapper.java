package com.dabodibo.capitalhub.mapper;

import com.dabodibo.capitalhub.dto.UserAccountDto;
import com.dabodibo.capitalhub.entity.UserAccount;

public class UserAccountMapper {

    // map UserAccountDto to UserAccount
    public static UserAccount mapToUserAccount(UserAccountDto userAccountDto) {

        return UserAccount.builder()
                .id(userAccountDto.getId())
                .userEmail(userAccountDto.getUserEmail())
                .userPassword(userAccountDto.getUserPassword())
                .createdOn(userAccountDto.getCreatedOn())
                .updatedOn(userAccountDto.getUpdatedOn())
                .build();
    }
}
