package com.example.votingSystem.com.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.votingSystem.com.entity.Election;

@Service
public interface ElectionService {
      
	public void saveElection(Election e);
	public List<Election>elecList();

}
