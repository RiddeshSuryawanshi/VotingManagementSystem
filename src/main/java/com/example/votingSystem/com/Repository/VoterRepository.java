package com.example.votingSystem.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votingSystem.com.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer> {


}
