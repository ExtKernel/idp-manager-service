package com.tes.idpmanagerservice.token;

import com.tes.idpmanagerservice.model.KcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClientServiceTokenManager extends GenericTokenManager<KcClient> {

    @Autowired
    public ClientServiceTokenManager(
            @Qualifier("clientServiceTokenJsonObjectMapper") TokenJsonObjectMapper jsonObjectMapper,
            TokenRequestSender<KcClient> requestSender
    ) {
        super(jsonObjectMapper, requestSender);
    }
}
