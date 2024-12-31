package com.adamdrsinc.StoreSpringBoot.customer;

import com.adamdrsinc.StoreSpringBoot.regexpressions.RegExPatterns;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.annotation.Id;


public record Customer(
        @Id
        Integer Customer_ID,

        @NotBlank
        @Pattern(regexp = RegExPatterns.ALPHABETIC, message = "First name may only contain characters.")
        String FirstName,

        @NotBlank
        @Pattern(regexp = RegExPatterns.ALPHABETIC, message = "Last name may only contain characters.")
        String LastName,

        @Email
        String Email
) {
}
