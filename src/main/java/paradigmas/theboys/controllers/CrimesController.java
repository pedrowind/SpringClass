package paradigmas.theboys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paradigmas.theboys.entities.Crimes;
import paradigmas.theboys.repositories.CrimesRepository;

@RestController
@RequestMapping("/crimes")
public class CrimesController {

    @Autowired
    private CrimesRepository crimesRepository;

    @PostMapping
    public ResponseEntity<Crimes> criarCrime(@RequestBody Crimes crimes) {
        Crimes novoCrime = crimesRepository.save(crimes);
        return ResponseEntity.ok(novoCrime);
    }
}
