package com.example.votingSystem.com.services;

import org.springframework.stereotype.Service;
import java.util.*;

import com.example.votingSystem.com.entity.Admin;
import com.example.votingSystem.com.entity.Voter;

@Service
public interface VoterService {
	
   public Voter saveVoter(Voter voter);
   public List<Voter>voterlist();
   public void deleteById(int id);
   public Voter findById(int id);
   public Voter updateVoter(Voter voter);
   public Voter getVoter(int id);
   
}
