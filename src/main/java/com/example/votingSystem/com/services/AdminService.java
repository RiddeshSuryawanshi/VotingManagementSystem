package com.example.votingSystem.com.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.votingSystem.com.entity.Admin;

@Service
public interface AdminService {

	public void saveAdmin(Admin admin);
	public List<Admin>adminList();
	public Admin getAdmin(int id);
}
