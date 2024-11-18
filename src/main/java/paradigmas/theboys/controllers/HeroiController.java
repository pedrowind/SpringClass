package paradigmas.theboys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import paradigmas.theboys.entities.Heroi;
import paradigmas.theboys.repositories.HeroiRepository;

import java.util.Map;


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

    @PatchMapping("/{id}")
    public ResponseEntity<Heroi> atualizarHeroi(@PathVariable Long id, @RequestBody Map<String, Object> camposAtualizados) {
        try {
            Heroi heroiExistente = heroiRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Herói não encontrado com o ID: " + id));

            camposAtualizados.forEach((campo, valor) -> {
                switch (campo) {
                    case "nome":
                        heroiExistente.setNome((String) valor);;
                        break;
                    case "idade":
                        heroiExistente.setIdade((Integer) valor);
                        break;
                    case "sexo":
                        heroiExistente.setSexo((String) valor);;
                        break;
                    case "caracteristicasFisicas":
                        heroiExistente.setCaracteristicasFisicas((String) valor);;
                        break;
                    case "poderes":
                        heroiExistente.setPoderes((String) valor);
                        break;
                    case "forca":
                        heroiExistente.setForca((Integer) valor);
                        break;
                    case "popularidade":
                        heroiExistente.setPopularidade((Integer) valor);
                        break;
                    case "status":
                        heroiExistente.setStatus((String) valor);
                        break;
                    case "historicoBatalhas":
                        heroiExistente.setHistoricoBatalhas((String) valor);
                        break;
                    default:
                        throw new IllegalArgumentException("Campo não suportado: " + campo);
                }
            });

            Heroi heroiSalvo = heroiRepository.save(heroiExistente);
            return ResponseEntity.ok(heroiSalvo);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
