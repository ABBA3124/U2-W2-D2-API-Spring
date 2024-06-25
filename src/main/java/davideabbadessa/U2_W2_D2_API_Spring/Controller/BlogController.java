package davideabbadessa.U2_W2_D2_API_Spring.Controller;


import davideabbadessa.U2_W2_D2_API_Spring.entities.Blog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private List<Blog> blogList = new ArrayList<>();


    // 1) ritorna la lista di blog post
    @GetMapping
    public List<Blog> getBlogList() {
        return blogList;
    }


    // 2) ritorna un singolo blog post
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable int id) {
        return blogList.stream().filter(post -> post.getId() == (id)).findFirst().orElse(null);
    }

    // 3) crea un nuovo blog post (POST)
    @PostMapping("/post")
    public Blog createBlog(@RequestBody Blog blog) {
        blog.setId((int) (blogList.size() + 1));
        blogList.add(blog);
        return blog;
    }

    // 4) modifica lo specifico blo post (PUT)
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable int id, @RequestBody Blog modificaBlog) {
        Optional<Blog> prova = blogList.stream().filter(post -> post.getId() == (id)).findFirst();
        if (prova.isPresent()) {
            Blog blog = prova.get();
            blog.setCategoria(modificaBlog.getCategoria());
            blog.setTitolo(modificaBlog.getTitolo());
            blog.setCover(modificaBlog.getCover());
            blog.setContenuto(modificaBlog.getContenuto());
            blog.setTempoDiLettura(modificaBlog.getTempoDiLettura());
            return blog;
        } else {
            return null;
        }
    }

    // 5) cancella lo specifico blog post (DELETE)
    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable int id) {
        blogList.removeIf(post -> post.getId() == (id));
    }
}
