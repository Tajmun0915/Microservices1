package com.nisum.users.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ccid;
    private String ccNumber;
    private String zip;
    private int cvv;
    private String expDate;
    private String type;


}
