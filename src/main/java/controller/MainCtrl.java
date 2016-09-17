package controller;

import domain.Function;
import domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FunctionDao;

/**
 * Created on 2016/7/25 20:16
 */
@Controller
public class MainCtrl extends BaseCtrl {

	@Autowired
	private FunctionDao functionDao;

	@RequestMapping(value = {"/home.req", "/userMan.req", "/functionsMan.req"}, method = RequestMethod.GET)
	public String homePage() {


		switch (request.getRequestURI()) {

			case "/userMan.req":
				return "userMan";
			case "/functionsMan.req":
				return "functionsMan";
			case "/home.req":
				return "home";
			default:
				return "";
		}

	}
	/**
	 * 返回functions数据
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loadAllFunctions.req", method = RequestMethod.POST)
	public Response loadFunctionsList() {

		Integer pageNo = 1;

		if (request.getParameter("pageNo") != null) {

			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		}

		return loadDataSuccess(functionDao.loadAllFunctions(pageNo));
	}

	/**
	 * 保存功能
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveNewFunction.req", method = RequestMethod.POST)
	public Response saveNewFunction() {

		String nameZh = request.getParameter("nameZh");
		String reqUrl = request.getParameter("reqUrl");
		String remark = request.getParameter("remark");

		Function f = functionDao.saveNewFun(new Function(null, nameZh, reqUrl, remark));
		return loadDataSuccess(f);
	}


	/**
	 * 删除功能
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteFunction.req", method = RequestMethod.POST)
	public Response deleteFunction() {

		functionDao.deleteFun(Integer.parseInt(request.getParameter("id")));
		return loadDataSuccess(null);
	}

	@ResponseBody
	@RequestMapping(value = "/editFunction.req",method = RequestMethod.POST)
	public Response editFunction() {

		Integer id = Integer.parseInt(request.getParameter("id"));

		Function function = functionDao.getFunById(id);
		function.setNameZh(request.getParameter("nameZh"));
		function.setReqUrl(request.getParameter("reqUrl"));
		function.setRemark(request.getParameter("remark"));

		return loadDataSuccess(functionDao.saveNewFun(function));

	}
}
