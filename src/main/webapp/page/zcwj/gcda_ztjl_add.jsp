<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新增借出记录</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/autocomplete/jquery.autocomplete.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/uploader/swfobject.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/uploader/jquery.uploadify.v2.1.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/lwxm/js/lwxm.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/lwxm/js/wqsj.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/jhgl/js/wqsj.js"></script>
<script type="text/javascript">
$(function(){
	$("#jcsj").datebox({    
	});  
	$("#ghsj").datebox({    
	});
	$(".combo.datebox").css("width","100px");
	$(".combo.datebox").find("input").css("width","77px");
});
</script>
</head>
<body>

	<center>
		<table width="98%" height="60%" cellpadding="0" cellspacing="0" border="0" style="margin-top: 10px; margin-left: 13px;">
			<tr>
				<td><br />
					<table width="100%" border="0"
						style="border-style: solid; border-width: 3px 1px 1px 1px; border-color: #55BEEE #C0C0C0 #C0C0C0 #C0C0C0; height: 45px;"
						cellspacing="0" cellpadding="0">
						<tr style="height: 35px;">
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									借出人：</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input  id="jcr" name="jcr" type="text"  style="width: 80px;" />&nbsp;
							</td>
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									借出时间：</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input  id="jcsj" name="jcsj" type="text"  style="width: 80px;"/>&nbsp;
							</td>
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">
									借出人联系电话：</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input  id="jclxdh" name="jclxdh" type="text"  style="width: 80px;"/>&nbsp;
							</td>
						</tr>
						<tr style="height: 35px;">
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">归还人：</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px;">
								<input id="ghr" name="ghr" type="text"  style="width: 80px;" />&nbsp;
							</td>
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">归还时间：</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input id="ghsj" name="ghsj" type="text"  style="width: 80px;" />&nbsp;
							</td>
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">归还人联系电话：</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;">
								<input id="ghlxdh" name="ghlxdh" type="text"  style="width: 80px;" />&nbsp;
							</td>
							
						</tr>
						<tr style="height: 35px;">
							<td style="border-style: none none solid none; border-width: 1px; border-color: #C0C0C0; color: #007DB3; font-weight: bold; font-size: small; text-align: right; background-color: #F1F8FF; width: 15%; padding-right: 5px;">
								<b><font color="#009ACD" style="cursor: hand; font-size: 12px">备注：</font></b>
							</td>
							<td style="border-left: 1px solid #C0C0C0; border-right: 1px solid #C0C0C0; border-top: 1px none #C0C0C0; border-bottom: 1px solid #C0C0C0; width: 19%; text-align: left; padding-left: 10px; font-size: 12px;" colspan="5">
								<input  type="textarea" id="bz" name="bz">
							</td>
							
						</tr>
					</table>
					<table width="100%" border="0"
						style="border-style: solid; border-width: 3px 1px 1px 1px; margin-top: 20px; border-color: #55BEEE #C0C0C0 #C0C0C0 #C0C0C0; height: 45px;"
						cellspacing="0" cellpadding="0">
						<tr style="height: 30px;">
							<td align="center">
							<td align="center">
								<input type="image" name="btnAdd" id="btnAdd" onclick="addZjxd()"
								onmouseover="this.src='${pageContext.request.contextPath}/images/Button/baocun2.gif'" alt="保存"
								onmouseout="this.src='${pageContext.request.contextPath}/images/Button/baocun1.gif'"
								src="${pageContext.request.contextPath}/images/Button/baocun1.gif" style="border-width: 0px;" />
								&nbsp; 
								<input type="image" name="btnCancel" id="btnCancel" onmouseover="this.src='${pageContext.request.contextPath}/images/Button/fanhui2.GIF'" alt="返回"
								onclick="parent.$('#zjxd').window('destroy');" onmouseout="this.src='${pageContext.request.contextPath}/images/Button/fanhui1.GIF'"
								src="${pageContext.request.contextPath}/images/Button/fanhui1.GIF" style="border-width: 0px;" />
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<script type="text/javascript">
		
			function addZjxd(){
				var gcdaZtjl={'gcdaZtjl.daid':parent.obj1.id,'gcdaZtjl.jcr':$('#jcr').val(),
						'gcdaZtjl.jcsj':$("input[name='jcsj']").val(),'gcdaZtjl.jclxdh':$('#jclxdh').val(),
						'gcdaZtjl.ghr':$('#ghr').val(),'gcdaZtjl.ghsj':$("input[name='ghsj']").val(),
						'gcdaZtjl.ghlxdh':$('#ghlxdh').val(),
						'gcdaZtjl.bz':$('#bz').val()};
				$.ajax({
					type:'post',
					url:'/zhglpt/wjxt/addGcdaZtjl.do',
					dataType:'json',
					data:gcdaZtjl,
					success:function(data){
						alert("保存成功！");
						parent.loadZjxdList();
						parent.$('#gcda_ztjl_add').window('destroy');
					}
				});
			}
		</script>
	</center>
</body>
</html>