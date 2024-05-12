package org.nye.progkorny.config;


import org.nye.progkorny.entity.BookEntity;
import org.nye.progkorny.repository.ILibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataPopulator implements ApplicationRunner {

    private final ILibraryRepository libraryRepository;

    @Autowired
    public SampleDataPopulator(ILibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (libraryRepository.count() == 0) {
            BookEntity book1 = new BookEntity("Mekk Elek", "Hogy csináld jól?", 104, 1986, "none", "Fiction", true);
            libraryRepository.save(book1);
        }
    }
}
