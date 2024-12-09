package com.ebanking.backend.entities;
import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String loanType;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double remainingBalance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
