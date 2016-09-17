<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<div align="center"><h1>用户中心</h1></div>
<div id="production_table">
	<table class="table table-hover table-bordered" si-table>
		<thead>
		<tr>
			<th ng-click="predicate='id'; reverse=!reverse">序号</th>
			<th ng-click="predicate='userName'; reverse=!reverse">用户名</th>
			<th ng-click="predicate='email'; reverse=!reverse">邮箱</th>
			<th ng-click="predicate='cellPhone'; reverse=!reverse">手机号码</th>
			<th>角色权限</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<tr ng-repeat="i in items">
			<td>{{ i.id }}</td>
			<td>{{ i.userName }}</td>
			<td>{{ i.email}}</td>
			<td>{{ i.cellPhone}}</td>
			<td>{{ i.roleId.nameZh}}</td>
			<td class="action-column">
				<button type="button" class="btn btn-info btn-sm" ng-click="AddNew()">新增</button>
				<button type="button" class="btn btn-info btn-sm" ng-click="EditOne(i)">编辑</button>
				<button type="button" class="btn btn-info btn-sm" ng-click="DeleteOne(i)">删除</button>
			</td>

		</tr>
		</tbody>
	</table>
</div>
<!-- 分页部件  -->
<div class="pager">
	<span>数据库一共有{{totalItems}}条记录</span><span style="margin-left: 30px">  一共有：{{pageCount}}页</span>
	<span style="margin-left: 20px">当前为第：{{currentPage}}页</span>
	<br>
	<pager page-count="pageCount" current-page="currentPage" on-page-change="onPageChange()" first-text="首页"
		   next-text="下一页" prev-text="上一页" last-text="尾页" show-goto="true" goto-text="跳转到"></pager>
</div>
</div>

</body>


<script type="text/ng-template" id="functionEdit.html">
	<div class="modal-header">
		<h3 class="modal-title">新增或更新用户信息</h3>
	</div>
	<div class="modal-body">

		<label style="margin-left: 20px">用户名</label>
		<input type="text" ng-model="newFun.userName" ng-required="true">

		<label style="margin-left: 20px">密码</label>
		<input type="text" ng-model="newFun.password" ng-required="true">

		<label style="margin-left: 20px">邮箱</label>
		<input type="text" ng-model="newFun.email" ng-required="true">

		<label style="margin-left: 20px">手机</label>
		<input type="text" ng-model="newFun.cellPhone" ng-required="true">

		<div ng-if="!editStatus">
			<label style="margin-left: 20px">角色</label>
			<input type="text" ng-model="newFun.roleId" ng-required="true">
		</div>

		<div ng-if="editStatus">
			<label style="margin-left: 20px">角色</label>
			<input type="text" ng-model="newFun.roleId.id" ng-required="true">
		</div>

	</div>
	<div class="modal-footer">
		<button class="btn btn-primary" type="button" ng-click="ok()">OK</button>
		<button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
	</div>
</script>
</html>
