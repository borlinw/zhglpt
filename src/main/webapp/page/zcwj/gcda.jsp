<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="${pageContext.request.contextPath}/css/searchAndNavigation.css" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Top.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/util/jquery.cookie.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/widget/newlhgdialog/lhgcore.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/widget/newlhgdialog/lhgdialog.min.js"></script>
	<script type="text/javascript" src="js/zcwj.js"></script>
	<style>
		#p_top{height:33px;line-height:33px;letter-spacing:1px;text-indent:18px;background:url(${pageContext.request.contextPath}/images/jianjiao.png) 8px 0 no-repeat;}
		#righttop{height:33px;background:url(${pageContext.request.contextPath}/images/righttopbg.gif) 0 0 repeat-x;}
	</style>
	<script type="text/javascript">
	$(function(){
		$("#kssj").datebox({    
		});  
		$("#jssj").datebox({    
		});  
		showAll();
		$(".pagination-page-list").css("width","4em");
		$(".combo.datebox").css("width","107px");
		$(".combo.datebox").find("input").css("width","84px");
	});
	
		
		function showAll(){
			var gydw=$.cookie("unit");
			var kssj=$("#kssj").datebox('getValue');
			var jssj=$("#jssj").datebox('getValue');
			//alert(kssj+"---"+jssj+"---"+gydw);
			$('#datagrid').datagrid({    
			    url:'/zhglpt/wjxt/selectqtwjlist.do',
			    striped:true,
			    pagination:true,
			    rownumbers:true,
			    pageNumber:1,
			    pageSize:10,
			    height:$(window).height()-$(window).height()*0.25,
			    width:$(window).width()-$(window).width()*0.016,
			    queryParams: {
			    	xmmc: $("#xmmc").val(),
			    	damc: $("#damc").val(),
			    	bzdw: $("#bzdw").val(),
			    	kssj:kssj,
			    	jssj:jssj
				},
			    columns:[[
			        {field:'c',title:'操作',width:150,align:'center',formatter:function(value,row,index){
			        	//if(row.fbdw==$.cookie("unit"))
			        		return'<a style="text-decoration:none;color:#3399CC;" href="#" onclick="editwj('+index+')">编辑</a>    '+
			        	 '<a style="text-decoration:none;color:#3399CC;" href="#" onclick="ckwj('+index+')">查看</a>    '+
			        	 '<a style="text-decoration:none;color:#3399CC;" href="#" onclick="deletewj('+index+')">删除</a>    '+
			        	 '<a style="text-decoration:none;color:#3399CC;" href="#" onclick="ztjl('+index+')">状态记录</a>';
			        	//else	 return '<a style="text-decoration:none;color:#3399CC;" href="#" onclick="ckwj('+index+')">查看</a>    ';
			        }},
			        {field:'xmmc',title:'项目名称',width:100,align:'center'},
			        {field:'damc',title:'文件名称',width:100,align:'center'},
			        {field:'bzdw',title:'编制单位',width:200,align:'center'},
			        {field:'lb',title:'类别',width:100,align:'center'},
			        {field:'rq',title:'日期',width:100,align:'center'},
			        {field:'cs',title:'册数',width:50,align:'center'},
			        {field:'cfwz',title:'存放位置',width:50,align:'center'},
			        {field:'bz',title:'备注',width:251,align:'center'}
			    ]]    
			}); 
		}
		
		//状态记录
		function ztjl(index){

			var data=$("#datagrid").datagrid('getRows')[index];
			obj=data;
			YMLib.UI.createWindow('gcda_ztjl','状态记录',"/zhglpt/page/zcwj/gcda_ztjl.jsp",'gcda_ztjl',1000,400);
		}
		//添加
		function xxtztj(){
			var weatherDlg = new J.dialog( {
				id : 'id2',
				title : '工程档案添加',
				page : 'gcda_add.jsp?url='+"/zhglpt/wjxt/uploadWjFile.do"+'&flag=gcda.jsp'+'&id='+new Date().getTime(),
				width : 570,
				height : 530,
				top : 0,
				rang : true,
				resize : false,
				cover : true
			});
			weatherDlg.ShowDialog();
			return false;
		}
		//编辑
		function editwj(index){
			var data=$("#datagrid").datagrid('getRows')[index];
			obj=data;
			var weatherDlg = new J.dialog( {
				id : 'id2',
				title : '工程档案编辑',
				page : 'gcda_xg.jsp?url='+"/zhglpt/wjxt/uploadWjFile.do"+'&flag=gcda.jsp'+'&id='+data.id,
				width : 570,
				height : 530,
				top : 0,
				rang : true,
				resize : false,
				cover : true
			});
			weatherDlg.ShowDialog();
			return false;
		}
		//删除
		function deletewj(index){
			if(confirm("您确认删除吗？")){
			var data=$("#datagrid").datagrid('getRows')[index];
			$.ajax({
				type:'post',
				url:'/zhglpt/wjxt/deleteQtwj.do',
				data:"wjgl.wjid="+data.id+"&wjgl.id="+data.id,
				dataType:'json',
				async:false,
				success:function(msg){
					if(Boolean(msg)){
						alert('删除成功！');
						showAll();
					}else{
						alert('删除失败！');
					}
				}
			});	
			}
		}
		
		var obj=new Object();
		function ckwj(index){
			var data=$("#datagrid").datagrid('getRows')[index];
			obj=data;
			var weatherDlg = new J.dialog( {
				id : 'id2',
				title : '工程档案编辑',
				page : 'gcda_ck.jsp?url='+"/zhglpt/wjxt/uploadWjFile.do"+'&flag=gcda.jsp'+'&id='+data.id,
				width : 570,
				height : 530,
				top : 0,
				rang : true,
				resize : false,
				cover : true
			});
			weatherDlg.ShowDialog();
			return false;
		}
		
	</script>
	<style type="text/css">
