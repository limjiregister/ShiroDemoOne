/** Created on 2016/9/4 */

app.directive('sideMenuDirective',function () {
	return {
		restrict: "AE",
		scope: {},
		replace:true,
		templateUrl:"/template/sideMenu.jsp",
		controller:"sideMenuCtrl"

	};
});
