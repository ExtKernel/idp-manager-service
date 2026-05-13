package com.tes.idpmanagerservice.win;

import com.tes.idpmanagerservice.idp.*;
import com.tes.idpmanagerservice.model.WinClient;
import com.tes.idpmanagerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class WinIdpUsergroupManager extends GenericIdpUsergroupManager<WinClient> {

    @Autowired
    public WinIdpUsergroupManager(
            ClientService<WinClient> clientService,
            @Qualifier("winIdpJsonObjectMapper") IdpJsonObjectMapper jsonObjectMapper,
            IdpUsergroupRequestSender<WinClient> requestSender,
            @Lazy IdpModelExistenceValidator<WinClient> modelExistenceValidator,
            @Lazy IdpUserManager<WinClient> userManager,
            UsergroupIdpRequestSenderResultBlackListFilter<WinClient> blackListFilter
    ) {
        super(
                clientService,
                jsonObjectMapper,
                requestSender,
                modelExistenceValidator,
                userManager,
                blackListFilter
        );
    }
}
