package com.example.proiectspzamanemanuelnicusor.Book;

import com.example.proiectspzamanemanuelnicusor.Book.BaseElement;
import com.example.proiectspzamanemanuelnicusor.Book.Element;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Image extends BaseElement {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Url: " + url);
    }

    @Override
    public void add(Element element) {
    }

    @Override
    public void remove(Element element) {
    }

    @Override
    public Element get(int index) {
        return null;
    }
}
