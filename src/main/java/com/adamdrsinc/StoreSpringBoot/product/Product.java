package com.adamdrsinc.StoreSpringBoot.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Version;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Getter
        @Setter
        @Column(nullable = false)
        private String name;

        @Getter
        @Setter
        @Column(nullable = false)
        private Double price;

        @Getter
        @Setter
        @Column(nullable = false)
        private String description;

        @Getter
        @Setter
        private Long stockCount;
}