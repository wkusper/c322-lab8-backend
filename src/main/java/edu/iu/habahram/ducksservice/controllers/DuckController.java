package edu.iu.habahram.ducksservice.controllers;

import edu.iu.habahram.ducksservice.repository.DucksRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/ducks")
public class DuckController {

    private DucksRepository ducksRepository;

    public DuckController(DucksRepository ducksRepository) {
        this.ducksRepository = ducksRepository;
    }

    @PostMapping("/image/{id}")
    public boolean updateImage(@PathVariable int id,
                               @RequestParam MultipartFile file) {
        try {
            return ducksRepository.updateImage(id, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
