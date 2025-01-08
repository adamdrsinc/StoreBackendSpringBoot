package com.adamdrsinc.StoreSpringBoot.authorization.register;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;

    private String customerEmail;

    private String password;

    private String firstName;

    private String lastName;
}
