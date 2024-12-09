package com.ebanking.backend.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cards")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;

    @Column(nullable = false)
    private String cardType = "Credit"; // e.g., Credit, Debit

    @NotBlank(message = "role is required!")
    private LocalDate expiryDate = LocalDate.of(2025, 11, 1);

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}