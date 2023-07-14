package ReaderApp.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ReaderApp.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
