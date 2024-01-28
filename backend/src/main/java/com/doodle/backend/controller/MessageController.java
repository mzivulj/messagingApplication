package com.doodle.backend.controller;

import com.doodle.backend.domain.Message;
import com.doodle.backend.domain.Status;
import com.doodle.backend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message) {
        if (message.getStatus() == Status.MESSAGE) {
            Message newMsg = new Message(message.getSenderName(), message.getMessage(), message.getStatus());
            messageRepository.save(newMsg);
            return messageRepository.findAllOrderByTimestampDesc();
        }
           return message;
    }
}