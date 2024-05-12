package org.nye.progkorny.web;

import org.nye.progkorny.entity.BookEntity;
import org.nye.progkorny.service.ILibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LibraryController {

    private final ILibraryService libraryService;


    public LibraryController(ILibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<BookEntity> books = libraryService.getAllBooks();

        model.addAttribute("books", books);

        return "index";
    }
}
