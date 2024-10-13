package com.eteration.simplebanking.controller;

public class TransactionStatus {
    private String status; // İşlem durumu (örn: "OK", "FAILED")
    private String approvalCode; // Onay kodu

    // Constructor
    public TransactionStatus(String status, String approvalCode) {
        this.status = status;
        this.approvalCode = approvalCode;
    }

    // Getter ve Setter metodları
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
}