package com.tes.idpmanagerservice.service;

import com.tes.idpmanagerservice.model.KcClient;
import com.tes.idpmanagerservice.model.WinClient;
import com.tes.idpmanagerservice.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WinClientService extends GenericClientService<WinClient> {

    @Autowired
    public WinClientService(
            TokenManager<KcClient> tokenManager,
            ClientServiceFactory clientServiceFactory
    ) {
        super(tokenManager, clientServiceFactory);
    }
}
