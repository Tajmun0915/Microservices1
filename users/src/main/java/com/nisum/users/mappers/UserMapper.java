package com.nisum.users.mappers;

import com.nisum.users.dto.CreditCardInfoDTO;
import com.nisum.users.dto.UserDTO;
import com.nisum.users.model.User;
import com.nisum.users.model.CreditCardInfo;

public class UserMapper {

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setFirst_name(userDTO.getFirst_name());
        user.setLast_name(userDTO.getLast_name());
        user.setPlanCode(userDTO.getPlanCode());
        user.setCreatedBy(userDTO.getCreatedBy());

        if (userDTO.getCreditCardInfo() != null) {
            CreditCardInfo creditCardInfo = new CreditCardInfo();
            creditCardInfo.setCcid(userDTO.getCreditCardInfo().getCcid());
            creditCardInfo.setCcNumber(userDTO.getCreditCardInfo().getCcNumber());
            creditCardInfo.setZip(userDTO.getCreditCardInfo().getZip());
            creditCardInfo.setCvv(userDTO.getCreditCardInfo().getCvv());
            creditCardInfo.setExpDate(userDTO.getCreditCardInfo().getExpDate());
            creditCardInfo.setType(userDTO.getCreditCardInfo().getType());

            user.setCreditCardInfo(creditCardInfo);
        }
        return user;
    }

    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setFirst_name(user.getFirst_name());
        userDTO.setLast_name(user.getLast_name());
        userDTO.setPlanCode(user.getPlanCode());
        userDTO.setCreatedBy(user.getCreatedBy());

        if (user.getCreditCardInfo() != null) {
            CreditCardInfoDTO creditCardInfoDTO = new CreditCardInfoDTO();
            creditCardInfoDTO.setCcNumber(user.getCreditCardInfo().getCcNumber());
            creditCardInfoDTO.setZip(user.getCreditCardInfo().getZip());
            creditCardInfoDTO.setCvv(user.getCreditCardInfo().getCvv());
            creditCardInfoDTO.setExpDate(user.getCreditCardInfo().getExpDate());
            creditCardInfoDTO.setType(user.getCreditCardInfo().getType());

            userDTO.setCreditCardInfo(creditCardInfoDTO);
        }
        return userDTO;
    }
}
