package paradigmas.theboys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import paradigmas.theboys.entities.Missoes;
import paradigmas.theboys.repositories.MissoesRepository;

import java.util.Map;


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

    @PatchMapping("/{id}")
    public ResponseEntity<Missoes> atualizarMissoes(@PathVariable Long id, @RequestBody Map<String, Object> camposAtualizados) {
        try {
            Missoes missoesExistente = missoesRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Missão não encontrado com o ID: " + id));

            camposAtualizados.forEach((campo, valor) -> {
                switch (campo) {
                    case "nomeMissao":
                        missoesExistente.setNomeMissao((String) valor);
                        break;
                    case "descricaoMissao":
                        missoesExistente.setDescricaoMissao((String) valor);
                        break;
                    case "dificuldadeMissao":
                        missoesExistente.setDificuldadeMissao((Integer) valor);;
                        break;
                    case "heroisDesignados":
                        missoesExistente.setHeroisDesignados((String) valor);;
                        break;
                    case "resultadoMissao":
                        missoesExistente.setResultadoMissao((String) valor);
                        break;
                    case "recompensaMissao":
                        missoesExistente.setRecompensaMissao((String) valor);
                        break;
                    default:
                        throw new IllegalArgumentException("Campo não suportado: " + campo);
                }
            });

            Missoes missoesSalvo = missoesRepository.save(missoesExistente);
            return ResponseEntity.ok(missoesSalvo);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
