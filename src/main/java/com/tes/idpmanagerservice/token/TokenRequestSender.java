package com.tes.idpmanagerservice.token;

import com.fasterxml.jackson.databind.JsonNode;
import com.tes.idpmanagerservice.model.Oauth2Client;
import com.tes.idpmanagerservice.model.RefreshToken;

public interface TokenRequestSender<T extends Oauth2Client> {
    JsonNode getAccessToken(
            T client,
            String tokenEndpointUrl,
            RefreshToken refreshToken
    );
    JsonNode getRefreshToken(
            T client,
            String tokenEndpointUrl
    );
}
