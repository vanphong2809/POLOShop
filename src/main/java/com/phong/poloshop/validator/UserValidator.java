package com.phong.poloshop.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.phong.poloshop.dao.entities.UserEntity;
import com.phong.poloshop.dao.repositories.UserRepository;

@Component
public class UserValidator implements Validator {
	private EmailValidator emailValidator = EmailValidator.getInstance();
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == UserEntity.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserEntity user = (UserEntity) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.user.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.user.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.user.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.user.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.user.phone");
		if (!errors.hasFieldErrors("userName")) {
			UserEntity dbUser = userRepository.findUserByUserName(user.getUserName());
			if (dbUser != null) {
				// Tên tài khoản đã bị sử dụng bởi người khác.
				errors.rejectValue("userName", "Duplicate.user.userName");
			}
		}
		if (!this.emailValidator.isValid(user.getEmail())) {
			errors.rejectValue("email", "Pattern.user.email");
		} else {
			UserEntity dbuser = userRepository.findUserByEmail(user.getEmail());
			if (dbuser != null) {
				errors.rejectValue("email", "Duplicate.user.email");
			}
		}

	}

}
