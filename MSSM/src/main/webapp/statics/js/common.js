function page_nav(frm, num) {
	if(typeof(frm)!='object'){
		frm=document.forms[0];
	}
	frm.currentPageNo.value = num;
	frm.submit();
}
function jump_to(frm,pageno){
	if(typeof(frm)!='object'){
		frm=document.forms[0];
	}
    var regexp=/^\d+$/;
	if(!regexp.test(pageno)){
	  alert('请输入正确的数字!');
	  return false;
	}
	if(pageno==frm.pageNo.value){
		return false;
	}
	if(pageno>0 && pageno<=parseInt(frm.totalPageCount.value)){
		page_nav(frm,pageno);
		return false;
	}else{
	  alert('页号错误！');
	  return false;
	}
}