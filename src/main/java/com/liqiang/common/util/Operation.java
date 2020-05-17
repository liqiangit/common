package com.liqiang.common.util;

public class Operation {
	public Operation(String operation, String field) {
		super();
		this.operation = operation;
		this.field = field;
	}

	private String operation;
	private String field;
	private String operationfield;

	public void setOperationfield(String operationfield) {
		this.operationfield = operationfield;
	}

	public String getOperationfield() {
		if (operationfield != null) {
			return operationfield;
		}
		return field + operation;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
