package com.yash.rbs.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.yash.rbs.model.RoomAvaiable;
import com.yash.rbs.model.RoomType;
import com.yash.rbs.repository.RoomAvaiableRepo;
import com.yash.rbs.repository.RoomTypeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomDateFilter implements Filter {
	
	@Autowired
	RoomAvaiableRepo roomAvaiableRepo;
	
	@Autowired
	RoomTypeRepo roomTypeRepo;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		/*
		 * Optional<RoomAvaiable> lastrow = roomAvaiableRepo.findTopByOrderByIdDesc();
		 * if (lastrow.isEmpty() || lastrow.isPresent()) { LocalDate now =
		 * LocalDate.now();
		 * 
		 * LocalDate start; if (lastrow.isPresent()) { String str_date =
		 * lastrow.get().getAvaiableDate().toString(); String[] array =
		 * str_date.split("\\ "); start = LocalDate.parse(array[0]); } else { start =
		 * now; } //start = now; LocalDate target = start.plusDays(10);
		 * java.util.List<RoomType> list = roomTypeRepo.findAll();
		 * 
		 * for (RoomType obj : list) { Integer tempCount = obj.getMaxCapaity();
		 * System.out.println(obj.getRoomTypes()); while (!start.isEqual(target) &&
		 * obj.getRoomTypeid() == 5) { start = start.plusDays(1); RoomAvaiable
		 * roomAvaiable = new RoomAvaiable(); Date avdate =
		 * java.sql.Date.valueOf(start); roomAvaiable.setAvaiableDate(avdate);
		 * roomAvaiable.setCount(tempCount); roomAvaiable.setRoomType(obj);
		 * roomAvaiableRepo.save(roomAvaiable); }
		 * 
		 * }
		 * 
		 * }
		 */
		
		chain.doFilter(request, response);
		
	}

}
