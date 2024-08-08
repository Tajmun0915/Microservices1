package com.nisum.users.dto;

import com.nisum.users.model.CreditCardInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String first_name;
    private String last_name;
    private String planCode;
    private String createdBy;
    private CreditCardInfoDTO creditCardInfo;
}