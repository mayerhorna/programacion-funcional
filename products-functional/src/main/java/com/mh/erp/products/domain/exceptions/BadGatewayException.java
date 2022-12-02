package com.mh.erp.products.domain.exceptions;

public class BadGatewayException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Bad Gateway Exception";

    public BadGatewayException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
