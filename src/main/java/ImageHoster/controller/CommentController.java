package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;


    /**  This method is used to add comment under selected images, after successful adding comment it reloads the image screen.
     * @param commentText
     * @param imageId
     * @param title
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/image/{id}/{title}/comments", method = RequestMethod.POST)
    public String addComment(@RequestParam("comment") String commentText, @PathVariable("id") Integer imageId, @PathVariable("title") String title, HttpSession session) throws IOException {

        User user = (User) session.getAttribute("loggeduser");

        commentService.addComment(imageId,commentText,user);
        return "redirect:/images/"+imageId+"/"+title;
    }

}
