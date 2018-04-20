package com.bdqn.spz.jboa.tools;

import java.util.List;

/**
 * ��ҳ������ ʹ�÷��ͼ���
 * 
 * @author ʩ����
 * @param <T>
 */
public class Paging<T> {

	private T t;// �����������
	private Integer currentPageNo; // ��ǰҳ
	private Integer pageSize; // ҳ��С
	private Integer totalCount;// ��¼����
	private Integer totalPageCount;// ��ҳ��
	private List<T> list; // չʾ����
	private Integer pageNo;// ��ҳʱ��ǰһ��ֵ

	/**
	 * �����������
	 * 
	 * @return
	 */
	public T getT() {
		return t;
	}

	/**
	 * �����������
	 * 
	 * @param t
	 */
	public void setT(T t) {
		this.t = t;
	}

	/**
	 * ��ǰҳ
	 * 
	 * @return
	 */
	public Integer getCurrentPageNo() {
		return currentPageNo;
	}

	/**
	 * ��ǰҳ
	 * 
	 * @param currentPageNo
	 */
	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	/**
	 * ҳ��С
	 * 
	 * @return
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * ҳ��С
	 * 
	 * @param pageSize
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ��¼����
	 * 
	 * @return
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * ��¼����
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * ��ҳ��
	 * @return
	 */
	public Integer getTotalPageCount() {
		totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		return totalPageCount;
	}

	/**
	 * ��ҳ��
	 * 
	 * @param totalPageCount
	 */
	// public void setTotalPageCount(Integer totalPageCount) {
	// this.totalPageCount = totalPageCount;
	// }
	/**
	 * չʾ����
	 * 
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * չʾ����
	 * 
	 * @param list
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getPageNo() {
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (getTotalPageCount() < currentPageNo) {
			currentPageNo=totalPageCount;
		}
		pageNo = (currentPageNo - 1) * pageSize;
		return pageNo;
	}
	// public void setPageNo(Integer pageNo) {
	// this.pageNo = pageNo;
	// }

}
