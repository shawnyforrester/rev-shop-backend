package com.app.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column

    private long id;
    @Column

    private Long id;

    private String name;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String telephone;
    @Column
    private String address;
    @Column
    private String role;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    public Buyer(String name, String username, String password) {


    }
}
