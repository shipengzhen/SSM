function page_nav(frm,num){
		/*alert(frm.softwareName.value);
		alert(frm.status.value);
		alert(frm.flatformId.value);
		alert(frm.categoryLevel1.value);
		alert(frm.categoryLevel2.value);
		alert(frm.categoryLevel3.value);
		alert(currentPageNo);*/
		frm.pageIndex.value = num;
		frm.submit();
}
