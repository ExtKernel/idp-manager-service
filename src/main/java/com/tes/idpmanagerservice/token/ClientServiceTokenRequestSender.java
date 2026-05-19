package com.tes.idpmanagerservice.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tes.idpmanagerservice.model.KcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientServiceTokenRequestSender extends GenericTokenRequestSender<KcClient> {

    @Autowired
    public ClientServiceTokenRequestSender(
            ObjectMapper objectMapper,
            TokenRequestBuilder<KcClient> requestBuilder
    ) {
        super(objectMapper, requestBuilder);
    }
}
