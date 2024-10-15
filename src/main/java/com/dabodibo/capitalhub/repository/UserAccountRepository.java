package com.dabodibo.capitalhub.repository;

import com.dabodibo.capitalhub.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    // create query method
    UserAccount findByUserEmail(String userEmail);
}
