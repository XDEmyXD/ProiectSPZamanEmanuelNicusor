package com.example.proiectspzamanemanuelnicusor.Book;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BaseElement> elements = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addElement(BaseElement element) {
        elements.add(element);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void print() {
        System.out.println("Title: " + title);
        System.out.println("Authors: ");
        for (Author author : authors) {
            author.print();
        }
        System.out.println("Content: ");
        for (Element element : elements) {
            element.print();
        }
    }
}
