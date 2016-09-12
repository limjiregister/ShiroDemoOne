/** Created on 2016/9/4 */

app.controller("mainCtrl",["$http", "$scope", "LoginAndOut", "toaster", "userSession", function ($http, $scope, LoginAndOut, toaster, userSession) {

		/** init the loginInfo object*/
		$scope.loginInfo = {};
		$scope.ifLogin = userSession.ifLogin;
		/** login function*/
		$scope.goLogin = function () {

			LoginAndOut.loginValidation($scope.loginInfo).success(function (response) {

				if (response.responseCode) {

					toaster.pop({
						type: 'success',
						title: '欢迎登陆',
						body: response.msg,
						showCloseButton: true,
						timeout: 500
					});

					userSession.create(response.data, null, null);
					$scope.ifLogin = userSession.ifLogin;
					window.sessionStorage.setItem("currentUser", response.data);
					window.location.href = "/home.req";
				} else {

					toaster.pop({
						type: 'error',
						title: '验证发生错误',
						body: response.msg,
						showCloseButton: true,
						timeout: 3000
					});
				}

			});

		};


	/**
	 * 登出方法
	 */
		$scope.goLogout = function () {

			LoginAndOut.logoutRequest().success(function (resp) {

				if (resp.responseCode) {

					userSession.destory();
					window.location.reload("/home.req");

				}

			});

		};

	}]);

