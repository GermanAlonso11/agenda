package com.agenda.agenda.ContactController;


// import java.time.LocalDateTime;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.agenda.dto.ContactDTO;
import com.agenda.agenda.entity.Contact;
// import com.agenda.agenda.repository.ContactRepository;
import com.agenda.agenda.service.ContactService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    
    private final ContactService contactService;

    @GetMapping
    public Iterable<Contact> list(){
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
        return contactService.findById(id);
    }

    //CREAR
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Contact create(@Validated @RequestBody ContactDTO contactDTO){
        
        return contactService.create(contactDTO);
    }

    //ACTUALIZAR
    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id, @Validated @RequestBody ContactDTO contactDTO){
        
        
        return contactService.update(id, contactDTO);
    }

    //BORRAR
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){

        contactService.delete(id);
    }
}
