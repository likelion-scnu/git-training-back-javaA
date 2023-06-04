package dev.ooae.jpa;

import dev.ooae.jpa.entity.BoardEntity;
import dev.ooae.jpa.entity.PostEntity;
import dev.ooae.jpa.repository.BoardRepository;
import dev.ooae.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    public TestComponent(
            @Autowired BoardRepository boardRepository,
            @Autowired PostRepository postRepository
            ){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName("new board");
        BoardEntity newBoardEntity = boardRepository.save(boardEntity);

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle("Hello ORM");
        postEntity.setContent("Thist");
        postEntity.setWriter("ooae");
        postEntity.setBoardEntity(newBoardEntity);
        PostEntity newPostEntity = postRepository.save(postEntity);

        System.out.println(postRepository.findAllByWriter("ooae").size());


    }
}
