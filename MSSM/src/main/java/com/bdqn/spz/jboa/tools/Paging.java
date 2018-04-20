package com.bdqn.spz.jboa.tools;

import java.util.List;

/**
 * 分页工具类 使用范型集合
 * 
 * @author 施鹏振
 * @param <T>
 */
public class Paging<T> {

	private T t;// 传入参数对象
	private Integer currentPageNo; // 当前页
	private Integer pageSize; // 页大小
	private Integer totalCount;// 记录总数
	private Integer totalPageCount;// 总页数
	private List<T> list; // 展示集合
	private Integer pageNo;// 分页时的前一个值

	/**
	 * 传入参数对象
	 * 
	 * @return
	 */
	public T getT() {
		return t;
	}

	/**
	 * 传入参数对象
	 * 
	 * @param t
	 */
	public void setT(T t) {
		this.t = t;
	}

	/**
	 * 当前页
	 * 
	 * @return
	 */
	public Integer getCurrentPageNo() {
		return currentPageNo;
	}

	/**
	 * 当前页
	 * 
	 * @param currentPageNo
	 */
	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	/**
	 * 页大小
	 * 
	 * @return
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 页大小
	 * 
	 * @param pageSize
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 记录总数
	 * 
	 * @return
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * 记录总数
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 总页数
	 * @return
	 */
	public Integer getTotalPageCount() {
		totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		return totalPageCount;
	}

	/**
	 * 总页数
	 * 
	 * @param totalPageCount
	 */
	// public void setTotalPageCount(Integer totalPageCount) {
	// this.totalPageCount = totalPageCount;
	// }
	/**
	 * 展示集合
	 * 
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 展示集合
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
