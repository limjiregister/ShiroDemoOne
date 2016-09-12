/** Created on 2016/9/4 */

app.controller("mainCtrl",
	["$http", "$scope", "LoginAndOut", "toaster", "userSession", function ($http, $scope, LoginAndOut, toaster, userSession) {
		/** init the loginInfo object*/
		$scope.loginInfo = {};

		$scope.ifLogin = userSession.ifLogin;
		console.log("ifLogin0000000:", $scope.ifLogin);
		console.log("localStorage sessionStorage:", window.sessionStorage.getItem("currentUser"));
		/** login function*/
		$scope.goLogin = function () {

			LoginAndOut.loginValidation($scope.loginInfo).success(function (response) {

				console.log("then-response:", response);

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
					console.log("localStorage sessionStorage:333", window.sessionStorage.getItem("currentUser"));
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

		$scope.goLogout = function () {

			LoginAndOut.logoutRequest().success(function (resp) {

				console.log(angular.equals(resp, 1));

				if (angular.equals(resp,1)) {

					userSession.destory();
					console.log("sdfsdfsdfd", userSession.ifLogin);
					window.location.reload("/home.req");

				}

			});

		};

	}]);


app.controller("loginCtrl", ['$scope', function ($scope) {


}]);