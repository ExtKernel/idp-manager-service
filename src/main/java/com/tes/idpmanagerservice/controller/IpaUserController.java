package com.tes.idpmanagerservice.controller;

import com.tes.idpmanagerservice.idp.IdpUserManager;
import com.tes.idpmanagerservice.model.IpaClient;
import com.tes.idpmanagerservice.model.User;
import com.tes.idpmanagerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ipa/user")
@RestController
public class IpaUserController {
    private final IdpUserManager<IpaClient> userManager;
    private final ClientService<IpaClient> clientService;

    @Autowired
    public IpaUserController(
            IdpUserManager<IpaClient> userManager,
            ClientService<IpaClient> clientService
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

    @GetMapping("/{client}/{username}")
    public User getUser(
            @PathVariable String client,
            @PathVariable String username
    ) {
        return this.userManager.getUser(
                this.clientService.findById(client),
                username,
                true
        );
    }

    @GetMapping("/{client}")
    public List<User> getUsers(@PathVariable String client) {
        return this.userManager.getUsers(this.clientService.findById(client));
    }

    @PatchMapping("/{client}/{username}")
    public String updateUserPassword(
            @PathVariable String client,
            @PathVariable String username,
            @RequestParam String newPassword
    ) {
        return this.userManager.updateUserPassword(
                this.clientService.findById(client),
                username,
                newPassword,
                true
        );
    }
    @DeleteMapping("/{client}/{username}")
    public void deleteUser(
            @PathVariable String client,
            @PathVariable String username
    ) {
        this.userManager.deleteUser(
                this.clientService.findById(client),
                username,
                true
        );
    }
}
