package com.tes.idpmanagerservice.controller;

import com.tes.idpmanagerservice.idp.IdpUserManager;
import com.tes.idpmanagerservice.model.User;
import com.tes.idpmanagerservice.model.WinClient;
import com.tes.idpmanagerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/win/user")
@RestController
public class WinUserController {
    private final IdpUserManager<WinClient> userManager;
    private final ClientService<WinClient> clientService;

    @Autowired
    public WinUserController(
            IdpUserManager<WinClient> userManager,
            ClientService<WinClient> clientService
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
