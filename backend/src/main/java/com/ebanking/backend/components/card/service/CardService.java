package com.ebanking.backend.components.card.service;

import com.ebanking.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.ebanking.backend.components.card.dto.request.CreateCardDTO;
import com.ebanking.backend.components.card.dto.request.UpdateCardDTO;
import com.ebanking.backend.components.card.dto.response.CardResponseDTO;
import com.ebanking.backend.components.card.mapper.CardMapper;
import com.ebanking.backend.components.card.repository.CardRepository;
import com.ebanking.backend.entities.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class CardService extends EntityServiceImpl<Card, Long, CreateCardDTO, UpdateCardDTO, CardResponseDTO> {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardService(
            CardRepository cardRepository,
            CardMapper cardMapper,
            ApplicationContext applicationContext) {
        super(cardRepository, cardMapper, applicationContext);
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }
}
