package com.yash.rbs.model;

import java.sql.Timestamp;

public class RoomTypeJoinDTO {
	
	private Integer roomId;
	private Integer roomNumber;
	private String createdDate;
	private String updatedDate;
	private Boolean status;
	private Integer roomTypeid;	
	private Integer maxCapaity;
	private Double price;
	private String roomTypes;
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Integer getRoomTypeid() {
		return roomTypeid;
	}
	public void setRoomTypeid(Integer roomTypeid) {
		this.roomTypeid = roomTypeid;
	}
	public Integer getMaxCapaity() {
		return maxCapaity;
	}
	public void setMaxCapaity(Integer maxCapaity) {
		this.maxCapaity = maxCapaity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRoomTypes() {
		return roomTypes;
	}
	public void setRoomTypes(String roomTypes) {
		this.roomTypes = roomTypes;
	}

}
