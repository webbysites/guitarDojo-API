package com.guitardojo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guitardojo.api.models.StaffMember;
import com.guitardojo.api.repositories.StaffMemberRepository;

@RestController
@RequestMapping("/staff")
public class StaffMemberController {
	
	@Autowired
	private StaffMemberRepository memberRepo;
	
	@GetMapping("/getAll")
	public List<StaffMember> getStaffMembers() {
		return memberRepo.findAll();
	}
	
	@GetMapping("/get")
	public Object getThisContact(@RequestParam String id) {
		return memberRepo.findById(id);
	}

}
