package com.example.votingSystem.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.votingSystem.com.Repository.ElectionRepository;
import com.example.votingSystem.com.entity.Election;

@Service
public class ElectionServiceImplements implements ElectionService{
	
	@Autowired
	ElectionRepository electionRepository;
	
	public void saveElection(Election e) {
		electionRepository.save(e);
	}
	
	public List<Election>elecList()
	{
		return electionRepository.findAll();
	}

}
