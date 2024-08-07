package com.example.votingSystem.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.votingSystem.com.Repository.ElectionRepository;
import com.example.votingSystem.com.entity.Election;
import com.example.votingSystem.com.entity.Voter;
import com.example.votingSystem.com.services.ElectionService;

@Controller
public class ElectionController {
	
	@Autowired
	ElectionRepository electionRepository;
	@Autowired
	ElectionService electionService;

	@GetMapping("/addelection")
	public String addElection(Model model)
	{
		model.addAttribute("election",new Election());
		return "addElection";
	}
	
    @PostMapping("/goElectionAdd")
    public String submitForm(@ModelAttribute("election") Election election , BindingResult result) {
        // handle form submission
    	electionService.saveElection(election);
    	System.out.println(election.toString());
        return "admindashboard";
    }
    
    //view All Election
    //view all
    @GetMapping("/viewAllElection")
    public String viewAllElection(Model model)
    {
    	List<Election>allelection=electionService.elecList();
    	model.addAttribute("elections",allelection);
    	for(Election e:allelection)
    	{
    		System.out.println(e);
    	}
    	return "viewAllElection";
    }
	
}