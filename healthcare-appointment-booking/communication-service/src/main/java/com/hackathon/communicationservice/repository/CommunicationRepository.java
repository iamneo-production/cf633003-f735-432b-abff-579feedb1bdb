package com.hackathon.communicationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hackathon.communicationservice.entity.Communication;
@Repository
public interface CommunicationRepository extends JpaRepository<Communication,Integer> {
    
}
