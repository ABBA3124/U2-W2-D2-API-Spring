package davideabbadessa.U2_W2_D2_API_Spring.Controller;


import davideabbadessa.U2_W2_D2_API_Spring.entities.Autore;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    private List<Autore> autoreList = new ArrayList<>();

    @GetMapping
    public List<Autore> getAllAuthors() {
        return autoreList;
    }

    @PostMapping
    public Autore createAuthor(@RequestBody Autore autore) {
        autore.setId((int) (autoreList.size() + 1));
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getCognome().replace(" ", "+"));
        autoreList.add(autore);
        return autore;
    }
    
}
