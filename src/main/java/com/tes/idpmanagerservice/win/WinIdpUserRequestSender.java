package com.tes.idpmanagerservice.win;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tes.idpmanagerservice.exception.UserJsonReadingException;
import com.tes.idpmanagerservice.exception.UsersJsonReadingException;
import com.tes.idpmanagerservice.idp.IdpJsonObjectMapper;
import com.tes.idpmanagerservice.idp.IdpRequestBuilder;
import com.tes.idpmanagerservice.idp.IdpUserRequestSender;
import com.tes.idpmanagerservice.model.User;
import com.tes.idpmanagerservice.model.WinClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WinIdpUserRequestSender implements IdpUserRequestSender<WinClient> {
    private final IdpRequestBuilder<WinClient> requestBuilder;
    private final IdpJsonObjectMapper jsonObjectMapper;
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public WinIdpUserRequestSender(
            IdpRequestBuilder<WinClient> requestBuilder,
            @Qualifier("winIdpJsonObjectMapper") IdpJsonObjectMapper jsonObjectMapper,
            ObjectMapper objectMapper
    ) {
        this.requestBuilder = requestBuilder;
        this.jsonObjectMapper = jsonObjectMapper;
        // pass null as RestTemplate building for a Win client doesn't depend on the client
        this.restTemplate = requestBuilder.getRestTemplate(null);
        this.objectMapper = objectMapper;
    }

    @Override
    public User sendCreateUserRequest(
            WinClient client,
            User user
    ) {
        restTemplate.exchange(
                requestBuilder.buildRequestUrl(
                        client,
                        "http",
                        "/users/create/"
                ),
                HttpMethod.POST,
                requestBuilder.buildHttpRequestEntity(
                        client.getId(),
                        jsonObjectMapper.mapUserToJsonString(user),
                        requestBuilder.buildAuthRequestUrl(
                                client,
                                "http"
                        )
                ),
                String.class
        );

        return user;
    }

    @Override
    public JsonNode sendGetUserRequest(
            WinClient client,
            String username
    ) {
        try {
            return objectMapper.readTree(
                    restTemplate.exchange(
                            requestBuilder.buildRequestUrl(
                                    client,
                                    "http",
                                    "/users/" + username + "/"
                            ),
                            HttpMethod.GET,
                            requestBuilder.buildAuthOnlyHttpRequestEntity(
                                    client.getId(),
                                    requestBuilder.buildAuthRequestUrl(
                                            client,
                                            "http"
                                    )
                            ),
                            String.class
                    ).getBody()
            );
        } catch (JsonProcessingException exception) {
            throw new UserJsonReadingException(
                    "An exception occurred while reading JSON received from the request"
                            + " to retrieve a user for Windows client with id "
                            + client.getId() + ": "
                            + exception.getMessage()
            );
        }
    }

    @Cacheable("winUsers")
    @Override
    public JsonNode sendGetUsersRequest(WinClient client) {
        try {
            return objectMapper.readTree(
                    restTemplate.exchange(
                            requestBuilder.buildRequestUrl(
                                    client,
                                    "http",
                                    "/users/"
                            ),
                            HttpMethod.GET,
                            requestBuilder.buildAuthOnlyHttpRequestEntity(
                                    client.getId(),
                                    requestBuilder.buildAuthRequestUrl(
                                            client,
                                            "http"
                                    )
                            ),
                            String.class
                    ).getBody()
            );
        } catch (JsonProcessingException exception) {
            throw new UsersJsonReadingException(
                    "An exception occurred while reading JSON received from the request"
                            + " to retrieve users for Windows client with id "
                            + client.getId() + ": "
                            + exception.getMessage()
            );
        }
    }

    @Override
    public String sendUpdateUserPasswordRequest(
            WinClient client,
            String username,
            String newPassword
    ) {
        restTemplate.exchange(
                requestBuilder.buildRequestUrl(
                        client,
                        "http",
                        "/users/update-password/" + username + "/"
                ),
                HttpMethod.PATCH,
                requestBuilder.buildHttpRequestEntity(
                        client.getId(),
                        jsonObjectMapper.buildCredentialsRepresentation(newPassword),
                        requestBuilder.buildAuthRequestUrl(
                                client,
                                "http"
                        )
                ),
                String.class
        );

        return newPassword;
    }

    @Override
    public void sendDeleteUserRequest(
            WinClient client,
            String username
    ) {
        restTemplate.exchange(
                requestBuilder.buildRequestUrl(
                        client,
                        "http",
                        "/users/delete/" + username
                ),
                HttpMethod.DELETE,
                requestBuilder.buildAuthOnlyHttpRequestEntity(
                        client.getId(),
                        requestBuilder.buildAuthRequestUrl(
                                client,
                                "http"
                        )
                ),
                String.class
        );
    }
}
