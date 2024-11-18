package paradigmas.theboys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import paradigmas.theboys.entities.Crimes;
import paradigmas.theboys.entities.Missoes;
import paradigmas.theboys.repositories.CrimesRepository;

import java.util.Date;
import java.util.Map;

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

    @PatchMapping("/{id}")
    public ResponseEntity<Crimes> atualizarCrimes(@PathVariable Long id, @RequestBody Map<String, Object> camposAtualizados) {
        try {
            Crimes crimesExistente = crimesRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Crime não encontrado com o ID: " + id));

            camposAtualizados.forEach((campo, valor) -> {
                switch (campo) {
                    case "nomeCrime":
                        crimesExistente.setNomeCrime((String) valor);
                        break;
                    case "descricaoCrime":
                        crimesExistente.setDescricaoCrime((String) valor);
                        break;
                    case "dataCrime":
                        crimesExistente.setDataCrime((Date) valor);;
                        break;
                    case "heroiResponsavel":
                        crimesExistente.setheroiResponsavel((String) valor);;
                        break;
                    case "severidadeCrime":
                        crimesExistente.setSeveridadeCrime((Integer) valor);
                        break;
                    default:
                        throw new IllegalArgumentException("Campo não suportado: " + campo);
                }
            });

            Crimes crimesSalvo = crimesRepository.save(crimesExistente);
            return ResponseEntity.ok(crimesSalvo);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
