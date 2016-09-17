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

	/**
	 * 启动时候首次加载数据
	 */
	loadDatas();

	function loadDatas(pageNo) {

		var args = {};

		if (pageNo != undefined) {

			args = {"pageNo": pageNo}

		}

		baseMethod.loadData("/loadAllFunctions.req", args).success(function (resp) {
			if (resp.responseCode) {
				$scope.items = resp.data.content;
				$scope.totalItems = resp.data.totalElements;
				$scope.pageCount = resp.data.totalPages;
			}
		});

	}

	/**
	 * 新增 功能 方法
	 * @constructor
	 */
	$scope.AddNew = function () {

		$uibModal.open({
			animation: true,
			templateUrl: 'functionEdit.html',
			size: "lg",
			controller: function ($scope, $uibModalInstance) {

				$scope.ok = function () {
					baseMethod.saveNewOrEdit("/saveNewFunction.req", $scope.newFun).success(function (resp) {

						if (resp.responseCode) {
							loadDatas($scope.currentPage);
							$uibModalInstance.dismiss('cancel');
							alert("保存成功!");
						}
					});

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

					baseMethod.saveNewOrEdit("/editFunction.req", $scope.newFun).success(function (resp) {

						if (resp.responseCode) {

							loadDatas($scope.currentPage);
							$uibModalInstance.dismiss('cancel');
							alert("保存成功!");
						}

					});


				};

				$scope.cancel = function () {
					$uibModalInstance.dismiss('cancel');
				};

			}
		});
	};

	$scope.DeleteOne = function (obj) {

		if (confirm("确定要删除【" + obj.nameZh + "】的信息吗？")) {

			baseMethod.deleteObj("/deleteFunction.req", {"id": obj.id}).success(function (resp) {

				if (resp.responseCode) {

					loadDatas($scope.currentPage);

				}

			});

		}

	};


}]);

app.controller("userManCtrl", ["$scope", "baseMethod", "$uibModal", function ($scope, baseMethod, $uibModal) {

	loadDatas();

	function loadDatas(pageNo) {

		var args = {};

		if (pageNo != undefined) {

			args = {"pageNo": pageNo}

		}

		baseMethod.loadData("/loadAllUsers.req", args).success(function (resp) {
			if (resp.responseCode) {
				$scope.items = resp.data.content;
				$scope.totalItems = resp.data.totalElements;
				$scope.pageCount = resp.data.totalPages;
			}
		});
	}


	/**
	 * 新增 功能 方法
	 * @constructor
	 */
	$scope.AddNew = function () {

		$uibModal.open({
			animation: true,
			templateUrl: 'functionEdit.html',
			size: "lg",
			controller: function ($scope, $uibModalInstance) {

				$scope.ok = function () {
					baseMethod.saveNewOrEdit("/addUser.req", $scope.newFun).success(function (resp) {

						if (resp.responseCode) {
							loadDatas($scope.currentPage);
							$uibModalInstance.dismiss('cancel');
							alert("保存成功!");
						}
					});

				};
				$scope.cancel = function () {
					$uibModalInstance.dismiss('cancel');
				};

			}
		});

	};

	/**
	 * 更新方法
	 * @param item
	 * @constructor
	 */
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

					baseMethod.saveNewOrEdit("/updateUserInfo.req", $scope.newFun).success(function (resp) {

						if (resp.responseCode) {

							loadDatas($scope.currentPage);
							$uibModalInstance.dismiss('cancel');
							alert("保存成功!");
							$scope.editStatus = false;
						}

					});


				};

				$scope.cancel = function () {
					$uibModalInstance.dismiss('cancel');
				};

			}
		});
	};



}]);


