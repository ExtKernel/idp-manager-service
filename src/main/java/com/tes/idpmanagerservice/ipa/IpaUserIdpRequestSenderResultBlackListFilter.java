package com.tes.idpmanagerservice.ipa;

import com.tes.idpmanagerservice.idp.GenericUserIdpRequestSenderResultBlackListFilter;
import com.tes.idpmanagerservice.model.IpaClient;
import org.springframework.stereotype.Component;

@Component
public class IpaUserIdpRequestSenderResultBlackListFilter extends GenericUserIdpRequestSenderResultBlackListFilter<IpaClient> {
}
