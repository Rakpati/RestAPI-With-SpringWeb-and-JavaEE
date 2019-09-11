package com.example.restapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.entity.staff;
import com.example.restapi.repository.StaffRepository;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffRepository staffRepository;

	@PostMapping("/add")
	public staff addStaff(@RequestBody staff staff) {

		return staffRepository.save(staff);
	}

	@GetMapping("/all")
	public Iterable<staff> allStaff() {

		return staffRepository.findAll();
	}

	@GetMapping("/{staffId}")
	public Optional<staff> staffById(@PathVariable("staffId") int staffId) {

		return staffRepository.findById(staffId);
	}
	
	@GetMapping("/desc/{designation}")
	public Iterable<staff> staffByDescription(@PathVariable("designation") String designation) {

		return staffRepository.findByDescription(designation);
	}

	@PutMapping("/update")
	public staff updateStaff(@RequestBody staff staff) {

		return staffRepository.save(staff);
	}

	@DeleteMapping("/{staffId}")
	public void deleteStaff(@PathVariable("staffId") int staffId) {

		staffRepository.deleteById(staffId);
	}
}