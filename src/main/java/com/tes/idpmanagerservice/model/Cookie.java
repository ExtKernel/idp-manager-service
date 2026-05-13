package com.tes.idpmanagerservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Cookie extends AuthModel {
    private Long id;
    private String cookie;
    private Date creationDate;
}
