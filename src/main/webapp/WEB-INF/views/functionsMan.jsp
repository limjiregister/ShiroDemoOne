<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Home</title>
</head>
<body>


<h2 align="center">功能列表</h2>

<div id="production_table">
	<table class="table table-hover table-bordered" si-table>
		<thead>
		<tr>
			<th ng-click="predicate='id'; reverse=!reverse">序号</th>
			<th ng-click="predicate='production'; reverse=!reverse">功能名称</th>
			<th ng-click="predicate='price'; reverse=!reverse">请求地址</th>
			<th ng-click="predicate='store'; reverse=!reverse">备注说明</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<tr ng-repeat="i in items">
			<td>{{ i.id }}</td>
			<td>{{ i.nameZh }}</td>
			<td>{{ i.reqUrl}}</td>
			<td>{{ i.remark}}</td>
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
		<h3 class="modal-title">I'm a modal!</h3>
	</div>
	<div class="modal-body">

		<label style="margin-left: 20px">功能名称</label>
		<input type="text" ng-model="newFun.nameZh" ng-required="true">

		<label style="margin-left: 20px">请求地址</label>
		<input type="text" ng-model="newFun.reqUrl" ng-required="true">

		<label style="margin-left: 20px">功能备注</label>
		<input type="text" ng-model="newFun.remark">

	</div>
	<div class="modal-footer">
		<button class="btn btn-primary" type="button" ng-click="ok()">OK</button>
		<button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
	</div>
</script>


</html>
