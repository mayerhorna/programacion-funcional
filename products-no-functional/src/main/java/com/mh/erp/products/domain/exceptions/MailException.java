package com.mh.erp.products.domain.exceptions;

public class MailException extends ConflictException{

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Token with wrong format";

    public MailException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
