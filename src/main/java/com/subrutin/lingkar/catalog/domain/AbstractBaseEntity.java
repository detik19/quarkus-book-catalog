package com.subrutin.lingkar.catalog.domain;

import java.io.Serializable;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.subrutin.lingkar.catalog.audit.CreatedBy;
import com.subrutin.lingkar.catalog.audit.UpdatedBy;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Version;

@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {
   
    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private Instant createdDate = Instant.now();

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false)
    private Instant updatedDate;



    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @UpdatedBy
    @Column(name = "updated_by", nullable = false, updatable = false)
    private String updatedBy;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name="deleted", columnDefinition = "boolean default false")
	private boolean deleted;

    public Instant getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }


    public String getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @PrePersist
    public void prePersist() {
    	this.deleted = Boolean.FALSE;
    }


    public String getUpdatedBy() {
        return updatedBy;
    }


    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }


    public boolean isDeleted() {
        return deleted;
    }


    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

     
    public Instant getUpdatedDate() {
        return updatedDate;
    }


    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }
}
