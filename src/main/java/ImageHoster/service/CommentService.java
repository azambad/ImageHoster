package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @Author : azambad
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ImageService imageService;

    /**
     * @param imageId
     * @param commentText
     * @param user
     * @return
     */
    public Comment addComment(Integer imageId, String commentText, User user) {
        Comment comment = new Comment();
        comment.setText(commentText);
        Image image = imageService.getImage(imageId);
        comment.setImage(image);
        comment.setCreatedDate(LocalDate.now());
        comment.setUser(user);
        return commentRepository.addComment(comment);
    }
}
