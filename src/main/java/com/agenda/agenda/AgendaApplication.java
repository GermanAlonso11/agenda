package com.agenda.agenda;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.agenda.agenda.entity.Contact;
import com.agenda.agenda.repository.ContactRepository;

@SpringBootApplication
public class AgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);

		
	}
	@Bean
	CommandLineRunner runner(ContactRepository contactRepository){
		return args -> {
				List<Contact> contacts = Arrays.asList(
				new Contact("Luis", "luis@gmail.com", LocalDateTime.now()),
				new Contact("alberto", "alberto@gmail.com" , LocalDateTime.now()),
				new Contact ("criss", "criss@outlook.es", LocalDateTime.now()),
				new Contact("natalia", "nat@gmail.com", LocalDateTime.now() ),
				new Contact("alfred", "alf@outlook.es", LocalDateTime.now())
		);
		contactRepository.saveAll(contacts);
			
		};
	};

}
