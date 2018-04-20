package com.bdqn.smbms.util;

/**
 * 分页工具类
 * @author 施鹏振
 *
 */
public class PageSupport {

	//当前页
	private static int currentPageNo=1;

	//页大小
	//private static int pageSize;
	
	//记录总数
	//private static int tatalCount;
	
	//总页数
	private static int totalPageCount=1;

	/**
	 * 当前页
	 * @return int
	 */
	public static int getCurrentPageNo() {
		return currentPageNo;
	}

	/**
	 * 当前页
	 * @param currentPageNo
	 */
	public static void setCurrentPageNo(int currentPageNo) {
		if (currentPageNo<=0) {
			return;
		}else if(totalPageCount<currentPageNo) {
			return;
		}else {
			PageSupport.currentPageNo = currentPageNo;
		}
	}

	/**
	 * 页总数
	 * @param tatalCount(记录总数)
	 * @param pageSize(页大小)
	 * @return int
	 */
	public static int getTotalPageCount(int totalCount,int pageSize) {
		totalPageCount=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		return totalPageCount;
	}

}
