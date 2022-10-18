package com.yash.rbs.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.yash.rbs.model.Room;
import com.yash.rbs.model.RoomDto;
import com.yash.rbs.model.RoomType;
import com.yash.rbs.model.RoomTypeJoinDTO;
import com.yash.rbs.repository.RoomRepo;
import com.yash.rbs.repository.RoomTypeRepo;
import com.yash.rbs.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepo roomRepo;
	
	@Autowired
	RoomTypeRepo roomTypeRepo;

	public List<Room> findAllRoom() {
		return roomRepo.findAll();
	}

	public List<Room> findRoomNumber(Integer roomNumber) {
		return roomRepo.findByRoomNumber(roomNumber);
	}
	
	public Boolean saveRoom(RoomDto roomdto) {
		Room room=new Room();
		RoomType roomType=roomTypeRepo.findByRoomTypeid(roomdto.getrTypes());
		if(roomType!=null)
		{
			
			room.setRoomNumber(roomdto.getRoomNumber());
			room.setCreatedDate(DateUtil.getCurrentDateTime());
			room.setUpdatedDate(DateUtil.getCurrentDateTime());
			room.setStatus(true);
			room.setRoomType(roomType);
			roomRepo.save(room);
			return true;
		}
		else
		{
			throw new NullPointerException();
		}
	  
	}
	
	
	public Boolean delete(Integer roomId) {	
		//roomRepo.deleteById(roomId);
		Room room=roomRepo.findById(roomId).get();
		Boolean status=false;
		if(room!=null)
		{
			room.setStatus(false);
			roomRepo.save(room);
			status=true;
		}
		else
		{
			throw new NullPointerException();
		}
		return status;
	}

}







