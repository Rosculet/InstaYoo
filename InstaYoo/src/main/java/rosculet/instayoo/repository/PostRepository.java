package rosculet.instayoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rosculet.instayoo.entity.Post;
import rosculet.instayoo.entity.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    //select * from post as p where User="user" sort desc
    List<Post> findAllByUserOrderByCreatedDateDesc(User user);
    List<Post> findAllByOrderByCreatedDateDesc();

    Optional<Post> findPostsById(Long id);


}
