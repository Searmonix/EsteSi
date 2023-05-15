package com.example.conectionToOracle.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.conectionToOracle.Modelos.Client;
import com.example.conectionToOracle.Repository.ClientRepository;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id) { 
        return clientRepository.getClient(id); 
    }

    public Client save(Client client) {                                             
        if (client.getId()==0) {                                            
            return clientRepository.save(client);                                     
        } else {
            Optional<Client> element = clientRepository.getClient(client.getId());     
            if (element.isPresent()) {
                return client;

            } else {
                return clientRepository.save(client);
            }
        }
    }

    public Client update(Client client) {
        if (client.getId() != 0) {                                                    
            Optional<Client> elementToUpdate = clientRepository.getClient(client.getId());
            if (elementToUpdate.isPresent()) {                                   
                if (client.getName() != null) {                                      
                    elementToUpdate.get().setName(client.getName());                
                }

                if (client.getAge() != 0) {    
                    elementToUpdate.get().setAge(client.getAge());
                }

                if (client.getEmail() != null) {
                    elementToUpdate.get().setEmail(client.getEmail());
                }

                if (client.getPassword() != null) {
                    elementToUpdate.get().setPassword(client.getPassword());
                }

                clientRepository.save(elementToUpdate.get());                              
                return elementToUpdate.get();

            } else {
                return client;
            }

        } else {
            return client;
        }
    }

    public boolean delete(int id) {                         
        boolean dataStatus = false;                        
        Optional<Client> elementToDelete = clientRepository.getClient(id);
        if (elementToDelete.isPresent()) {
            clientRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    } 
}

