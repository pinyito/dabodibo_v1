package com.dabodibo.capitalhub.service;

import com.dabodibo.capitalhub.dto.UserAccountDto;
import com.dabodibo.capitalhub.entity.UserAccount;

public interface UserAccountService {
    void saveUserAccount(UserAccountDto userAccountDto);

    UserAccount findByUserEmail(String userEmail);
}
