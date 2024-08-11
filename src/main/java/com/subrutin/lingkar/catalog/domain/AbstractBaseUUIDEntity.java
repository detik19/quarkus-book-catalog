package com.subrutin.lingkar.catalog.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractBaseUUIDEntity extends AbstractBaseEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "secure_id")
    private UUID secureId;
}
