package com.tes.idpmanagerservice.service;

import com.tes.idpmanagerservice.model.IpaClient;
import com.tes.idpmanagerservice.model.KcClient;
import com.tes.idpmanagerservice.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpaClientService extends GenericClientService<IpaClient> {

    @Autowired
    public IpaClientService(
            TokenManager<KcClient> tokenManager,
            ClientServiceFactory clientServiceFactory
    ) {
        super(tokenManager, clientServiceFactory);
    }
}
