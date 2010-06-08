package com.mariya.enums;

public enum OrderStatus {

    InProgress(1),
    Canceled(2),
    Finished(3);

    private int status;

    OrderStatus(int status) {
        this.status = status;
    }

    public int getStatusValue(){
        return status;
    }
}