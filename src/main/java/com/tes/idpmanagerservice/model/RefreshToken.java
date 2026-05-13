package com.tes.idpmanagerservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RefreshToken extends Token {

    public RefreshToken(
            Long id,
            String token,
            int expiresIn,
            Date creationDate
    ) {
        super(id, token, expiresIn, creationDate);
    }

    public RefreshToken(
            String token,
            int expiresIn
    ) {
        super(token, expiresIn);
    }
}
