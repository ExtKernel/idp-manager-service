package com.tes.idpmanagerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token extends AuthModel {
    private String token;
    private int expiresIn;
    private Date creationDate;

    public Token(
            Long id,
            String token,
            int expiresIn
    ) {
        super(id);
        this.token = token;
        this.expiresIn = expiresIn;
    }

    public Token(Long id, String token, int expiresIn, Date creationDate) {
        super(id);
        this.token = token;
        this.expiresIn = expiresIn;
        this.creationDate = creationDate;
    }

    public Token(String token, int expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }
}
