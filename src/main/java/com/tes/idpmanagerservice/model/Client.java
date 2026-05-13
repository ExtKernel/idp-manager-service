package com.tes.idpmanagerservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Client {
    private String id;
    private String name;
    private String fqdn;
    private String ip;
    private String port;
    private String principalUsername;
    private String principalPassword;
    private List<String> usergroupBlacklist;
    private List<String> userBlacklist;

    public Client(String id) {
        this.id = id;
    }

    public Client(
            String id,
            String fqdn
    ) {
        this.id = id;
        this.fqdn = fqdn;
    }

    public Client(
            String id,
            String ip,
            String port
    ) {
        this.id = id;
        this.ip = ip;
        this.port = port;
    }
}
