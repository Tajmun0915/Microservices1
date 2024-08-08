package com.nisum.users.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardInfoDTO {

    @NotNull
    private Long ccid;
    private String ccNumber;
    private String zip;
    private int cvv;
    private String expDate;
    private String type;
}