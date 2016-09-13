package service;

import domain.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import repository.FunctionRepo;

/**
 * Created by Administrator on 2016/9/13.
 */
@Service
public class FunctionService implements FunctionDao {

	@Autowired
	private FunctionRepo functionRepo;

	@Override
	public Page<Function> loadAllFunctions(Integer pageNo) {

		PageRequest request = new PageRequest(pageNo - 1, 15);

		return functionRepo.findAll(request);
	}


}
