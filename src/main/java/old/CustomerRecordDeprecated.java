/*
package old;

import com.adamdrsinc.StoreSpringBoot.regexpressions.RegExPatterns;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public record CustomerRecordDeprecated(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @NotBlank
        @Pattern(regexp = RegExPatterns.ALPHABETIC, message = "First name may only contain characters.")
        String firstName,

        @NotBlank
        @Pattern(regexp = RegExPatterns.ALPHABETIC, message = "Last name may only contain characters.")
        String lastName,

        @Email
        String email,

        @Version
        Integer version
) {
}*/
