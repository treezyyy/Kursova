package com.example.kursova;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private String firstName;
    private String userName;
    private String password;
    private String gendere;
    private String phone;
    private String email;
}