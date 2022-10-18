package com.yash.rbs.service;

import java.util.List;

import com.yash.rbs.model.RoomType;
import com.yash.rbs.model.RoomTypeDTO;

public interface RoomTypeService {

	Boolean saveRoomType(RoomTypeDTO roomType);
	List<RoomType> findAllRoomType();
	RoomType findRoomType(Integer id);
	Boolean deleteRoomType(Integer roomTypeId);
}
