package controller;


import domain.Response;

/**
 * Created on 2016/9/3 22:15
 */
public abstract class BaseCtrl {

	/**
	 * 登录成功返回参数
	 * @return
	 */
	public Response loginSuccess() {

		Response response = new Response();
		response.setResponseCode(true);
		response.setMsg("验证成功，现在为您跳转到管理页面.....");

		return response;
	}

	/**
	 * 返回登录错误信息
	 * @param errorMsg
	 * @return
	 */
	public Response loginFailure(String errorMsg) {

		Response response = new Response();
		response.setResponseCode(false);
		response.setMsg(errorMsg);

		return response;
	}

}
