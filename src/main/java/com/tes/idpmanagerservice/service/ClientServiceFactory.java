package com.tes.idpmanagerservice.service;

import com.tes.idpmanagerservice.model.KcClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientServiceFactory {
//    @Value("clientServiceFdqn")
//    private String fdqn;

    @Value("${clientServiceIp}")
    private String ip;

    @Value("${clientServicePort}")
    private String port;

    @Value("${clientServicePrincipalUsername}")
    private String principalUsername;

    @Value("${clientServicePrincipalPassword}")
    private String principalPassword;

    public KcClient buildService() {
        KcClient client = new KcClient("client-service");
//        client.setFqdn(fdqn);
        client.setIp(ip);
        client.setPort(port);
        client.setPrincipalUsername(principalUsername);
        client.setPrincipalPassword(principalPassword);

        return client;
    }
}
