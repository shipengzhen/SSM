package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.entity.Grade;

/**
 * 年纪接口
 * @author 施鹏振
 *
 */
public interface IGradeDao {
	/**
	 * 新增年纪
	 * @param grade
	 * @return
	 */
	public int insertGrade(Grade grade);
	/**
	 * 通过年纪Id修改年纪名称(使用@param注解实现多参数入参)
	 * @param gradeId
	 * @return
	 */
	public int updateGradeName(@Param("gradeId")int gradeId,@Param("gradeName")String gradeName);
	/**
	 * 通过年纪Id删除年纪
	 * @param gradeId
	 * @return
	 */
	public int deleteGrade(int gradeId);
	
	/**
	 * 查询各年级学生信息
	 * @return List<Grade>
	 */
	public List<Grade> getStudent();
	
}
