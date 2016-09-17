package repository;

import domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2016/9/17 22:00
 */
public interface RoleRepo extends JpaRepository<Role,Integer> {
}
