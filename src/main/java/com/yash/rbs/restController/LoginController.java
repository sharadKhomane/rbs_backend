package com.yash.rbs.restController;

import com.yash.rbs.model.Feedback;
import com.yash.rbs.model.LoginDto;
import com.yash.rbs.model.RegisterResponseModel;
import com.yash.rbs.model.RoomType;
import com.yash.rbs.model.User;
import com.yash.rbs.security.AES_ENCRYPTION;
import com.yash.rbs.service.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Login manage controller
 * @author sharad.khomane
 *
 */

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	Logger logger= LoggerFactory.getLogger(LoginController.class); 
	
	/* created by sharad login api start - 06-10-2022  */
	@PostMapping("/login")
	public  boolean login(@RequestBody LoginDto loginDto)
	{
		Boolean check=loginService.checkLogin(loginDto);
		return check;
	}
	/* created by sharad login api end - 06-10-2022  */
	
	/* created by sharad admin login api start - 07-10-2022  */
	@PostMapping("/adminLogin")
	public  boolean Adminlogin(@RequestBody LoginDto loginDto)
	{
		Boolean check=loginService.adminLogin(loginDto);
		return check;
	}
	/* created by sharad admin login api end - 07-10-2022  */
	
	/* created by User registration api start - 05-10-2022  */
	@PostMapping("/register")
	public  ResponseEntity<RegisterResponseModel> login(@RequestBody User registerDto)
	{
		RegisterResponseModel registerObj=loginService.register(registerDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(registerObj);
	}
	/* created by User registration api end - 05-10-2022  */
	
	/* created by User feedback api start - 17-10-2022  */
	@PostMapping("/addFeedback")
	public  ResponseEntity<RegisterResponseModel> login(@RequestBody Feedback feedback)
	{
		RegisterResponseModel registerObj=loginService.addFeedback(feedback);
		return ResponseEntity.status(HttpStatus.CREATED).body(registerObj);
	}
	/* created by User feedback api end - 17-10-2022  */

}
