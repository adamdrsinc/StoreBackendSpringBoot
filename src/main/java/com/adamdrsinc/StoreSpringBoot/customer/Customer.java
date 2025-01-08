package com.adamdrsinc.StoreSpringBoot.customer;

import com.adamdrsinc.StoreSpringBoot.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "customer_id")
        private Integer customerID;

        @Column(name = "username", unique = true, nullable = false, updatable = false)
        private String username;

        @Column(name = "customer_email", unique = true, nullable = false)
        private String customerEmail;

        @Setter
        @Column(name = "password", nullable = false)
        private String password;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "created", updatable = false)
        @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
        @CreationTimestamp
        private LocalDateTime created;


        @Column(name = "customer_role", nullable = false)
        @Getter
        @Setter
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "customer_roles", joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customer_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id")
        )
        private List<Role> customerRole = new ArrayList<>();

        @Column(name = "enabled", nullable = false)
        private Boolean enabled = true;

        /*public Customer(Integer id, LocalDateTime created, String username, String password, String firstName, String lastName, String customerEmail, String role) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.customerEmail = customerEmail;
                this.password = password;
                this.username = username;
                this.created = created;
                this.customerRole = role;
        }*/


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
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
