package com.example.votingSystem.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.votingSystem.com.Repository.AdminRepository;
import com.example.votingSystem.com.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	@Override
	public void saveAdmin(Admin admin)
	{
		adminRepository.save(admin);
	}
	
	@Override
	public List<Admin>adminList()
	{
		List<Admin>find=adminRepository.findAll();
		return find;
	}
	
	@Override
	public Admin getAdmin(int id)
	{
		Admin a=adminRepository.getById(id);
		return a;
		
	}
}
