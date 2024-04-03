package com.example.msa.model;

import lombok.Builder;

@Builder
public record License(
         int id,
         String licenseId,
         String description,
         String organizationId,
         String productName,
         String licenseType
) {
    public License withOrganizationId(String newOrganizationId) {
        return new License(this.id, this.licenseId, this.description, newOrganizationId, this.productName, this.licenseType);
    }


}
