package rosculet.instayoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rosculet.instayoo.entity.Comment;
import rosculet.instayoo.entity.Post;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPost(Post post);

    Comment findAllByIdAndUserId(Long commentId, Long UserId);

}
