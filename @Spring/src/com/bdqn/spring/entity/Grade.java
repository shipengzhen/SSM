package com.bdqn.spring.entity;

import java.util.List;

import org.springframework.stereotype.Component;


/**
 * 年纪实现类
 * @author 施鹏振
 *
 */
@Component("Grade")
public class Grade{
	
	//带参构造学生Id和学生姓名
//	@Autowired
//	public Grade(@Qualifier("Grade")int gradeId,String gradeName) {
//	    this.gradeId = gradeId;
//	    this.gradeName=gradeName;
//	}
	
	private int gradeId;//年纪id
	private String gradeName;//年纪名称
	private Student student;//学生对象
	private List<Student> students;//学生对象集合
	
	/**
	 * 学生集合
	 * @return
	 */
	public List<Student> getStudents() {
		return students;
	}
	/**
	 * 学生集合
	 * @param students
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	/**
	* 年纪id
	* @return
	*/
	public int getGradeId() {
		return gradeId;
	}
	/**
	 * 年纪id
	 * @param gradeId
	 */
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	/**
	 * 年纪名称
	 * @return
	 */
	public String getGradeName() {
		return gradeName;
	}
	/**
	 * 年纪名称
	 * @param gradeName
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	/**
	 * 学生对象
	 * @return
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * 学生对象
	 * @param student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
