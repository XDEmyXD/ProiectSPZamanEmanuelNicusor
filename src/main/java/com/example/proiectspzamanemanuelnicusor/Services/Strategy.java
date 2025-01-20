package com.example.proiectspzamanemanuelnicusor.Services;

import com.example.proiectspzamanemanuelnicusor.Book.Paragraph;

public interface Strategy {
    public default void render(Paragraph paragraph, int width){}
}

