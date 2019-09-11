package com.example.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.restapi.entity.staff;

public interface StaffRepository extends CrudRepository<staff, Integer> {


    @Query("SELECT s FROM staff s where s.designation like :designation") 
	List<staff> findByDescription(String designation);
}
