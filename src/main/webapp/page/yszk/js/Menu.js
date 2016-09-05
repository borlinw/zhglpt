$(function() {
	createMenu('LeftMenu',{
		id:'menu_010201',
		title:'挂账管理',
		imgSrc:'../../images/gzgl.png',
		renderTo:'left_menu1',
		href:'./zcwj.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010202',
		title:'销账管理',
		imgSrc:'../../images/xzgl.png',
		renderTo:'left_menu1',
		href:'./qtwj.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010203',
		title:'账单查询',
		imgSrc:'../../images/zdcx.png',
		renderTo:'left_menu1',
		href:'./jhwj.jsp'
	});
	menuQx();
	$("div[id^='menu'] a").click(function(){
		$(this).css("color","#0000ee");
		$(this).parents($("div[id^='menu']")).siblings().children("a").css("color","#551a8b");
	})
});
function menuQx(){
	var qx=getQxfromSession('qx2').split(",");
	for(var i=0;i<qx.length;i++){
		if($("#menu_"+qx[i])!=null) $("#menu_"+qx[i]).show();
	}
}