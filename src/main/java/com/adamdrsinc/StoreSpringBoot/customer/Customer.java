package com.adamdrsinc.StoreSpringBoot.customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Customer implements UserDetails {
        @Id
        private Integer id;

        @Column(unique = true, nullable = false, updatable = false)
        private String username;

        @Column(name = "customer_email", unique = true, nullable = false)
        private String customerEmail;

        @Column(name = "password", nullable = false)
        private String password;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(updatable = false)
        @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
        @CreationTimestamp
        private LocalDateTime created;

        public Customer(Integer id, LocalDateTime created, String username, String password, String firstName, String lastName, String customerEmail) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.customerEmail = customerEmail;
                this.password = password;
                this.username = username;
                this.created = created;
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

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
        }

        @Override
        public String getPassword() {
                return password;
        }

        @Override
        public String getUsername() {
                return username;
        }

        @Override
        public boolean isAccountNonExpired() {
                return UserDetails.super.isAccountNonExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
                return UserDetails.super.isAccountNonLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return UserDetails.super.isCredentialsNonExpired();
        }

        @Override
        public boolean isEnabled() {
                return UserDetails.super.isEnabled();
        }
}
