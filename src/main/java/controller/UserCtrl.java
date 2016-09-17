package controller;

import Utils.MD5Util;
import com.alibaba.fastjson.JSON;
import domain.Response;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;
import service.RoleDao;
import service.ShiroDao;

import java.util.Map;

/**
 * Created on 2016/9/17 21:19
 */
@Controller
public class UserCtrl extends BaseCtrl{

	@Autowired
	private ShiroDao shiroDao;

	@Autowired
	private RoleDao roleDao;
	/**
	 * 新增用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addUser.req", method = RequestMethod.POST)
	public Response addUser() {

		/**   获取前端传过来的参数  **/
		Map<String, Object> searchParam = WebUtils.getParametersStartingWith(request, "");
//		Integer roleId = (Integer) searchParam.get("roleId");
		searchParam.replace("roleId", roleDao.getRoleById(Integer.parseInt(searchParam.get("roleId").toString())));
		/**   密码加密  **/
		searchParam.put("password", MD5Util.MD5(String.valueOf(searchParam.get("password"))));
		/**   转为实体类  **/
		User user = JSON.parseObject(JSON.toJSONString(searchParam), User.class);
		return loadDataSuccess(shiroDao.saveOrUpdateUser(user));
	}

	@ResponseBody
	@RequestMapping(value = "/updateUserInfo.req",method = RequestMethod.POST)
	public Response updateUserInfo() {
		/**   获取前端传过来的参数  **/
		Map<String, Object> searchParam = WebUtils.getParametersStartingWith(request, "");

		User user = shiroDao.getUserById(Integer.parseInt(searchParam.get("id").toString()));
//		if (user.getRoleId().getId() != Integer.parseInt(searchParam.get("roldId").toString())) {
//			user.setRoleId(roleDao.getRoleById(Integer.parseInt(searchParam.get("roleId").toString())));
//		}
		user.setCellPhone(searchParam.get("cellPhone").toString());
		user.setEmail(searchParam.get("email").toString());
		user.setUserName(searchParam.get("userName").toString());
		user.setPassword(MD5Util.MD5(String.valueOf(searchParam.get("password"))));
		return loadDataSuccess(shiroDao.saveOrUpdateUser(user));
	}


	/**
	 * 删除用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delUserById.req",method = RequestMethod.POST)
	public Response delUserById() {
		shiroDao.deleteUserById(Integer.parseInt(request.getParameter("id")));
		return loadDataSuccess(null);
	}

	/**
	 * 获取所有用户资料
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loadAllUsers.req",method = RequestMethod.POST)
	public Response getAllUsers() {
		int pageNo = 1;

		if (request.getParameter("id")!= null) {
			pageNo = Integer.parseInt(request.getParameter("id"));
		}

		return loadDataSuccess(shiroDao.getAllUsers(pageNo));
	}

}
