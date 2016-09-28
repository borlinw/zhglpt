$(function() {
	createMenu('LeftMenu',{
		id:'menu_010101',
		title:'制度文件',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./zcwj.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010102',
		title:'制度文件',
		imgSrc:'../../images/zcwj.png',
		renderTo:'left_menu1',
		href:'./zcwjNoEdit.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010103',
		title:'办公室档案',
		imgSrc:'../../images/qtwj.png',
		renderTo:'left_menu1',
		href:'./bgda.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010104',
		title:'办公室档案',
		imgSrc:'../../images/qtwj.png',
		renderTo:'left_menu1',
		href:'./bgdaNoEdit.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010105',
		title:'工程档案',
		imgSrc:'../../images/gcwj.png',
		renderTo:'left_menu1',
		href:'./gcda.jsp'
	});
	createMenu('LeftMenu',{
		id:'menu_010106',
		title:'工程档案',
		imgSrc:'../../images/gcwj.png',
		renderTo:'left_menu1',
		href:'./gcdaNoEdit.jsp'
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