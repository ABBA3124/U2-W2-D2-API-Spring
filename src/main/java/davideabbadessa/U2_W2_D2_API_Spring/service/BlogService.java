package davideabbadessa.U2_W2_D2_API_Spring.service;


import davideabbadessa.U2_W2_D2_API_Spring.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {

    private List<Blog> blogList = new ArrayList<>();

    private List<Blog> getBlogList() {
        return this.blogList;
    }


    private List<Blog> saveBlog(Blog blog) {
        blog.setId(new Random().nextInt(1, 10000));
        return blogList;
    }

}
