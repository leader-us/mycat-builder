package io.mycat.builder.bean;

import java.util.List;

/**
 * 用户输入的参数说明
 * 
 * @author leader us
 */
public class MyParamSpec {
    private String paramName;
    private String describe;
    private boolean nullable;
    private List<String> targetValues;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<String> getTargetValues() {
        return targetValues;
    }

    public void setTargetValues(List<String> targetValues) {
        this.targetValues = targetValues;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }
    
}