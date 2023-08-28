package com.gml.client.application.validation;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gml.client.domain.validation.exception.ClientException;

public class ArgumentValidation {

	static Logger logger = LoggerFactory.getLogger(ArgumentValidation.class);

	private static final String MAIL_REGEX_PATTERN = "^(.+)@(\\S+)$";

	private static final String NUMBER_REGEX_PATTERN = "^\\d{10}$";

	private static final String MAIL_INVALID = "The email is invalid";

	private static final String FULL_NAME_INVALID = "The name has a different number of two nouns";

	private static final String PHONE_INVALID = "The phone number it´s not valid";

	private ArgumentValidation() {
	}

	public static void validateMail(String mail) {
		if (!Pattern.compile(MAIL_REGEX_PATTERN).matcher(mail).matches()) {
			logger.error("Email it is invalid");
			throw new ClientException(MAIL_INVALID);
		}
	}

	public static void validateFullName(String fullName) {
		String[] arrayName = fullName.split(" ");
		if (arrayName.length != 2) {
			logger.error(
					"The name does not meet the parameter to generate the sharedkey, they must be a first name and a last name");
			throw new ClientException(FULL_NAME_INVALID);
		}
	}

	public static void validatePhoneNumber(String phoneNumber) {
		if (!Pattern.compile(NUMBER_REGEX_PATTERN).matcher(phoneNumber).matches()) {
			logger.error("Number of phone invalid");
			throw new ClientException(PHONE_INVALID);
		}
	}

}
