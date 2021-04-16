package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

/**
 * 学生相关
 * @author YK
 *
 */
@Mapper
public interface StudentDao {

	/**
	 * 查询学生信息
	 * @return
	 */
	List<Map<String, Object>> queryStudentList(Map<String, Object> parMap);

	/**
	 * 查询单个用户信息
	 * @param parMap
	 * @return
	 */
	Map<String, Object> queryStudentInfo(Map<String, Object> parMap);

	/**
	 * 新增学生信息
	 * @param student
	 * @return
	 */
	int insertStudent(Student student);

	/**
	 * 修改学生信息
	 * @param parMap
	 * @return
	 */
	int updateStudent(Map<String, Object> parMap);

	/**
	 * 删除学生信息
	 * @param parMap
	 * @return
	 */
	int deleteStudent(Map<String, Object> parMap);

}
