package com.yash.rbs.restController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yash.rbs.model.RegisterResponseModel;
import com.yash.rbs.model.Room;
import com.yash.rbs.model.RoomDto;
import com.yash.rbs.model.RoomTypeJoinDTO;
import com.yash.rbs.service.RoomServiceImpl;
import com.yash.rbs.util.DateUtil;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Room manage controller
 * @author sharad.khomane
 *
 */

@RestController
@CrossOrigin("http://localhost:4200")
public class RoomController {
	@Autowired
	RoomServiceImpl roomService;

	@PostMapping("/addRoom")
	public RegisterResponseModel saveRoom(@RequestBody RoomDto room2) {
		return roomService.saveRoom(room2);
	}

	@GetMapping("/allRoom")
	public ResponseEntity<List<RoomTypeJoinDTO>> allRoom() {
		List<Room> room = roomService.findAllRoom();
		ResponseEntity<List<RoomTypeJoinDTO>> response;
		List<RoomTypeJoinDTO> roomTypeJoinDto=new ArrayList<>();
		for(Room obj:room)
		{
			String createdDate=DateUtil.convertTimeStampDateString(obj.getCreatedDate().getTime());
			String updatedDate=DateUtil.convertTimeStampDateString(obj.getUpdatedDate().getTime());
			RoomTypeJoinDTO objdto=new RoomTypeJoinDTO();
			objdto.setRoomId(obj.getRoomId());
			objdto.setRoomNumber(obj.getRoomNumber());
			objdto.setCreatedDate(createdDate);
			objdto.setStatus(obj.getStatus());
			objdto.setUpdatedDate(updatedDate);
			roomTypeJoinDto.add(objdto);
		}
		
		if (room != null) {
			response = new ResponseEntity<List<RoomTypeJoinDTO>>(roomTypeJoinDto,HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;

	}

	@RequestMapping(value = "/allRoom/{roomNumber}", method = RequestMethod.GET)
	public ResponseEntity<List<Room>> findByNumber(@PathVariable("roomNumber") Integer roomNumber) {
		/*
		 * List<Room> rooms = roomService.findRoomNumber(roomNumber); if
		 * (rooms.isEmpty()) { return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
		 * return new ResponseEntity<>(rooms, HttpStatus.OK);
		 */
		return null;
	}
	
	
	@DeleteMapping("/deleteRoom/{roomId}")
	public Boolean deleteRoomId(@PathVariable("roomId") Integer roomId){
		
		return roomService.delete(roomId);
	}
	
	
	
	
	
	 
}











