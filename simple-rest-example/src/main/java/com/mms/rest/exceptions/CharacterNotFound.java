package com.mms.rest.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;;

@ResponseStatus(code = NOT_FOUND, reason = "Character doesn't found")
public class CharacterNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
}
