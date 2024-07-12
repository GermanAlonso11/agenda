package com.agenda.agenda.repository;

import org.springframework.data.repository.CrudRepository;
import com.agenda.agenda.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
