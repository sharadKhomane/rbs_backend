package com.yash.rbs.service;

import java.util.List;
import java.util.Optional;

import com.yash.rbs.model.RegisterResponseModel;
import com.yash.rbs.model.RoomType;
import com.yash.rbs.model.RoomTypeDTO;
import com.yash.rbs.repository.RoomTypeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeServiceImpl {
	
	@Autowired
	RoomTypeRepo roomTypeRepo;
	
	public RegisterResponseModel saveRoomType(RoomTypeDTO roomType) {
		Optional<RoomType> roomTypeCheck=roomTypeRepo.findByRoomTypes(roomType.getRoomTypes());
		RegisterResponseModel response=new RegisterResponseModel();
		if(roomTypeCheck.isEmpty())
		{	
			RoomType obj=new RoomType();
			obj.setRoomTypes(roomType.getRoomTypes());
			obj.setPrice(roomType.getPrice());
			obj.setMaxCapaity(roomType.getMaxCapaity());
			roomTypeRepo.save(obj);
			response.setResult(true);
			response.setMessage("Room type added");
		}
		else
		{
			response.setResult(false);
			response.setMessage("Room type already present please try with another room type");
		}
		return response;
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

