package com.example.proiectspzamanemanuelnicusor.difexample;

import com.example.proiectspzamanemanuelnicusor.Book.Book;
import com.example.proiectspzamanemanuelnicusor.Services.BookService;
import com.example.proiectspzamanemanuelnicusor.Services.Command;
import com.example.proiectspzamanemanuelnicusor.Services.CommandInvoker;
import com.example.proiectspzamanemanuelnicusor.Services.GetBookByIdCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    private final CommandInvoker commandInvoker;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
        this.commandInvoker = new CommandInvoker();
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        Command command = new GetBookByIdCommand(bookService, id);
        commandInvoker.addCommand(command);
        commandInvoker.executeCommands();
        return bookService.getBookById(id).orElse(null);
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable String id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }
}
