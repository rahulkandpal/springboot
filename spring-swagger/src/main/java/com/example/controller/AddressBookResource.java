package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AddressBookResource {

	ConcurrentMap<String,Contact> contacts =  new  ConcurrentHashMap<>();
	
	{
		contacts.put("1",new Contact("1","xx","bbb"));
		contacts.put("2",new Contact("1","xx","bbb"));
		contacts.put("3",new Contact("1","xx","bbb"));
		contacts.put("4",new Contact("1","xx","bbb"));

		System.out.println(contacts.get("1").getName());
	}
	
	@GetMapping("/{id}")
	public Contact getContact(@PathVariable String id)
	{
		return contacts.get(id);
	}
	@GetMapping("/")
	public List<Contact> getAllContacts()
	{
		System.out.println(contacts.get("1").getName());
		return new ArrayList<Contact>(contacts.values());
	}
	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact)
	{
		contacts.put(contact.getId(), contact);
		return contact;
	}
	
}
