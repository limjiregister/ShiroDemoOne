package controller;

import domain.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ShiroDao;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2016/9/3 11:57
 */

@Controller
public class LoginCtrl extends BaseCtrl {


	@Autowired
	private ShiroDao shiroDao;

	/**
	 * GET 登录
	 *
	 * @return {String}
	 */
	@RequestMapping(value = "/doLogin.req", method = RequestMethod.GET)
	public String login() {

		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "redirect:/doLogin.req";
		}
		return "doLogin";
	}


	/**
	 * 实际的登录代码
	 * 如果登录成功，跳转至首页；登录失败，则将失败信息反馈对用户
	 *
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/doLogin.req",method = RequestMethod.POST)
	public Response doLogin(HttpServletRequest request ){
		String msg = "";
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		System.out.println("userName:"+ userName);
		System.out.println("password:"+ password);

		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		try {

			subject.login(token);

		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
			System.out.println(msg);
			return loginFailure(msg);
		} catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
			System.out.println(msg);
			return loginFailure(msg);
		} catch (LockedAccountException e) {
			msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
			System.out.println(msg);
			return loginFailure(msg);
		} catch (DisabledAccountException e) {
			msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
			System.out.println(msg);
			return loginFailure(msg);
		} catch (ExpiredCredentialsException e) {
			msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
			System.out.println(msg);
			return loginFailure(msg);
		} catch (UnknownAccountException e) {
			msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
			System.out.println(msg);
			return loginFailure(msg);
		} catch (UnauthorizedException e) {
			msg = "您没有得到相应的授权！" + e.getMessage();
			System.out.println(msg);
			return loginFailure(msg);
		}
		System.out.println("hahahahahah");

		return loginSuccess();
	}

}
