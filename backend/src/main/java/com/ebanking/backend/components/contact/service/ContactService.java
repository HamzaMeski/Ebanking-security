package com.ebanking.backend.components.contact.service;

import com.ebanking.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.ebanking.backend.components.contact.dto.request.CreateContactDTO;
import com.ebanking.backend.components.contact.dto.request.UpdateContactDTO;
import com.ebanking.backend.components.contact.dto.response.ContactResponseDTO;
import com.ebanking.backend.components.contact.mapper.ContactMapper;
import com.ebanking.backend.components.contact.repository.ContactRepository;
import com.ebanking.backend.entities.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class ContactService extends EntityServiceImpl<Contact, Long, CreateContactDTO, UpdateContactDTO, ContactResponseDTO> {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactService(
            ContactRepository contactRepository,
            ContactMapper contactMapper,
            ApplicationContext applicationContext) {
        super(contactRepository, contactMapper, applicationContext);
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }
}
