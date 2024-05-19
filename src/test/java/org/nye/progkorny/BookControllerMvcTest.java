/*
package org.nye.progkorny;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nye.progkorny.controller.BookController;
import org.nye.progkorny.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookController.class)
public class BookControllerMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ILibraryService libraryService;

    @Test
    void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("books"));
    }

    @Test
    void testSaveBook() throws Exception {
        String newBookJson = "{\"author\":\"Author\",\"title\":\"Title\",\"pages\":123,\"publicationYear\":2024,\"coverUrl\":\"coverUrl\",\"genre\":\"Genre\",\"isOwned\":true}";

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newBookJson))
                .andExpect(status().isOk());
    }
}
*/