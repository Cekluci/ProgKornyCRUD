package org.nye.progkorny.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotEmpty
    @Column(name = "author")
    private String author;

    @NotEmpty
    @Column(name = "title")
    private String title;

    @PositiveOrZero
    @Column(name = "pages")
    private int pages;

    @PositiveOrZero
    @Column(name = "publicationYear")
    private int publicationYear;

    @Column(name = "coverUrl")
    private String coverUrl;

    @Column(name = "genre")
    private String genre;

    @Column(name = "isOwned")
    private Boolean isOwned;

    public BookEntity(String author, String title, int pages, int publicationYear, String coverUrl, String genre, Boolean isOwned) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.publicationYear = publicationYear;
        this.coverUrl = coverUrl;
        this.genre = genre;
        this.isOwned = isOwned;
    }

}
