package service;

import domain.User;
import org.springframework.data.domain.Page;

/**
 * Created on 2016/8/7 15:20
 */
public interface ShiroDao {

	User saveOrUpdateUser(User user);

	User getUserById(Integer id);

	Page<User> getAllUsers(Integer pageNo);

	void deleteUserById(Integer id);

}
