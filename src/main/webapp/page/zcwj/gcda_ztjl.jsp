<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工程档案状态记录</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript">
$(function(){
	loadZjxdList();
});
function loadZjxdList(){
	var params={'gcdaZtjl.daid':parent.obj.id};
	$('#zjxfgrid').datagrid({
		url : '/zhglpt/wjxt/queryZtjlByDaId.do',
		queryParams : params,
		striped : true,
		pagination : false,
		rownumbers : true,
		pageNumber : 1,
		pageSize : 3,
		height : 270,
		fitColumns:true,
		columns : [[
		{field : 'cz',title : '操作',width : 120,align : 'center',
			formatter : function(value, row, index) {
				var result = '<a href="javascript:editZjxd('+index+')" style="text-decoration:none;color:#3399CC;">编辑</a>    ';
				result += '<a href="javascript:delGcdaZtjlById('+"'"+row.id+"'"+')" style="text-decoration:none;color:#3399CC;">删除</a>';
				return result;
			}
		},
		
		{field:'jcr',title : '借出人',width : 100,align : 'center'}, 
		{field : 'jcsj',title : '借出时间',width : 150,align : 'center'},
		{field : 'jclxdh',title : '借出人联系电话',width : 150,align : 'center'}, 
		{field : 'ghr',title : '归还人',width : 150,align : 'center'}, 
		{field : 'ghsj',title : '归还时间',width : 150,align : 'center'}, 
		{field : 'ghlxdh',title : '归还人联系电话',width : 150,align : 'center'}, 
		{field : 'bz',title : '备注',width : 150,align : 'center'}
		]]
	});
}

var obj1;
var obj2;
function addzjxd(){
	obj1=parent.obj;
	YMLib.UI.createWindow('gcda_ztjl_add','新增借出记录',"/zhglpt/page/zcwj/gcda_ztjl_add.jsp",'gcda_ztjl_add',900,300);
}
function editZjxd(index){
	obj1=parent.obj;
	var data=$("#zjxfgrid").datagrid('getRows')[index];
	obj2=data;
	YMLib.UI.createWindow('gcda_ztjl_edit','编辑借出记录',"/zhglpt/page/zcwj/gcda_ztjl_edit.jsp",'gcda_ztjl_edit',900,300);
}
function delGcdaZtjlById(id){
	$.ajax({
		type:'post',
		url:'/zhglpt/wjxt/delGcdaZtjlById.do',
		dataType:'json',
		data:'gcdaZtjl.id='+id,
		success:function(data){
			if(data){
				alert("删除成功！");
				loadZjxdList();
			}else{
				alert("删除失败！");
			}
		}
	});
}
</script>
<style type="text/css">
TD {
font-size: 12px;
}
a{
text-decoration:none;
}
</style>
</head>
	<body>
		<table style="width:100%; margin-top: 0px;margin-left: 0px; background-color: #aacbf8; font-size: 12px"
			border="0" cellpadding="3" cellspacing="1">
			<tr  style="height: 30px;">
				<td colspan="6" style="background-color:#F1F8FF;color: #007DB3; font-weight: bold;width:100%;" align="center">
					<div>
            			<table id="zjxfgrid" ></table>
            		</div>
				</td>
			</tr>
			<tr style="height: 30px;">
				<td colspan="6" style="background-color: #ffffff; height: 30px;"
					align="center"><a href="javascript:addzjxd();" id="save_button"
					class="easyui-linkbutton" plain="true" iconCls="icon-save">添加</a> <a
					href="javascript:parent.$('#gcda_ztjl').window('destroy');" id="qx_window"
					class="easyui-linkbutton" plain="true" iconCls="icon-cancel">返回</a></td>
			</tr>
		</table>
	</body>
</html>