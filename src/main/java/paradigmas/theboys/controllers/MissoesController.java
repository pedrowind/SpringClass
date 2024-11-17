package paradigmas.theboys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paradigmas.theboys.entities.Missoes;
import paradigmas.theboys.repositories.MissoesRepository;


@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @Autowired
    private MissoesRepository missoesRepository;

    @PostMapping
    public ResponseEntity<Missoes> criarMissoes(@RequestBody Missoes missoes) {
        Missoes novaMissao = missoesRepository.save(missoes);
        return ResponseEntity.ok(novaMissao);
    }
}
