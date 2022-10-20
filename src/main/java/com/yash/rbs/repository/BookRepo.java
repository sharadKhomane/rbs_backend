package com.yash.rbs.repository;


import java.util.Date;
import java.util.List;

import com.yash.rbs.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepo extends JpaRepository<Book, Integer> {

	@Query(value = "from Book t where book_date BETWEEN :startDate AND :endDate")
	List<Book> getAllDateBetween(@Param("startDate")Date checkIn,@Param("endDate")Date checkout);

}
