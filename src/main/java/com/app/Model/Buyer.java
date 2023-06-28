package com.app.Model;

import jakarta.persistence.*;
import lombok.*;


/*
Zack
-Added @builder, all arg and no arg constructors were done correctly
 */
@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String username;
    //custom setter was created for email
    private String email;
    private String password;
    private String telephone;
    private String address;
    private String role;

    public Buyer(String name, String username, String email, String password, String telephone, String address, String role) {
    }


    public void setEmail(String email) {
        this.email = email;
    }


}
