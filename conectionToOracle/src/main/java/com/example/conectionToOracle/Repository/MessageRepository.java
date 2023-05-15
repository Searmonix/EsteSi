package com.example.conectionToOracle.Repository;
import java.util.List;
import java.util.Optional;
import com.example.conectionToOracle.Modelos.Message;
import com.example.conectionToOracle.Repository.CrudRepository.MessageCrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll() { 
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id) { 
        return messageCrudRepository.findById(id); 
    }

    public Message save(Message message) { 
        return messageCrudRepository.save(message); 
    }

    public void delete(Message message) { 
        messageCrudRepository.delete(message); 
    }
}