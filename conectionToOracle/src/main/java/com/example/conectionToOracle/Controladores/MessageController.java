package com.example.conectionToOracle.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.conectionToOracle.Modelos.Message;
import com.example.conectionToOracle.Servicios.MessageServices;

import java.util.List;

@RestController
@RequestMapping("api/Message")
public class MessageController {
    
    @Autowired
    public MessageServices messageServices;

    @GetMapping("/all") 
    public List<Message> getMessage() {
        return messageServices.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Message save(@RequestBody Message message) {
        return messageServices.save(message);
    }

}