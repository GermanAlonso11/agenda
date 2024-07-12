package com.agenda.agenda.service;

import java.time.LocalDateTime;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.agenda.agenda.entity.Contact;
import com.agenda.agenda.repository.ContactRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ContactService {

    
    private final ContactRepository contactRepository;

    
    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(Integer id){
        return contactRepository.findById(id).orElse(null);
    }

    public Contact create(@RequestBody Contact contact){
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, Contact form){
        Contact contactFromDb = findById(id);

        contactFromDb.setName(form.getName());
        contactFromDb.setEmail(form.getEmail());
        
        return contactRepository.save(contactFromDb);
    }

    public void delete( Integer id){
        Contact contactFromDb = findById(id);

        
        contactRepository.delete(contactFromDb);
    }

}
