package com.yash.rbs.service;

import com.yash.rbs.model.Feedback;
import com.yash.rbs.model.LoginDto;
import com.yash.rbs.model.RegisterResponseModel;
import com.yash.rbs.model.User;

public interface LoginService {

	Boolean checkLogin(LoginDto loginDto);

	RegisterResponseModel register(User registerDto);

	Boolean adminLogin(LoginDto loginDto);

	RegisterResponseModel addFeedback(Feedback feedback);

}
