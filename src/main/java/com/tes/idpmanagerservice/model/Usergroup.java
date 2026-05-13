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
public class Usergroup implements Serializable {
    private String name;
    private String description;
    private List<User> users;

    public Usergroup(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public Usergroup(
            String name,
            String description
    ) {
        this.name = name;
        this.description = description;
        this.users = new ArrayList<>();
    }
}
