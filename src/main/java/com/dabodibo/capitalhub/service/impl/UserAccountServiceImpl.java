package com.dabodibo.capitalhub.service.impl;

import com.dabodibo.capitalhub.dto.UserAccountDto;
import com.dabodibo.capitalhub.entity.Role;
import com.dabodibo.capitalhub.entity.UserAccount;
import com.dabodibo.capitalhub.repository.RoleRepository;
import com.dabodibo.capitalhub.repository.UserAccountRepository;
import com.dabodibo.capitalhub.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository, RoleRepository roleRepository) {
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUserAccount(UserAccountDto userAccountDto) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserEmail(userAccountDto.getUserEmail());
        // use spring security to encrypt the password later on
        userAccount.setUserPassword(userAccountDto.getUserPassword());
        Role role = roleRepository.findByName("ROLE_IP");
        userAccount.setRoles(List.of(role));
        userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount findByUserEmail(String userEmail) {
        return userAccountRepository.findByUserEmail(userEmail);
    }
}
