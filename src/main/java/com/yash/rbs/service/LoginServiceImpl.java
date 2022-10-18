package com.yash.rbs.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.yash.rbs.model.Feedback;
import com.yash.rbs.model.LoginDto;
import com.yash.rbs.model.RegisterResponseModel;
import com.yash.rbs.model.User;
import com.yash.rbs.repository.FeedbackRepo;
import com.yash.rbs.repository.UserRepo;
import com.yash.rbs.security.AES_ENCRYPTION;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AES_ENCRYPTION aes_ENCRYPTION;
	
	@Autowired
	FeedbackRepo feedbackRepo;

	@Override
	public Boolean checkLogin(LoginDto loginDto) {
		// TODO Auto-generated method stub
		Boolean check = false;
		User user = userRepo.findByEmailId(loginDto.getUsername());
		String decrypted_Password=null;
		try {
			decrypted_Password=aes_ENCRYPTION.decrypt(user.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user != null && decrypted_Password.equals(loginDto.getPassword())) {
			check = true;
			return check;
		}
		return check;
	}

	@Override
	public RegisterResponseModel register(User registerDto) {
		// TODO Auto-generated method stub
		Boolean check = false;
		String encrypted_Password = null;
		User user = userRepo.findByEmailId(registerDto.getEmailId());
		RegisterResponseModel response=new RegisterResponseModel();
		if(user!=null && user.getEmailId().equals(registerDto.getEmailId()))
		{
			response.setMessage("Email id already register please try with another emailId");
			response.setResult(false);
			return response;
		}
		try {
			encrypted_Password=aes_ENCRYPTION.encrypt(registerDto.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		LocalDateTime now= LocalDateTime.now();
		Timestamp today=java.sql.Timestamp.valueOf(now);
		registerDto.setCreateDate(today);
		registerDto.setUpdateDate(today);
		registerDto.setStatus(true);
		registerDto.setPassword(encrypted_Password);
		User user1=userRepo.save(registerDto);
		if(user1!=null)
		{
			response.setMessage("Register data successfully");
			response.setResult(true);
			return response;
		}
		return response;
	}

	@Override
	public Boolean adminLogin(LoginDto loginDto) {
		// TODO Auto-generated method stub
		Boolean check = false;
		User user = userRepo.findByEmailId(loginDto.getUsername());
		
		if (user != null && user.getPassword().equals(loginDto.getPassword())) {
			check = true;
			return check;
		}
		return check;
	}

	@Override
	public RegisterResponseModel addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		RegisterResponseModel registerResponseModel=new RegisterResponseModel();
		if(feedbackRepo.save(feedback) != null)
		{
			registerResponseModel.setMessage("Feedback added successfully");
			registerResponseModel.setResult(true);
		}
		return registerResponseModel;
	}

}
