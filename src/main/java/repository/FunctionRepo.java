package repository;

import domain.Function;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FunctionRepo extends JpaRepository<Function,Integer > {
}
