package com.tes.idpmanagerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private List<Usergroup> usergroups;

    public User(String username) {
        this.username = username;
        this.usergroups = new ArrayList<>();
    }

    public User(
            String username,
            String firstname,
            String lastname,
            String email
    ) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.usergroups = new ArrayList<>();
    }
}
