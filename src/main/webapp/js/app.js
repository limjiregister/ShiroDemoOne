var app = angular.module("myapp", ["ui.router","ui.bootstrap"]);

//ui-router
app.config(function ($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise("doLongin")

	$stateProvider.state("doLongin", {
		url: "/doLongin",
		templateUrl: "/doLongin.req",
		controller: "loginCtrl"

	})
});

app.config(function ($httpProvider) {


	$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
	$httpProvider.defaults.transformRequest = function (data) {
		if (data === undefined) {
			return data;
		}
		return $.param(data);
	}
});