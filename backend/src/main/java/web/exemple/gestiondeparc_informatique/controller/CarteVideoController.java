package web.exemple.gestiondeparc_informatique.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.exemple.gestiondeparc_informatique.entities.CarteVideo;
import web.exemple.gestiondeparc_informatique.repository.CarteVideoRepository;
import web.exemple.gestiondeparc_informatique.services.CarteVideoService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class CarteVideoController {

    private final CarteVideoRepository carteVideoRepository;
    private final CarteVideoService carteVideoService;

    @GetMapping("/carteVideos")
    public List<CarteVideo> getAll() {
        return carteVideoRepository.findAll();
    }

    @GetMapping("/carteVideos/{id}")
    public ResponseEntity<CarteVideo> getById(@PathVariable Long id) {
        return carteVideoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/carteVideos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CarteVideo saveCarteVideo(
            @RequestPart("nomCarte") String nomCarte,
            @RequestPart("typeCarte") String typeCarte) throws IOException {

        CarteVideo carteVideo = new CarteVideo(null, nomCarte, typeCarte);
        return carteVideoService.saveCarteVideo(carteVideo);
    }

    @DeleteMapping("/carteVideos/{id}")
    public ResponseEntity<Void> deleteCarteVideo(@PathVariable Long id) {
        try {
            carteVideoService.deleteCarteVideo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
