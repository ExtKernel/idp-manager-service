package com.tes.idpmanagerservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * A superclass for any client, that uses cookies for auth.
 * Provides all necessary fields to represent a basic client, which requires auth by cookies
 * and to make a request using data from fields.
 */
@Data
@NoArgsConstructor
public class CookieClient extends Client {
    private List<Cookie> cookies;

    public CookieClient(String id) {
        super(id);
    }

    public CookieClient(
            String id,
            String fqdn
    ) {
        super(id, fqdn);
    }

    public CookieClient(
            String id,
            String ip,
            String port
    ) {
        super(id, ip, port);
    }
}
