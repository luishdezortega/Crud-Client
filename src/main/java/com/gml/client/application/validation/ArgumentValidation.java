package com.gml.client.application.validation;

import java.util.regex.Pattern;

import com.gml.client.domain.validation.exception.ClientException;

public class ArgumentValidation {

	private static final String MAIL_REGEX_PATTERN = "^(.+)@(\\S+)$";

	private static final String NUMBER_REGEX_PATTERN = "^\\d{10}$";

	private static final String MAIL_INVALID = "The email is invalid";

	private static final String FULL_NAME_INVALID = "The name has a different number of two nouns";

	private static final String PHONE_INVALID = "The phone number it´s not valid";

	private ArgumentValidation() {
	}

	public static void validateMail(String mail) {
		if (!Pattern.compile(MAIL_REGEX_PATTERN).matcher(mail).matches()) {
			throw new ClientException(MAIL_INVALID);
		}
	}

	public static void validateFullName(String fullName) {
		String[] arrayName = fullName.split(" ");
		if (arrayName.length != 2) {
			throw new ClientException(FULL_NAME_INVALID);
		}
	}

	public static void validatePhoneNumber(String phoneNumber) {
		if (!Pattern.compile(NUMBER_REGEX_PATTERN).matcher(phoneNumber).matches()) {
			throw new ClientException(PHONE_INVALID);
		}
	}

}
