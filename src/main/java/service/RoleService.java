package service;

import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoleRepo;


@Service
public class RoleService implements RoleDao {

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public Role getRoleById(Integer id) {
		return roleRepo.getOne(id);
	}
}
