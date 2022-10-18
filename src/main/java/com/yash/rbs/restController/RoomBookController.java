package com.yash.rbs.restController;


import java.util.ArrayList;

import java.util.List;

import com.yash.rbs.model.BookedDetails;
import com.yash.rbs.model.RoomBookedDetails;
import com.yash.rbs.service.ReservedServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Room Book controller
 * @author sharad.khomane
 *
 */

@CrossOrigin("http://localhost:4200")
@RestController
public class RoomBookController {
	@Autowired
    ReservedServiceImpl reservedService;
	
	@PostMapping("/addBookDetails")
	public ResponseEntity bookedRoom(@RequestBody BookedDetails bookedDetails)
	{
		
		  RoomBookedDetails roomBookedDetails= reservedService.bookedRoom(bookedDetails);
		  List<RoomBookedDetails> list=new ArrayList<>();
		  list.add(roomBookedDetails);
		  return  ResponseEntity.status(HttpStatus.OK).body(list);
	}
}
