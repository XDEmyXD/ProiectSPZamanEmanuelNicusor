package com.example.proiectspzamanemanuelnicusor.Book;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED) // Sau SINGLE_TABLE pentru o singură tabelă
public abstract class BaseElement implements Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
