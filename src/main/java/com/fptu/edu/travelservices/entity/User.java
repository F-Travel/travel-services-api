package com.fptu.edu.travelservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user",uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FullName")
    private String fullName;

    @NotBlank
    @Size(max = 20)
    @Column(name = "UserName")
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "Email")
    private String email;

    @NotBlank
    @Size(max = 20, min = 6)
    @Column(name = "Password")
    private String password;

    @NotBlank
    @Column(name = "Phone")

    @NotBlank
    @Size(max = 11)
    private String phone;
    @Column(name = "Address")
    private String address;

    @Column(name = "Avatar")
    private String avatar;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
