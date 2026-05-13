package com.tes.idpmanagerservice.ipa;

import com.tes.idpmanagerservice.idp.GenericIdpModelExistenceValidator;
import com.tes.idpmanagerservice.idp.IdpUserManager;
import com.tes.idpmanagerservice.idp.IdpUsergroupManager;
import com.tes.idpmanagerservice.model.IpaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IpaIdpModelExistenceValidator extends GenericIdpModelExistenceValidator<IpaClient> {
    @Autowired
    public IpaIdpModelExistenceValidator(
            IdpUsergroupManager<IpaClient> usergroupManager,
            IdpUserManager<IpaClient> userManager
    ) {
        super(
                usergroupManager,
                userManager
        );
    }
}
