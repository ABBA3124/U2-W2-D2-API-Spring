package davideabbadessa.U2_W2_D2_API_Spring.Controller;


import davideabbadessa.U2_W2_D2_API_Spring.entities.Blog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private List<Blog> blogList = new ArrayList<>();

    @GetMapping
    public List<Blog> getBlogList() {
        return blogList;
    }

    @PostMapping("/post")
    public Blog createBlogPost(@RequestBody Blog blog) {
        blog.setId((int) (blogList.size() + 1));
        blogList.add(blog);
        return blog;
    }

}
