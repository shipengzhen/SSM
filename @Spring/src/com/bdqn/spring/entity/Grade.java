package com.bdqn.spring.entity;

import java.util.List;

import org.springframework.stereotype.Component;


/**
 * ���ʵ����
 * @author ʩ����
 *
 */
@Component("Grade")
public class Grade{
	
	//���ι���ѧ��Id��ѧ������
//	@Autowired
//	public Grade(@Qualifier("Grade")int gradeId,String gradeName) {
//	    this.gradeId = gradeId;
//	    this.gradeName=gradeName;
//	}
	
	private int gradeId;//���id
	private String gradeName;//�������
	private Student student;//ѧ������
	private List<Student> students;//ѧ�����󼯺�
	
	/**
	 * ѧ������
	 * @return
	 */
	public List<Student> getStudents() {
		return students;
	}
	/**
	 * ѧ������
	 * @param students
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	/**
	* ���id
	* @return
	*/
	public int getGradeId() {
		return gradeId;
	}
	/**
	 * ���id
	 * @param gradeId
	 */
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	/**
	 * �������
	 * @return
	 */
	public String getGradeName() {
		return gradeName;
	}
	/**
	 * �������
	 * @param gradeName
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	/**
	 * ѧ������
	 * @return
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * ѧ������
	 * @param student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
