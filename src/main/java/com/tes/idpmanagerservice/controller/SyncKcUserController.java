package com.tes.idpmanagerservice.controller;

import com.tes.idpmanagerservice.idp.IdpUserManager;
import com.tes.idpmanagerservice.model.SyncKcClient;
import com.tes.idpmanagerservice.model.User;
import com.tes.idpmanagerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/kc/user")
@RestController
public class SyncKcUserController {
    private final IdpUserManager<SyncKcClient> userManager;
    private final ClientService<SyncKcClient> clientService;

    @Autowired
    public SyncKcUserController(
            IdpUserManager<SyncKcClient> userManager,
            ClientService<SyncKcClient> clientService
    ) {
        this.userManager = userManager;
        this.clientService = clientService;
    }

    @PostMapping("/{client}")
    public User createUser(
            @PathVariable String client,
            User user
    ) {
        return this.userManager.createUser(
                this.clientService.findById(client),
                user,
                true
        );
    }
}
