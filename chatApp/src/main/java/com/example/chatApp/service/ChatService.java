package com.example.chatApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.chatApp.model.Conversation;
import com.example.chatApp.repository.ConversationRepository;

@Service
public class ChatService {

    private final ConversationRepository conversationRepository;
    private RestTemplate restTemplate;
    
    private static final String QUOTE_API_URL = "http://localhost:8081/quote";
    
    @Autowired
    public ChatService(ConversationRepository conversationRepository, RestTemplate restTemplate) {
        this.conversationRepository = conversationRepository;
        this.restTemplate = restTemplate;
    }
    
    public Conversation processMessage(Conversation conversation) {
        try {
            QuoteResponse quoteResponse = restTemplate.getForObject(QUOTE_API_URL, QuoteResponse.class);
            if (quoteResponse != null && quoteResponse.getContent() != null) {
                conversation.setResponse(quoteResponse.getContent());
            } else {
                conversation.setResponse("Désolé, aucun conseil n'est disponible pour le moment.");
            }
        } catch (Exception e) {
            conversation.setResponse("Erreur lors de la récupération d'une citation.");
        }
        conversation.setTimestamp(java.time.LocalDateTime.now());
        return conversationRepository.save(conversation);
    }
    
    public static class QuoteResponse {
        private String content;
        
        public QuoteResponse() {}
        
        public String getContent() {
            return content;
        }
        
        public void setContent(String content) {
            this.content = content;
        }
    }
}
