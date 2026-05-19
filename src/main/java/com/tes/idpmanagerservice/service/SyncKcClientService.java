package com.tes.idpmanagerservice.service;

import com.tes.idpmanagerservice.model.KcClient;
import com.tes.idpmanagerservice.model.SyncKcClient;
import com.tes.idpmanagerservice.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyncKcClientService extends GenericClientService<SyncKcClient> {

    @Autowired
    public SyncKcClientService(
            TokenManager<KcClient> tokenManager,
            ClientServiceFactory clientServiceFactory
    ) {
        super(tokenManager, clientServiceFactory);
    }
}
