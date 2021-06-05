package com.phong.poloshop.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phong.poloshop.common.dto.ResponseDataDTO;
import com.phong.poloshop.dao.entities.CustomUserDetails;
import com.phong.poloshop.dao.entities.UserEntity;
import com.phong.poloshop.services.impl.UserService;
import com.phong.poloshop.validator.UserValidator;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		// Form mục tiêu
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == UserEntity.class) {
			dataBinder.setValidator(userValidator);
		}
		// ...
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseDataDTO<String> createUser(@RequestBody @Validated UserEntity user, BindingResult result) {
		ResponseDataDTO<String> response = new ResponseDataDTO<String>();
		if (result.hasErrors()) {
			if (result.getFieldError().getCode().contains("NotEmpty.user.userName")) {
				response.setMessage("Ten dang nhap la bat buoc");
				return response;
			}
			if (result.getFieldError().getCode().contains("NotEmpty.user.password")) {
				response.setMessage("Mat khau la bat buoc");
				return response;
			}
			if (result.getFieldError().getCode().contains("NotEmpty.user.email")) {
				response.setMessage("Email la bat buoc");
				return response;
			}
			if (result.getFieldError().getCode().contains("NotEmpty.user.address")) {
				response.setMessage("Dia chi la bat buoc");
				return response;
			}
			if (result.getFieldError().getCode().contains("NotEmpty.user.phone")) {
				response.setMessage("So dien thoai la bat buoc");
				return response;
			}
			if (result.getFieldError().getCode().contains("Duplicate.user.userName")) {
				response.setMessage("Ten tai khoan da ton tai");
				return response;
			}
			if (result.getFieldError().getCode().contains("Pattern.user.email")) {
				response.setMessage("Email khong hop le");
				return response;
			}	
			if (result.getFieldError().getCode().contains("Duplicate.user.email")) {
				response.setMessage("Email nay da duoc dang ky");
				return response;
			}
		} else {
			try {
				userService.register(user);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseDataDTO<UserEntity> findUserByEmail(@RequestParam("userName") String email) {
		ResponseDataDTO<UserEntity> response = new ResponseDataDTO<UserEntity>();
		CustomUserDetails user =(CustomUserDetails) userService.loadUserByUsername(email);
		response.setData(user.getUser());
		return response;
	}
//	@RequestMapping(value = "/{userName}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//	@ResponseBody
//	public ResponseDataDTO<UserEntity> findUserByUserName(@PathVariable String userName){
//		ResponseDataDTO<UserEntity> response=new ResponseDataDTO<UserEntity>();
//		UserEntity user=userService.findUserByUserName(userName);
//		response.setData(user);
//		return response;
//	}
}
