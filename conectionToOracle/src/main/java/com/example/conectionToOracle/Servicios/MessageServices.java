package com.example.conectionToOracle.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.conectionToOracle.Modelos.Message;
import com.example.conectionToOracle.Repository.MessageRepository;

@Service
public class MessageServices {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {                     
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) { 
        return messageRepository.getMessage(id); 
    }

    public Message save(Message message) {                                             
        if(message.getMessageId()==0) {                                             
            return messageRepository.save(message);                                     
        } else {
            Optional<Message> element = messageRepository.getMessage(message.getMessageId());      
            if (element.isPresent()) {
                return message;

            } else {
            return messageRepository.save(message);
           }
        }
    }

    public Message update(Message message) {
        if (message.getMessageId() != 0) {                                                   
            Optional<Message> elementToUpdate = messageRepository.getMessage(message.getMessageId());    
            if (elementToUpdate.isPresent()) {                                    
                
                if (message.getMessageText() != null) {                                        
                    elementToUpdate.get().setMessageText(message.getMessageText());
                    // elementToUpdate.get() trae el mensaje de la base de datos, .setMessageText(El nuevo mensaje que te envió el usuario), set como mensaje en el lugar del viejo
                }

                messageRepository.save(elementToUpdate.get());                                
                return elementToUpdate.get();

            } else {
                return message;
            }

        } else {
            return message;
        }
    }

    public boolean delete(int id) {                        
        boolean dataStatus = false;                         
        Optional<Message> elementToDelete = messageRepository.getMessage(id);
        if (elementToDelete.isPresent()) {
            messageRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    } 
}

