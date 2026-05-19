package com.tes.idpmanagerservice.controller;

import com.tes.idpmanagerservice.idp.IdpUsergroupManager;
import com.tes.idpmanagerservice.model.Usergroup;
import com.tes.idpmanagerservice.model.WinClient;
import com.tes.idpmanagerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ipa/user")
@RestController
public class WinUsergroupController {
    private final IdpUsergroupManager<WinClient> usergroupManager;
    private final ClientService<WinClient> clientService;

    @Autowired
    public WinUsergroupController(
            IdpUsergroupManager<WinClient> usergroupManager,
            ClientService<WinClient> clientService
    ) {
        this.usergroupManager = usergroupManager;
        this.clientService = clientService;
    }

    @PostMapping("/{client}")
    public Usergroup createUsergroup(
            @PathVariable String client,
            Usergroup usergroup
    ) {
        return this.usergroupManager.createUsergroup(
                this.clientService.findById(client),
                usergroup,
                true
        );
    }
}
