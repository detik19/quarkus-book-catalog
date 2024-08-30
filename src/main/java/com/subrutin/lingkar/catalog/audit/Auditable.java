package com.subrutin.lingkar.catalog.audit;


public interface Auditable {
    
    void setCreatedBy(String createdBy);

    String getCreatedBy();

    void setUpdatedBy(String updatedBy);

    String getUpdatedBy();

}
