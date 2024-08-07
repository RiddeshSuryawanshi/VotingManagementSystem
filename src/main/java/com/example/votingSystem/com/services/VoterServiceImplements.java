package com.example.votingSystem.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.votingSystem.com.Repository.VoterRepository;
import com.example.votingSystem.com.entity.Admin;
import com.example.votingSystem.com.entity.Voter;

@Service
public class VoterServiceImplements implements VoterService{

	@Autowired
	VoterRepository voterRepository;
	
	@Override
	public Voter saveVoter(Voter voter) {
		voterRepository.save(voter);
		return voter;
	}

	@Override
	public List<Voter> voterlist() {
	    return voterRepository.findAll(); // Ensure this is not returning null
	}
	@Override
	public void deleteById(int id) {
		voterRepository.deleteById(id);
		
	}

	@Override
	public Voter findById(int id) {
		return voterRepository.findById(id).get();
	}

	@Override
	public Voter updateVoter(Voter voter) {
		return voterRepository.save(voter);
	}
	
	@Override
	public Voter getVoter(int id)
	{
		Voter a=voterRepository.getById(id);
		return a;
		
	}
}
