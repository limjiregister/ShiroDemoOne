package service;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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
	public User saveUser(User user) {
		return shiroRepo.saveAndFlush(user);
	}
}
