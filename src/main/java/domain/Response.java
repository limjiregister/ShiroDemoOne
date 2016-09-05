package domain;

import java.io.Serializable;

/**
 * Created on 2016/9/3 22:18
 */
public class Response implements Serializable {

	private static final long serialVersionUID = -7156647580931615066L;

	private boolean responseCode;
	private String msg = "";
	private Object data;

	public Response() {
	}

	public boolean isResponseCode() {
		return responseCode;
	}

	public void setResponseCode(boolean responseCode) {
		this.responseCode = responseCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
