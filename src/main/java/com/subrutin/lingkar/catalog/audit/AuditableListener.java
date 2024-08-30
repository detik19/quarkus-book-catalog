package com.subrutin.lingkar.catalog.audit;

import com.subrutin.lingkar.catalog.util.SecurityUtil;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@RequestScoped
public class AuditableListener {

    @Inject
    private SecurityUtil securityUtil;

    @PrePersist
    void preCreate(Auditable auditable) {
        if (securityUtil.getCurrentUsername() != null) {
            auditable.setCreatedBy(securityUtil.getCurrentUsername());
            auditable.setUpdatedBy(securityUtil.getCurrentUsername());
        } else {
            auditable.setCreatedBy("SYSTEM");
            auditable.setUpdatedBy("SYSTEM");
        }

    }

    @PreUpdate
    void preUpdate(Auditable auditable) {
        if (securityUtil.getCurrentUsername() != null) {
            auditable.setUpdatedBy(securityUtil.getCurrentUsername());
        } else {
            auditable.setUpdatedBy("SYSTEM");
        }
    }

}
