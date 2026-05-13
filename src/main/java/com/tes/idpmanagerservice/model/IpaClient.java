package com.tes.idpmanagerservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IpaClient extends CookieClient {
    private String id;
    private String certPath;

    public IpaClient(String id) {
        super(id);
    }

    public IpaClient(
            String id,
            String fqdn
    ) {
        super(id, fqdn);
    }

    public IpaClient(
            String id,
            String ip,
            String port
    ) {
        super(id, ip, port);
    }
}
