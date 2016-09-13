package service;

import domain.Function;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2016/9/13.
 */
public interface FunctionDao {

	Page<Function> loadAllFunctions(Integer pageNo);
}
