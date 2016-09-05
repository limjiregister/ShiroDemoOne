package repository;

import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2016/8/7 15:19
 */
public interface ShiroRepo extends JpaRepository<User,Integer> {



}
