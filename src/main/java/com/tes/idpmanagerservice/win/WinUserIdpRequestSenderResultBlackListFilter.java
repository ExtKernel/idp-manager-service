package com.tes.idpmanagerservice.win;

import com.tes.idpmanagerservice.idp.GenericUserIdpRequestSenderResultBlackListFilter;
import com.tes.idpmanagerservice.model.WinClient;
import org.springframework.stereotype.Component;

@Component
public class WinUserIdpRequestSenderResultBlackListFilter extends GenericUserIdpRequestSenderResultBlackListFilter<WinClient> {
}
