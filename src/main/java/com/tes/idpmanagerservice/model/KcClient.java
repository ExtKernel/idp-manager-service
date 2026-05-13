package com.tes.idpmanagerservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A superclass for any Keycloak (KC) client.
 * Including, for example, ones, that aren't supposed to be synchronized.
 * Provides all necessary fields to represent a basic KC client
 * and to make a request using data from fields.
 */
@Data
@NoArgsConstructor
public class KcClient extends Oauth2Client {
    private String realm;
    private String kcFqdn;
    private String kcIp;
    private String kcPort;

    public KcClient(String id) {
        super(id);
    }

    public KcClient(
            String id,
            String clientSecret,
            String fqdn
    ) {
        super(id, clientSecret, fqdn);
    }

    public KcClient(
            String id,
            String clientSecret,
            String ip,
            String port
    ) {
        super(id, clientSecret, ip, port);
    }
}
