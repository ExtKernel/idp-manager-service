package com.tes.idpmanagerservice.service;

import com.tes.idpmanagerservice.model.Client;
import com.tes.idpmanagerservice.model.KcClient;
import com.tes.idpmanagerservice.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenericClientService<ClientType extends Client> implements ClientService<ClientType> {
    private final TokenManager<KcClient> tokenManager;
    private final KcClient clientServiceClient;
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${clientServiceTokenEndpointUrl}")
    private String tokenEndpointUrl;

    @Autowired
    public GenericClientService(
            TokenManager<KcClient> tokenManager,
            ClientServiceFactory clientServiceFactory
    ) {
        this.tokenManager = tokenManager;
        this.clientServiceClient = clientServiceFactory.buildService();
    }

    @Override
    public ClientType findById(String id) {
        tokenManager.getAccessToken(
                clientServiceClient,
                this.tokenEndpointUrl,
                tokenManager.getRefreshToken(
                        clientServiceClient,
                        this.tokenEndpointUrl
                )
        );

        restTemplate.getForEntity(
                "http://" + clientServiceClient.getIp() + ":" + clientServiceClient.getPort() + "/",
                String.class
        );

        return null;
    }
}
