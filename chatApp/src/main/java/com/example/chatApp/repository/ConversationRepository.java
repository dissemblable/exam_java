package com.example.chatApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.chatApp.model.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    
    List<Conversation> findByUserName(String userName);
    
    @Query("SELECT DISTINCT c.userName FROM Conversation c")
    List<String> findDistinctUserNames();
}
