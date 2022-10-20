package com.yash.rbs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.yash.rbs.model.RegisterResponseModel;
import com.yash.rbs.model.User;
import com.yash.rbs.service.LoginServiceImpl;

import org.hibernate.cache.internal.RegionFactoryInitiator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RbsApplicationTests {
	
	@Autowired
	LoginServiceImpl loginServiceImpl;

	@Test
	void registerUser_Check() {
		
		RegisterResponseModel registerExpected=new RegisterResponseModel();
		registerExpected.setResult(true);
		User user=new User();
		user.setEmailId("ram20@gmail.com");
		user.setFirstName("Sk");
		user.setLastName("KK");
		user.setPassword("Sk@1234");
		//user.setPhoneNo("99220290272");
		RegisterResponseModel registerActual=loginServiceImpl.register(user);
		assertEquals(registerExpected, registerActual);
	}

}