<!--
a:link {
 text-decoration: none;
}
a:visited {
 text-decoration: none;
}
a:hover {
 text-decoration: none;
}
a:active {
 text-decoration: none;
}
-->
</style>
</head>
<body>
	<div style="text-align: left; font-size: 12px; margin: 0px;">
		<table width="99.8%" border="0" style="margin-top: 1px; margin-left: 1px;" cellspacing="0" cellpadding="0">
			<tr>
			<td>
			<div id="righttop">
						<div id="p_top">当前位置>&nbsp;文件管理>&nbsp;工程档案</div>
			</div>
	           </td>
        	</tr>
        	<tr>
        		<td align="left" style="padding-left: 10px; padding-right: 10px;">
        			<fieldset style="width:99.7%; text-align: left; vertical-align: middle;margin: 1% 0px 0px 0px;">
        				<legend style="padding: 0 0 0 0; font-weight: bold; color: Gray; font-size: 12px;">
        					<font style="color: #0866A0; font-weight: bold"></font>
        				</legend>
        				<div>
        					<p style="margin: 1% 0px 1% 2%;">
        						<span>文件时间：</span>
        							<input type="text" id="kssj" >
        							<span>至</span>
        							<input type="text" id="jssj" >
        							&nbsp;
									 <span>项目名称：</span>
        							 <input class="combo-text validatebox-text" id="xmmc" style="width: 113px; height: 20px; line-height: 20px;" type="text">
        							 <span>档案名称：</span>
        							 <input class="combo-text validatebox-text" id="damc" style="width: 113px; height: 20px; line-height: 20px;" type="text">
									 <span>编制单位：</span>
        							 <input class="combo-text validatebox-text" id="bzdw" style="width: 113px; height: 20px; line-height: 20px;" type="text">
<%-- 									<input type="image" name="btnSelect" id="btnSelect" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/Serch02.gif'" alt="查询" onmouseout="this.src='${pageContext.request.contextPath}/images/Button/Serch01.gif'" src="${pageContext.request.contextPath}/images/Button/Serch01.gif" style="border-width:0px;cursor: hand;" /> --%>
                                    <img alt="查询" src="${pageContext.request.contextPath}/images/Button/Serch01.gif" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/Serch02.gif'"
                                        onmouseout="this.src='${pageContext.request.contextPath}/images/Button/Serch01.gif' "  style="border-width:0px;cursor: hand;vertical-align: middle;" onclick="showAll()"/>
            
                                    <img alt="添加" src="${pageContext.request.contextPath}/images/Button/tianjia1.gif" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/tianjia2.gif'"
                                        onmouseout="this.src='${pageContext.request.contextPath}/images/Button/tianjia1.gif' " onclick="xxtztj()" style="border-width:0px;cursor: hand;vertical-align: middle;" />
                                    
        					</p>
        				</div>
        			</fieldset>
        		</td>
        	</tr>

            <tr>
                <td style="padding-top: 1%;padding-left:10px;">
				<table id="datagrid" >
				</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>