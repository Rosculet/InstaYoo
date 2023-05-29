package rosculet.instayoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rosculet.instayoo.entity.ImageModel;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

    Optional<ImageModel> findByUserId(Long id);
    Optional<ImageModel> findByPostId(Long id);

}
