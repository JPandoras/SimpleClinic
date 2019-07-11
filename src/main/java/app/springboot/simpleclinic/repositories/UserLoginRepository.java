package app.springboot.simpleclinic.repositories;

import app.springboot.simpleclinic.models.UserLogin;
import org.springframework.data.repository.CrudRepository;

public interface UserLoginRepository extends CrudRepository<UserLogin, String> {

   UserLogin getUserByUsername(String username);

}
