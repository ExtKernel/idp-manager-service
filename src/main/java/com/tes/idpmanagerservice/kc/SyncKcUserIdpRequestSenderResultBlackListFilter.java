package com.tes.idpmanagerservice.kc;

import com.tes.idpmanagerservice.idp.GenericUserIdpRequestSenderResultBlackListFilter;
import com.tes.idpmanagerservice.model.SyncKcClient;
import org.springframework.stereotype.Component;

@Component
public class SyncKcUserIdpRequestSenderResultBlackListFilter extends GenericUserIdpRequestSenderResultBlackListFilter<SyncKcClient> {
}
