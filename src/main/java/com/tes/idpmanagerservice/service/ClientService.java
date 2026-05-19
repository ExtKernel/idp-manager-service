package com.tes.idpmanagerservice.service;

import com.tes.idpmanagerservice.model.Client;

public interface ClientService<ClientType extends Client> {
    ClientType findById(String id);
}
