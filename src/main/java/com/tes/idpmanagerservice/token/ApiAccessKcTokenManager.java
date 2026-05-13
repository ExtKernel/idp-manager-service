package com.tes.idpmanagerservice.token;

import com.tes.idpmanagerservice.model.ApiAccessKcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ApiAccessKcTokenManager extends GenericTokenManager<ApiAccessKcClient> {

    @Autowired
    public ApiAccessKcTokenManager(
            @Qualifier("apiAccessKcTokenJsonObjectMapper") TokenJsonObjectMapper jsonObjectMapper,
            TokenRequestSender<ApiAccessKcClient> requestSender
    ) {
        super(jsonObjectMapper, requestSender);
    }
}
