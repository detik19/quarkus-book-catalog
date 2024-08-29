package com.subrutin.lingkar.catalog.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractBaseUUIDEntity extends AbstractBaseEntity {

    @Column(name = "secure_id")
    private UUID secureId = UUID.randomUUID();
}
