package com.example.demo.dto;

public class SimpleResponse {

	private boolean statusOk;
	private String message;

	public SimpleResponse() {
		statusOk = false;
		message = "Ocorreu um erro :(";
	}

	public boolean isStatusOk() {
		return statusOk;
	}

	public String getMessage() {
		return message;
	}

	public void setStatusOk(boolean aStatusOk) {
		statusOk = aStatusOk;
	}

	public void setMessage(String aMessage) {
		message = aMessage;
	}
	
	public void setAsError() {
		statusOk = false;
		message = "Ocorreu um erro :(";
	}
	
	public void setAsSucess(String aMessage) {
		statusOk = true;
		message = aMessage;
	}

}
