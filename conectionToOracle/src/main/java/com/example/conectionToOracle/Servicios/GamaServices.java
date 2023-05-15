package com.example.conectionToOracle.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.conectionToOracle.Modelos.Gama;
import com.example.conectionToOracle.Repository.GamaRepository;

@Service
public class GamaServices {

    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll() {
        return gamaRepository.getAll();
    }

    public Optional<Gama> getGama(int id) { 
        return gamaRepository.getGama(id); 
    }

    public Gama save(Gama gama) {                                             
        if(gama.getId()==0) {                                             
            return gamaRepository.save(gama);                                     
        } else {
            Optional<Gama> element = gamaRepository.getGama(gama.getId());      
            if (element.isPresent()) {
                return gama;

            } else {
            return gamaRepository.save(gama);
           }
        }
    }

    public Gama update(Gama gama) {
        if (gama.getId() != 0) {                                                    
            Optional<Gama> elementToUpdate = gamaRepository.getGama(gama.getId());
            if (elementToUpdate.isPresent()) {                                   
                if (gama.getName() != null) {                                      
                    elementToUpdate.get().setName(gama.getName());                
                
                }

                if (gama.getDescription() != null) {
                    elementToUpdate.get().setDescription(gama.getDescription());
                }

                gamaRepository.save(elementToUpdate.get());                              
                return elementToUpdate.get();

            } else {
                return gama;
            }

        } else {
            return gama;
        }
    }

    public boolean delete(int id) {                         
        boolean dataStatus = false;                        
        Optional<Gama> elementToDelete = gamaRepository.getGama(id);
        if (elementToDelete.isPresent()) {
            gamaRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    } 
}
