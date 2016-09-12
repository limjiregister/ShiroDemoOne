/** Created on 2016/9/4 */

/**
 * handle the login user in session
 */
app.service("userSession", function ($window) {

	var a = $window.sessionStorage.getItem("loginFlag");

	if (a == undefined) {
		this.ifLogin = false;
	} else {

		this.ifLogin = $window.sessionStorage.getItem("loginFlag");
	}


	this.create = function (userName, userId, roleId) {
		this.userName = userName;
		this.userId = userId;
		this.roleId = roleId;
		$window.sessionStorage.setItem("loginFlag", true);
	};

	this.destory = function () {

		this.userName = null;
		this.userId = null;
		this.roleId = null;
		$window.sessionStorage.setItem("loginFlag", false);
	};

	return this;

});

/*the login authority factory*/
app.factory("LoginAndOut", ["$http", function ($http) {


	var service = {
		//登录验证请求
		loginValidation: function (userInputInfo) {

			return $http.post("/doLogin.req", userInputInfo);

		},
		logoutRequest: function () {//登出请求
			return $http.post("/goLogout.req", {});
		}

	};

	return service;

}]);