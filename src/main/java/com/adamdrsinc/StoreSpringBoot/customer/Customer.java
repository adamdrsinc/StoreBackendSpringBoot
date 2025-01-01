package com.adamdrsinc.StoreSpringBoot.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Version;

@Entity
public class Customer{
        @Id
        Integer id;

        @NotEmpty
        String firstName;

        @NotEmpty
        String lastName;

        @NotEmpty
        String customerEmail;

        @Version
        Integer version;

        public Customer(Integer id, String firstName, String lastName, String customerEmail, Integer version) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.customerEmail = customerEmail;
                this.version = version;
        }

        public Customer() {

        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public @NotEmpty String getFirstName() {
                return firstName;
        }

        public void setFirstName(@NotEmpty String firstName) {
                this.firstName = firstName;
        }

        public @NotEmpty String getLastName() {
                return lastName;
        }

        public void setLastName(@NotEmpty String lastName) {
                this.lastName = lastName;
        }

        public @NotEmpty String getCustomerEmail() {
                return customerEmail;
        }

        public void setCustomerEmail(@NotEmpty String customerEmail) {
                this.customerEmail = customerEmail;
        }

        public Integer getVersion() {
                return version;
        }

        public void setVersion(Integer version) {
                this.version = version;
        }
}
