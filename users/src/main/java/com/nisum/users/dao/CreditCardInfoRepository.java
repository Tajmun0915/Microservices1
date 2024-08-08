package com.nisum.users.dao;

import com.nisum.users.model.CreditCardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardInfoRepository extends JpaRepository<CreditCardInfo, Long> {
}
