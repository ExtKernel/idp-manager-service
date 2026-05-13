package com.tes.idpmanagerservice.win;

import com.tes.idpmanagerservice.idp.GenericIdpModelExistenceValidator;
import com.tes.idpmanagerservice.idp.IdpUserManager;
import com.tes.idpmanagerservice.idp.IdpUsergroupManager;
import com.tes.idpmanagerservice.model.WinClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WinIdpModelExistenceValidator extends GenericIdpModelExistenceValidator<WinClient> {
    @Autowired
    public WinIdpModelExistenceValidator(
            IdpUsergroupManager<WinClient> usergroupManager,
            IdpUserManager<WinClient> userManager
    ) {
        super(
                usergroupManager,
                userManager
        );
    }
}
