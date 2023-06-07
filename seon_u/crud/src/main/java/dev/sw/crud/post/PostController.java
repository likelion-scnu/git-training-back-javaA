package dev.sw.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.loading.PrivateClassLoader;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
//@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(
            @Autowired PostService postService
    ) {
        this.postService = postService;
    }

    @PostMapping("create") // 사용자가 제공을 하는 메서드는 Post가 떠올라야 함.
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    @GetMapping("read-all") // 사용자가 뭔가를 조회할 때 사용하는 메서드는 기본적으로 GetMapping 이다.
    public List<PostDto> readPostAll(){
        logger.info("in read all");
        return this.postService.readPostAll();
    }

    @GetMapping("read-one")
    public PostDto readPostOne(@RequestParam("id") int id){ //@RequestParam 을 사용하면 Query Params를 이용해 URL뒤에 ?을 붙여 값을 받기가 가능해진다.
        logger.info("in read one");
        return this.postService.readPost(id);
    }

    @PostMapping("update")
    public void udatePost(
            @RequestParam("id") int id,
            @RequestBody PostDto postDto
    ){
        logger.info("target id: " + id);
        logger.info("update content" + postDto);
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id") int id){
        this.postService.deletePost(id);
    }
}
