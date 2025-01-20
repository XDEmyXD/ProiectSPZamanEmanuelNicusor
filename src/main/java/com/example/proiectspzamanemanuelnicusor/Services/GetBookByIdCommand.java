package com.example.proiectspzamanemanuelnicusor.Services;

public class GetBookByIdCommand implements Command {
    private final BookService bookService;
    private final String id;

    public GetBookByIdCommand(BookService bookService, String id) {
        this.bookService = bookService;
        this.id = id;
    }

    @Override
    public void execute() {
        System.out.println(bookService.getBookById(id).orElse(null));
    }
}
