$(function() {

	createMenu('LeftMenu',{
		id:'menu_010401',
		title:'用户管理',
		imgSrc:'../../images/yhgl.png',
		renderTo:'left_menu1',
		href:'./yhgl.jsp'
	});

	createMenu('LeftMenu',{
		id:'menu_010402',
		title:'部门管理',
		imgSrc:'../../images/bmgl.png',
		renderTo:'left_menu1',
		href:'./bmgl.jsp'
	});

	createMenu('LeftMenu',{
		id:'menu_010403',
		title:'权限分配',
		imgSrc:'../../images/jsgl.png',
		renderTo:'left_menu1',
		href:'./jsgl.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010404',
		title:'编目编码',
		imgSrc:'../../images/bmbm.png',
		renderTo:'left_menu1',
		href:'./bmbm.jsp'
	});
	
	menuQx();
	$("div[id^='menu'] a").click(function(){
		$(this).css("color","red");
		$(this).parents($("div[id^='menu']")).siblings().children("a").css("color","black");
	})
});
function menuQx(){
	var qx=getQxfromSession('qx2').split(",");
	for(var i=0;i<qx.length;i++){
		if($("#menu_"+qx[i])!=null) $("#menu_"+qx[i]).show();
	}
}