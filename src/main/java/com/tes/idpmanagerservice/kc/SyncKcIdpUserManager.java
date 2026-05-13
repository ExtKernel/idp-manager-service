package com.tes.idpmanagerservice.kc;

import com.tes.idpmanagerservice.idp.*;
import com.tes.idpmanagerservice.model.SyncKcClient;
import com.tes.idpmanagerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SyncKcIdpUserManager extends GenericIdpUserManager<SyncKcClient> {

    @Autowired
    public SyncKcIdpUserManager(
            ClientService<SyncKcClient> clientService,
            @Qualifier("syncKcIdpJsonObjectMapper") IdpJsonObjectMapper jsonObjectMapper,
            IdpUserRequestSender<SyncKcClient> requestSender,
            @Lazy IdpModelExistenceValidator<SyncKcClient> modelExistenceValidator,
            UserIdpRequestSenderResultBlackListFilter<SyncKcClient> blackListFilter
    ) {
        super(
                clientService,
                jsonObjectMapper,
                requestSender,
                modelExistenceValidator,
                blackListFilter
        );
    }
}
