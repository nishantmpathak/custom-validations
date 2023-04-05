package com.form.validationdemo.exceptionhandler;

import lombok.Getter;

public enum ApplicationErrorId {
    UNDOCUMENTED_ERROR("API-0000"),
    ValidationError("API-1001");
    @Getter private String errorCode;

    ApplicationErrorId(String errorCode){
        this.errorCode = errorCode;
    }
}
