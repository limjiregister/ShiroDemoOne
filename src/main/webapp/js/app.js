var app = angular.module("myapp", ["ui.router","ui.bootstrap",'toaster','ngAnimate']);

app.run(["$rootScope","userSession", function ($rootScope, userSession) {

	var loginInfoName = window.localStorage.getItem("currentUser");
	console.log("loginInfoName:",loginInfoName);
	console.log("userSession:",userSession.ifLogin);

}]);

//ui-router
app.config(function ($stateProvider, $urlRouterProvider, $locationProvider) {

	// $urlRouterProvider.otherwise("doLongin")
	$locationProvider.html5Mode(true);

	$stateProvider.state("doLogin", {
		url: "/doLogin",
		templateUrl: "/doLogin.req",
		controller: "loginCtrl"

	})
});

/**
 * request encode setting
 */
app.config(function ($httpProvider) {


	$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
	$httpProvider.defaults.transformRequest = function (data) {
		if (data === undefined) {
			return data;
		}
		return $.param(data);
	}
});

/**
 * handle the request and push a interceptor into httpUrlHttp
 */
app.factory('HttpInterceptor', ['$q', '$timeout', HttpInterceptor]);
function HttpInterceptor($q, $timeout) {

	var d = $q.defer();

	return {
		request: function (config) {

			return config;
		},
		requestError:function (err) {

			return $q.reject(err);
		},
		response:function (resp) {

			return $q.resolve(resp);
			
		},
		responseError:function (err) {

			return $q.reject(err);
		}


	};

};

app.config(['$httpProvider', function ($httpProvider) {

	$httpProvider.interceptors.push(HttpInterceptor);

}]);