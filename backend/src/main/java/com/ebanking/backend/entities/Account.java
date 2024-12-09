package com.ebanking.backend.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "cardNumber is required!")
    private String accountNumber;

    @Column(nullable = false)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}