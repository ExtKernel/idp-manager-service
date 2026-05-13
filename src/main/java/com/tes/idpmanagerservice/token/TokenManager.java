package com.tes.idpmanagerservice.token;

import com.tes.idpmanagerservice.model.AccessToken;
import com.tes.idpmanagerservice.model.Client;
import com.tes.idpmanagerservice.model.RefreshToken;

public interface TokenManager<T extends Client> {
    AccessToken getAccessToken(
            T client,
            String tokenEndpointUrl,
            RefreshToken refreshToken
    );
    RefreshToken getRefreshToken(
            T client,
            String tokenEndpointUrl
    );
}
