package com.bdqn.smbms.util;

/**
 * ��ҳ������
 * @author ʩ����
 *
 */
public class PageSupport {

	//��ǰҳ
	private static int currentPageNo=1;

	//ҳ��С
	//private static int pageSize;
	
	//��¼����
	//private static int tatalCount;
	
	//��ҳ��
	private static int totalPageCount=1;

	/**
	 * ��ǰҳ
	 * @return int
	 */
	public static int getCurrentPageNo() {
		return currentPageNo;
	}

	/**
	 * ��ǰҳ
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
	 * ҳ����
	 * @param tatalCount(��¼����)
	 * @param pageSize(ҳ��С)
	 * @return int
	 */
	public static int getTotalPageCount(int totalCount,int pageSize) {
		totalPageCount=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		return totalPageCount;
	}

}
