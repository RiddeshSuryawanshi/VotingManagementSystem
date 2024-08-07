package com.example.votingSystem.com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.votingSystem.com.Repository.VoterRepository;
import com.example.votingSystem.com.entity.Admin;
import com.example.votingSystem.com.entity.Voter;
import com.example.votingSystem.com.services.VoterService;

@Controller
public class VoterController {

	@Autowired 
	VoterRepository voterRepository;
	
	@Autowired
	VoterService voterService;
	
	@PostMapping("/govoterlogin")
	   public String getVoterAdmin(@ModelAttribute("admin") Admin admin,Model model)
	   {
		   int id=admin.getId();
		   String password=admin.getPassword();
		   Voter v=voterService.getVoter(admin.getId());
		   if (v != null && v.getPassword().equals(password)) {
			   model.addAttribute("name", v.getVoterName());
	           return "voterdashboard";
	       }
	       return "fail"; 
	   }
	
	//add voter
	
	@GetMapping("/addVoter")
	public String addvoterOpen(Model model)
	{
		 model.addAttribute("voter", new Voter());
	     return "addVoter";	
	}
    
    @PostMapping("/goVoterRegister")
    public String submitForm(@ModelAttribute("voter") Voter voter, BindingResult result) {
        // handle form submission
    	 voterService.saveVoter(voter);
		   System.out.println(voter.toString());
        return "admindashboard";
    }
    
    @GetMapping("/voterdashboard")
	public String openDashboard(Model model)
	{
		 model.addAttribute("voter", new Voter());
	     return "voterdashboard";	
	}
    
    
 
    //delete Voter
    
    @GetMapping("/delete/{id}")
    public String openDeleteButton(@PathVariable Integer id) {
        voterService.deleteById(id);
        return "redirect:/admindashboard";
    }
    @PostMapping("/godeleteVoter")
    public String deleteVoter(@ModelAttribute("voter") Voter voter, BindingResult result) {
       voterService.deleteById(voter.getId());
        return "admindashboard";
    }
    
    @GetMapping("/deleteVoter")
    public String openDeleteVoter(Model model) {
    	model.addAttribute("voter", new Voter());
    	return "deleteVoter";
    }
    
    
    //view all
    @GetMapping("/viewAllVoter")
    public String viewAllUser(Model model)
    {
    	List<Voter>voters=voterService.voterlist();
    	model.addAttribute("voters",voters);
    	for(Voter v:voters)
    	{
    		System.out.println(v);
    	}
    	return "viewAllVoter";
    }
    
    //view one Admin DashBoard
    
    @GetMapping("/viewOne")
    public String openVIewOne(Model model)
    {
    	model.addAttribute("voter", new Voter());
    	return "viewOne";
    }
    
    @PostMapping("/goviewOne")
    public String findVoter(@ModelAttribute("voter") Voter voter,Model model)
    {
    	Voter v=voterService.findById(voter.getId());
    	model.addAttribute("voter",v);
    	return "viewOneDetails";
    }
    
    //view one for Voter dashboard
    
    @GetMapping("/viewOneVoter")
    public String openVIewOneVoter(Model model)
    {
    	model.addAttribute("voter", new Voter());
    	return "viewOneVoter";
    }
    
    @PostMapping("/goviewOneVoter")
    public String findVoterDashBoard(@ModelAttribute("voter") Voter voter,Model model)
    {
    	Voter v=voterService.findById(voter.getId());
    	model.addAttribute("voter",v);
    	return "viewOneDetailsVoter";
    }
    
    //update 
    @GetMapping("/updateVoter")
    public String openUpadte(Model model)
    {
    	model.addAttribute("voter", new Voter());
    	return "updateVoter";
    }
    
    @PostMapping("/goVoterUpdate")
	   public String getUpdateVoter(@ModelAttribute("voter") Voter voter,BindingResult result)
	   {
		   Voter newVoter=voterService.getVoter(voter.getId());
		   newVoter.setDOB(voter.getDOB());
		   newVoter.setGender(voter.getGender());
		   newVoter.setPassword(voter.getPassword());
		   newVoter.setUsername(voter.getUsername());
		   newVoter.setVoterName(voter.getVoterName());
		   
		   voterService.saveVoter(newVoter);
		   System.out.println(voter.toString());
		   return  "redirect:/voterdashboard";
	   }
    
    
}

