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
@Table(name = "product")
public class Product{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "product_id")
        private Integer productID;

        @Getter
        @Setter
        @Column(name = "name", nullable = false)
        private String name;

        @Getter
        @Setter
        @Column(name = "price", nullable = false)
        private Double price;

        @Getter
        @Setter
        @Column(name = "description", nullable = false)
        private String description;

        @Getter
        @Setter
        @Column(name = "stock_count")
        private Long stockCount;
}