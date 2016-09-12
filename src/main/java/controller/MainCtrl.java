package controller;

import com.alibaba.fastjson.JSON;
import Utils.MD5Util;
import domain.User;
import service.ShiroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created on 2016/7/25 20:16
 */
@Controller
public class MainCtrl {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ShiroDao shiroDao;


	@RequestMapping(value = {"/home.req",  "/second.req", "/third.req"}, method = RequestMethod.GET)
	public String homePage() {

		switch (request.getRequestURI()) {

			case "/second.req":
				return "second";
			case "/third.req":
				return "third";
			case "/home.req":
				return "home";
			default:
				return "";
		}

	}

	@ResponseBody
	@RequestMapping(value = "/add.req", method = RequestMethod.POST)
	public String add() {

		/**   获取前端传过来的参数  **/
		Map<String, Object> searchParam = WebUtils.getParametersStartingWith(request, "");
		/**   密码加密  **/
		searchParam.put("password", MD5Util.MD5(String.valueOf(searchParam.get("password"))));
		/**   转为实体类  **/
		User user = JSON.parseObject(JSON.toJSONString(searchParam), User.class);

		shiroDao.saveUser(user);

		return "";

	}

}
