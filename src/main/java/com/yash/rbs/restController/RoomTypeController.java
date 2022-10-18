package com.yash.rbs.restController;

import java.util.List;

import com.yash.rbs.model.RoomType;
import com.yash.rbs.model.RoomTypeDTO;
import com.yash.rbs.service.RoomTypeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rbs")
@CrossOrigin("http://localhost:4200")
public class RoomTypeController {
	@Autowired
	RoomTypeServiceImpl roomTypeService;
	
	@PostMapping("/addRoomType")
	public Boolean saveRoomType(@RequestBody RoomTypeDTO roomType){
		return roomTypeService.saveRoomType(roomType);
		
	}
	
	@GetMapping("/allRoomType")
	public List<RoomType> allRoom() {
		List<RoomType> room = roomTypeService.findAllRoomType();
		ResponseEntity<List<RoomType>> response;
		if (room != null) {
			response = new ResponseEntity<List<RoomType>>(HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return room;
	}

	@DeleteMapping("/deleteRoomType/{roomTypeId}")
	public Boolean deleteByRoomTypeId(@PathVariable Integer roomTypeId) {
		return roomTypeService.deleteRoomType(roomTypeId);
	}
}
