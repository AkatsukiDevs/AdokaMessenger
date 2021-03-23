package com.example.demo.controllers;

import com.example.demo.Entity.Chat;
import com.example.demo.Repo.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ChatRepository chatRepository;


    @GetMapping("/chats")
    public String post(Model model) {
        Iterable<Chat> chats = chatRepository.findAll();
        model.addAttribute("chats", chats);
        return "hello";
    }

    @GetMapping("/chat")
    public String home(Model model) {
        Iterable<Chat> chats = chatRepository.findAll();
        model.addAttribute("chats", chats);
        return "home";
    }

    @PostMapping("/chat")
    public String postMessage(@RequestParam String bodyMessage,String name,String time, Model model) {
            Chat chat = new Chat(bodyMessage,name,time);
            chatRepository.save(chat);
            return "hello";
        }
    }