package edu.iu.habahram.ducksservice.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DucksRepository {

    private String IMAGES_FOLDER_PATH = "ducks/images/";

    public boolean updateImage(int id, MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());

        String fileExtension = ".png";
        String[] contentType = file.getContentType().split("/");
        if(contentType.length == 2) {
            if (contentType[0].equalsIgnoreCase("image")) {
                fileExtension = "." + contentType[1];
            }
        }
        Path path = Paths.get(IMAGES_FOLDER_PATH
                + id + fileExtension);
        System.out.println("The file " + path + " was saved successfully.");
        file.transferTo(path);
        return true;
    }
}
