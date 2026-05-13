package com.tes.idpmanagerservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Oauth2Client extends Client {
    private String clientSecret;
    private List<RefreshToken> refreshTokens;

    public Oauth2Client(String id) {
        super(id);
    }

    public Oauth2Client(
            String id,
            String clientSecret,
            String fqdn
    ) {
        super(id, fqdn);
        this.clientSecret = clientSecret;
    }

    public Oauth2Client(
            String id,
            String clientSecret,
            String ip,
            String port
    ) {
        super(id, ip, port);
        this.clientSecret = clientSecret;
    }
}
