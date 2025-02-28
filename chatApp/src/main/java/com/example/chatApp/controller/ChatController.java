package com.example.chatApp.controller;

import com.example.chatApp.model.Conversation;
import com.example.chatApp.repository.ConversationRepository;
import com.example.chatApp.service.ChatService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChatController {

    private final ChatService chatService;
    private final ConversationRepository conversationRepository;
    
    @Autowired
    public ChatController(ChatService chatService, ConversationRepository conversationRepository) {
        this.chatService = chatService;
        this.conversationRepository = conversationRepository;
    }
    
    @GetMapping("/")
    public String showChatPage(Model model) {
        model.addAttribute("conversation", new Conversation());
        return "chat";
    }
    
    @PostMapping("/send")
    public String processMessage(@ModelAttribute Conversation conversation, Model model) {
        Conversation updatedConversation = chatService.processMessage(conversation);
        model.addAttribute("conversation", updatedConversation);
        return "chat";
    }
    
    @GetMapping("/historique")
    public String listUsers(Model model) {
        List<String> users = conversationRepository.findDistinctUserNames();
        model.addAttribute("users", users);
        return "users";
    }
    
    @GetMapping("/conversations/{username}")
    public String viewConversations(@PathVariable("username") String username, Model model) {
        List<Conversation> conversations = conversationRepository.findByUserName(username);
        model.addAttribute("conversations", conversations);
        model.addAttribute("username", username);
        return "conversations";
    }
}