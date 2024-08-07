package com.example.votingSystem.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.votingSystem.com.Repository.AdminRepository;
import com.example.votingSystem.com.Repository.VoterRepository;
import com.example.votingSystem.com.entity.Admin;
import com.example.votingSystem.com.entity.Voter;
import com.example.votingSystem.com.services.AdminService;
import com.example.votingSystem.com.services.VoterService;

import jakarta.validation.Valid;

@Controller
public class AdminController {
	
	   @Autowired
	   AdminRepository adminRepository;
	   
	   @Autowired
	   AdminService adminService;
       
		@Autowired 
		VoterRepository voterRepository;
		
		@Autowired
		VoterService voterService;
	   
		//admin Login
	   @GetMapping("/")
	   public String loginOpen(Model model)
	   {
		   model.addAttribute("admin",new Admin());
		   return "login";
	   }
	   
	   @PostMapping("/goadminlogin")
	   public String getLoginAdmin(@ModelAttribute("admin") Admin admin)
	   {
		   int id=admin.getId();
		   String password=admin.getPassword();
		   Admin newAdmin = adminService.getAdmin(admin.getId());
		   if (newAdmin != null && newAdmin.getPassword().equals(password)) {
	           return "admindashboard";
	       }
	       return "fail"; 
	   }
	   
	   
	   
	   @GetMapping("/admindashboard")
	   public String goAdminDashboard(Model model)
	   {
		   model.addAttribute("admin",new Admin());
		   return "admindashboard";
	   }
	   
	   
	   //Register Admin
	
	   @GetMapping("/saveAdmin")
       public String saveAdmin(Model model)
       {
		  model.addAttribute("admin",new Admin());
    	  return "adminRegister";   
       }
	   
	   @PostMapping("/goadminregister")
	   public String getAdminStatus(@ModelAttribute("admin") Admin admin)
	   {
		   System.out.println("ok");
		   adminService.saveAdmin(admin);
		   System.out.println("ok");
		   System.out.println(admin.toString());
		   return "login";
	   }
	   
	   //update Admin
	   
	   @GetMapping("/updateAdmin")
	   public String updateAdmin(Model model)
	   {
		   model.addAttribute("admin",new Admin());
		   return "updateAdmin";
	   }
	   
	   @PostMapping("/goAdminUpdate")
	   public String getUpdateAdmin(@ModelAttribute("admin") Admin admin)
	   {
		   Admin newAdmin=adminService.getAdmin(admin.getId());
		   newAdmin.setAddress(admin.getAddress());
		   newAdmin.setDOB(admin.getDOB());
		   newAdmin.setGender(admin.getGender());
		   newAdmin.setName(admin.getName());
		   newAdmin.setPassword(admin.getPassword());
		   newAdmin.setUsername(admin.getUsername());
		   
		   adminService.saveAdmin(newAdmin);
		   System.out.println(admin.toString());
		   return "login";
	   }
	   
	   
	   
	   

	  
}

