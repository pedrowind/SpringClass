package paradigmas.theboys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paradigmas.theboys.entities.Heroi;
import paradigmas.theboys.repositories.HeroiRepository;

@RestController
@RequestMapping("/heroi")
public class HeroiController {

    @Autowired
    private HeroiRepository heroiRepository;

    @PostMapping
    public ResponseEntity<Heroi> criarHeroi(@RequestBody Heroi heroi) {
        Heroi novoHeroi = heroiRepository.save(heroi);
        return ResponseEntity.ok(novoHeroi);
    }
}
