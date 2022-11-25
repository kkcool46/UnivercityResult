package com.jbk.api.exception;

public class ListNotFoundException extends RuntimeException {
	public ListNotFoundException (String mes){
		super(mes);
	}
}
