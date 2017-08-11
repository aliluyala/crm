package com.synphoo.java.test.responseDto;

import com.ddcash.server.app.framework.utils.StringHelper;

public class Result {
    private boolean operationResult;  //接口执行结果：成功或失败
    private String operationStatus;       // 返回状态
    private String displayInfo;       // 返回结果
    public Result() {
        
    }
    
    public Result(boolean operationResult, String operationStatus, String displayInfo) {
        super();
        this.operationResult = operationResult;
        this.operationStatus = operationStatus;
        this.displayInfo = displayInfo;
    }

    public boolean isOperationResult() {
        return operationResult;
    }

    public void setOperationResult(boolean operationResult) {
        this.operationResult = operationResult;
    }
    
    public String getOperationStatus() {
    	if (StringHelper.isNullOrEmpty(operationStatus)) {
    		operationStatus = "";
		}
        return operationStatus;
    }

    public void setOperationStatus(String operationStatus) {
    	if (StringHelper.isNullOrEmpty(operationStatus)) {
    		operationStatus = "";
		}
        this.operationStatus = operationStatus;
    }

    public String getDisplayInfo() {
    	if (StringHelper.isNullOrEmpty(displayInfo)) {
    		displayInfo = "";
		}
        return displayInfo;
    }

    public void setDisplayInfo(String displayInfo) {
    	if (StringHelper.isNullOrEmpty(displayInfo)) {
    		displayInfo = "";
		}
        this.displayInfo = displayInfo;
    }

    
    
    

    
    
    
    
}
