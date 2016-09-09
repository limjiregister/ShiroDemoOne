/** Created on 2016/9/4 */

/**
 * handle the login user in session
 */
app.service("userSession", function () {

	this.ifLogin = false;

	this.create = function (userName, userId, roleId) {
		this.userName = userName;
		this.userId = userId;
		this.roleId = roleId;
		this.ifLogin = true;
	};

	this.destory = function () {

		this.userName = null;
		this.userId = null;
		this.roleId = null;
		this.ifLogin = false;
	};

	return this;

});

/*the login authority factory*/
app.factory("LoginAndOut", ["$http", function ($http) {


	var service = {

		loginValidation: function (userInputInfo) {

			return $http.post("/doLogin.req", userInputInfo);

		}

	};

	return service;

}]);