package com.tes.idpmanagerservice.idp;

import com.tes.idpmanagerservice.model.Client;
import com.tes.idpmanagerservice.model.Usergroup;

import java.util.List;

/**
 * An interface for blacklisting user group related request results from a request sender.
 *
 * @param <T> a type of client from which the blacklist will be obtained.
 */
public interface UsergroupIdpRequestSenderResultBlackListFilter<T extends Client> extends IdpRequestSenderResultBlackListFilter<T, Usergroup> {
    @Override
    Usergroup filter(
            T client,
            Usergroup usergroupToFilter
    );

    @Override
    List<Usergroup> filter(
            T client,
            List<Usergroup> usergroupsToFilter
    );
}
