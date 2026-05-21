package com.tes.idpmanagerservice.controller;

import com.tes.idpmanagerservice.idp.IdpUsergroupManager;
import com.tes.idpmanagerservice.model.IpaClient;
import com.tes.idpmanagerservice.model.User;
import com.tes.idpmanagerservice.model.Usergroup;
import com.tes.idpmanagerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping("/{client}/{usergroupName}")
    public void addUsergroupMember(
            @PathVariable String client,
            @PathVariable String usergroupName,
            @RequestParam String username
    ) {
        this.usergroupManager.addUsergroupMember(
                this.clientService.findById(client),
                usergroupName,
                username,
                true
        );
    }

    @GetMapping("/{client}/{usergroupName}")
    public Usergroup getUsergroup(
            @PathVariable String client,
            @PathVariable String usergroupName
    ) {
        return this.usergroupManager.getUsergroup(
                this.clientService.findById(client),
                usergroupName,
                true
        );
    }

    @GetMapping("/{client}")
    public List<Usergroup> getUsergroups(@PathVariable String client) {
        return this.usergroupManager.getUsergroups(this.clientService.findById(client));
    }

    @GetMapping("/{client}/{usergroupName}")
    public List<User> getUsergroupMembers(
            @PathVariable String client,
            @PathVariable String usergroupName
    ) {
        return this.usergroupManager.getUsergroupMembers(
                this.clientService.findById(client),
                usergroupName,
                true
        );
    }

    @DeleteMapping("/{client}/{usergroupName}")
    public void deleteUsergroup(
            @PathVariable String client,
            @PathVariable String usergroupName
    ) {
        this.usergroupManager.deleteUsergroup(
                this.clientService.findById(client),
                usergroupName,
                true
        );
    }

    @DeleteMapping("/{client}/{usergroupName}")
    public void deleteUsergroup(
            @PathVariable String client,
            @PathVariable String usergroupName,
            @RequestParam String username
    ) {
        this.usergroupManager.removeUsergroupMember(
                this.clientService.findById(client),
                usergroupName,
                username,
                true
        );
    }
}
