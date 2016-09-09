/** Created on 2016/9/4 */

app.controller("mainCtrl",
	["$http", "$scope", "LoginAndOut", "toaster","userSession",function ($http, $scope, LoginAndOut, toaster, userSession) {
		/** init the loginInfo object*/
		$scope.loginInfo = {};

		console.log("ifLogin:",$scope.ifLogin);
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
					window.localStorage.setItem("currentUser", response.data);

					console.log("localStorage currentUser:",window.localStorage.getItem("currentUser"));
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

	}]);


app.controller("loginCtrl", ['$scope', function ($scope) {


}]);