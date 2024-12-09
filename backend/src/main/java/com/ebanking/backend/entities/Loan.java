package com.ebanking.backend.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loans")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "loanType is required!")
    private String loanType;

    @NotBlank(message = "amount is required!")
    private Double amount;

    private Double remainingBalance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
