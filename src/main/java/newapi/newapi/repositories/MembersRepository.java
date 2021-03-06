package newapi.newapi.repositories;

import newapi.newapi.models.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long> {
    Optional<Members> findByEmail(String email);
}
