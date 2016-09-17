package service;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ShiroRepo;

/**
 * Created on 2016/8/7 15:21
 */

@Service
public class shiroService implements ShiroDao {

	@Autowired
	private ShiroRepo shiroRepo;

	@Transactional
	@Override
	public User saveOrUpdateUser(User user) {

		return shiroRepo.saveAndFlush(user);
	}

	@Override
	public User getUserById(Integer id) {
		return shiroRepo.getOne(id);
	}

	@Override
	public Page<User> getAllUsers(Integer pageNo) {
		PageRequest request = new PageRequest(pageNo - 1, 15);
		return shiroRepo.findAll(request);
	}

	@Transactional
	@Override
	public void deleteUserById(Integer id) {
		shiroRepo.delete(id);
	}
}
