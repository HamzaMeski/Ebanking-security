package com.ebanking.backend.components.card.controller;

import com.ebanking.backend.EntityComponentsProvider.controller.Controller;
import com.ebanking.backend.components.card.dto.request.CreateCardDTO;
import com.ebanking.backend.components.card.dto.request.UpdateCardDTO;
import com.ebanking.backend.components.card.dto.response.CardResponseDTO;
import com.ebanking.backend.components.card.service.CardService;
import com.ebanking.backend.entities.Card;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardController extends Controller<Card, Long, CreateCardDTO, UpdateCardDTO, CardResponseDTO> {
    private final CardService cardService;

    public CardController(CardService cardService) {
        super(cardService);
        this.cardService = cardService;
    }
}
