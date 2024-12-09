package com.ebanking.backend.components.contact.controller;

import com.ebanking.backend.EntityComponentsProvider.controller.Controller;
import com.ebanking.backend.components.contact.dto.request.CreateContactDTO;
import com.ebanking.backend.components.contact.dto.request.UpdateContactDTO;
import com.ebanking.backend.components.contact.dto.response.ContactResponseDTO;
import com.ebanking.backend.components.contact.service.ContactService;
import com.ebanking.backend.entities.Contact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
public class ContactController extends Controller<Contact, Long, CreateContactDTO, UpdateContactDTO, ContactResponseDTO> {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        super(contactService);
        this.contactService = contactService;
    }
}
