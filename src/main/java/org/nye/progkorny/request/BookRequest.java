package org.nye.progkorny.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookRequest {

    @NotEmpty
    private String author;

    @NotEmpty
    private String title;

    @PositiveOrZero
    private int pages;

    @PositiveOrZero
    private int year;

    private String coverUrl;

    private String genre;

    private Boolean isOwned;
}
