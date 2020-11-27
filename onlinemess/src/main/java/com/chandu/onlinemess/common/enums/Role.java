package com.chandu.onlinemess.common.enums;

public enum Role {

    ADMIN, STUDENT, SECY, MANAGER, COUNTER;

    public String authority() {
        return name();
    }
}