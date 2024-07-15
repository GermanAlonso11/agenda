package com.agenda.agenda.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;

import com.agenda.agenda.dto.ContactDTO;
import com.agenda.agenda.entity.Contact;
import com.agenda.agenda.exception.ResourceNotFoundException;
import com.agenda.agenda.repository.ContactRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ContactService {

    
    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    
    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(Integer id){
        return contactRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Contact create(ContactDTO contactdDto){
        
        Contact contact = mapper.map(contactdDto, Contact.class );

        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDTO contactdDto){
        Contact contactFromDb = findById(id);
        mapper.map(contactdDto, contactFromDb );
        return contactRepository.save(contactFromDb);
    }

    public void delete( Integer id){
        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }

}
