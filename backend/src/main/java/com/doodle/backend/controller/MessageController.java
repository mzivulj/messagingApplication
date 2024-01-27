package com.doodle.backend.controller;

import com.doodle.backend.domain.Message;
import com.doodle.backend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/getAllMesages")
    public ResponseEntity<List<Message>> getAllMessages() {
    try {
        List<Message> messageList = new ArrayList<>();
        messageRepository.findAllOrderByTimestampDesc().forEach(messageList::add);
        return new ResponseEntity<>(messageList, HttpStatus.OK);
     } catch (Exception exception) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    } }

    @PostMapping("/addMessage")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
    Message savedMessage = messageRepository.save(message);
    return new ResponseEntity<>(savedMessage, HttpStatus.OK);
    }
}
