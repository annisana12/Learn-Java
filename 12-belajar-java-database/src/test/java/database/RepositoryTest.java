package database;

import database.entity.Comment;
import database.repository.CommentRepository;
import database.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comment comment = new Comment("budi@test.com", "Hi");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
        System.out.println(comment);
    }

    @Test
    void testFindById() {
        Comment existComment = commentRepository.findById(1000);
        Assertions.assertNotNull(existComment);
        System.out.println(existComment);

        Comment notFound = commentRepository.findById(100000);
        Assertions.assertNull(notFound);
    }

    @Test
    void testFindAll() {
        List<Comment> comments = commentRepository.findAll();
        System.out.println(comments.size());
    }

    @Test
    void testFindAllByEmail() {
        List<Comment> comments = commentRepository.findAllByEmail("budi@test.com");
        System.out.println(comments.size());
    }
}
