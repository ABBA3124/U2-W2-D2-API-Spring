package davideabbadessa.U2_W2_D2_API_Spring.Controller;


import davideabbadessa.U2_W2_D2_API_Spring.entities.Autore;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    private List<Autore> autoreList = new ArrayList<>();

    // 1) ritorna la lista di blog post (GET)
    @GetMapping
    public List<Autore> getAllAuthors() {
        return autoreList;
    }


    // 2) ritorna un singolo autore (GET)
    @GetMapping("/{id}")
    public Autore getAutoreById(@PathVariable UUID id) {
        return autoreList.stream().filter(post -> post.getId().equals(id)).findFirst().orElse(null);
    }

    // 3) crea un nuovo blog post (POST)
    @PostMapping
    public Autore createAutore(@RequestBody Autore autore) {
        autore.setId(UUID.randomUUID());
        autoreList.add(autore);
        return autore;
    }

    // 4) modifica lo specifico blo post (PUT)
    @PutMapping("/{id}")
    public Autore updateAutore(@PathVariable UUID id, @RequestBody Autore modificaAutore) {
        Optional<Autore> prova = autoreList.stream().filter(post -> post.getId().equals(id)).findFirst();
        if (prova.isPresent()) {
            Autore autore = prova.get();
            autore.setNome(modificaAutore.getNome());
            autore.setCognome(modificaAutore.getCognome());
            autore.setEmail(modificaAutore.getEmail());
            autore.setDataDiNascita(modificaAutore.getDataDiNascita());
            autore.setAvatar(modificaAutore.getAvatar());
            return autore;
        } else {
            return null;
        }
    }

    // 5) cancella lo specifico blog post (DELETE)
    @DeleteMapping("/{id}")
    public void deleteAutore(@PathVariable UUID id) {
        autoreList.removeIf(post -> post.getId().equals(id));
    }


}
