package com.adamdrsinc.StoreSpringBoot.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Version;

@Entity
public class Product{
        @Id
        Integer id;

        @NotEmpty
        String name;

        @NotNull
        Double price;

        String description;

        @NotNull
        Long stockCount;

        @Version
        Integer version;


        public Product(Integer id, String name, Double price, String description, Long stockCount, Integer version) {
                this.id = id;
                this.name = name;
                this.price = price;
                this.description = description;
                this.stockCount = stockCount;
                this.version = version;
        }

        public Product() {

        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public @NotEmpty String getName() {
                return name;
        }

        public void setName(@NotEmpty String name) {
                this.name = name;
        }

        public @NotNull Double getPrice() {
                return price;
        }

        public void setPrice(@NotNull Double price) {
                this.price = price;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public @NotNull Long getStockCount() {
                return stockCount;
        }

        public void setStockCount(@NotNull Long stockCount) {
                this.stockCount = stockCount;
        }

        public Integer getVersion() {
                return version;
        }

        public void setVersion(Integer version) {
                this.version = version;
        }
}