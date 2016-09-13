/** Created on 2016/9/4 */

app.controller("mainCtrl",
	["$http", "$scope", "LoginAndOut", "toaster", "userSession", function ($http, $scope, LoginAndOut, toaster, userSession) {

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


app.controller("sideMenuCtrl", ["$scope", "baseMethod", function ($scope, baseMethod) {


	baseMethod.loadData("/loadAllFunctions.req", {}).success(function (resp) {

		console.log("resp", resp);

		if (resp.responseCode) {

			$scope.funs = resp.data.content;
		}

	});


}]);

app.controller("functionsManCtrl", ["$scope", "baseMethod", "$uibModal", function ($scope, baseMethod, $uibModal) {

	baseMethod.loadData("/loadAllFunctions.req", {}).success(function (resp) {
		if (resp.responseCode) {
			$scope.items = resp.data.content;
			$scope.totalItems = resp.data.totalElements;
			$scope.pageCount = resp.data.totalPages;
		}
	});

	$scope.AddNew = function () {

		$uibModal.open({
			animation: true,
			templateUrl: 'functionEdit.html',
			size: "lg",
			controller: function ($scope, $uibModalInstance) {

				$scope.ok = function () {

					console.log("newOne:",$scope.newFun);
					alert("TODO::");

				};
				$scope.cancel = function () {
					$uibModalInstance.dismiss('cancel');
				};

			}
		});

	};

	$scope.EditOne = function (item) {

		$uibModal.open({
			animation: true,
			templateUrl: 'functionEdit.html',
			size: "lg",
			resolve: {
				item: function () {
					return item;
				}
			},
			controller: function ($scope, $uibModalInstance, item) {

				$scope.newFun = item;

				$scope.ok = function () {

					console.log("newOne:", $scope.newFun);
					alert("TODO::");

				};

				$scope.cancel = function () {
					$uibModalInstance.dismiss('cancel');
				};

			}
		});
	};

	$scope.DeleteOne = function (i) {

		alert("not finish yet!")
	};


}]);

app.controller("userManCtrl", ["$scope", function ($scope) {


}]);


