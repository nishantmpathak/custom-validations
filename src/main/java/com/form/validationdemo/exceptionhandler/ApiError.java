package com.form.validationdemo.exceptionhandler;

import io.micrometer.common.util.StringUtils;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ApiError {
    private String errorId;
    private String message;
    private List<ErrorDetails> details = new ArrayList<>();

    public void setMessage(String message){
        this.message = message;
    }

    public void setErrorId(ApplicationErrorId errorId){
        this.errorId = errorId.getErrorCode();
    }

    public void addDetails(String path, String field, String issue){
        details.add( new ErrorDetails(path, field, issue));
    }

    @Data
    public class ErrorDetails{
        private final String path;
        private final String field;
        private final String issue;

        public ErrorDetails(String path, String field, String issue){
            this.path = path;
            if(!StringUtils.isBlank(path) && !StringUtils.isBlank(field)){
                this.field = path+"."+field;
            }else{
                this.field = field;
            }
            this.issue = issue;
        }
    }

    @Override
    public String toString(){
        return "ApiError{errorId= '"+errorId+"' , message= '"+message+"' , details = "+details+"}";
    }
}
