package com.tes.idpmanagerservice.kc;

import com.tes.idpmanagerservice.idp.GenericIdpModelExistenceValidator;
import com.tes.idpmanagerservice.idp.IdpUserManager;
import com.tes.idpmanagerservice.idp.IdpUsergroupManager;
import com.tes.idpmanagerservice.model.SyncKcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SyncKcIdpModelExistenceValidator extends GenericIdpModelExistenceValidator<SyncKcClient> {
    @Autowired
    public SyncKcIdpModelExistenceValidator(
            IdpUsergroupManager<SyncKcClient> usergroupManager,
            IdpUserManager<SyncKcClient> userManager
    ) {
        super(
                usergroupManager,
                userManager
        );
    }
}
