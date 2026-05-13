package com.tes.idpmanagerservice.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tes.idpmanagerservice.model.SyncKcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SyncKcTokenRequestSender extends GenericTokenRequestSender<SyncKcClient> {

    @Autowired
    public SyncKcTokenRequestSender(
            ObjectMapper objectMapper,
            TokenRequestBuilder<SyncKcClient> requestBuilder
    ) {
        super(objectMapper, requestBuilder);
    }
}
