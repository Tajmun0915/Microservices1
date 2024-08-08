package com.nisum.users.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users" , schema = "usersdb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String first_name;
    private String last_name;
    private String planCode;
    private String createdBy;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_card_info_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CreditCardInfo creditCardInfo;

}
