package com.unir.accounts.data;

import com.unir.accounts.data.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
}
