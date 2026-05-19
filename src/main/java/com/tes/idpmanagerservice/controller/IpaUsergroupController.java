package com.tes.idpmanagerservice.controller;

import com.tes.idpmanagerservice.idp.IdpUsergroupManager;
import com.tes.idpmanagerservice.model.IpaClient;
import com.tes.idpmanagerservice.model.Usergroup;
import com.tes.idpmanagerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ipa/user")
@RestController
public class IpaUsergroupController {
    private final IdpUsergroupManager<IpaClient> usergroupManager;
    private final ClientService<IpaClient> clientService;

    @Autowired
    public IpaUsergroupController(
            IdpUsergroupManager<IpaClient> usergroupManager,
            ClientService<IpaClient> clientService
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
