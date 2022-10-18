package com.yash.rbs.service;

import java.util.List;

import com.yash.rbs.model.RoomType;
import com.yash.rbs.model.RoomTypeDTO;
import com.yash.rbs.repository.RoomTypeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeServiceImpl {
	
	@Autowired
	RoomTypeRepo roomTypeRepo;
	
	public Boolean saveRoomType(RoomTypeDTO roomType) {
		RoomType obj=new RoomType();
		obj.setRoomTypes(roomType.getRoomTypes());
		obj.setPrice(roomType.getPrice());
		obj.setMaxCapaity(roomType.getMaxCapaity());
		roomTypeRepo.save(obj);
		return true;
	}
	
	public List<RoomType> findAllRoomType() {
		return roomTypeRepo.findAll();
	}

	public RoomType findRoomType(Integer id) {
		return roomTypeRepo.findByRoomTypeid(id);
	}
	
	public Boolean deleteRoomType(Integer roomTypeId) {
		Boolean check=false;
		RoomType roomType=roomTypeRepo.findByRoomTypeid(roomTypeId);
		if(roomType!=null) {
			roomTypeRepo.deleteById(roomTypeId);
			check=true;
		}
		return check;
	}
	
}

