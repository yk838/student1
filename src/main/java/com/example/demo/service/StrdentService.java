package com.example.demo.service;

import java.util.Map;

import com.example.demo.entity.Student;
import com.github.pagehelper.PageInfo;

/**
 * 学生相关
 * @author YK
 *
 */
public interface StrdentService {

	/**
	 * 分页查询学生列表
	 * @param parMap
	 * @return
	 */
	PageInfo<Map<String, Object>> queryStudentList(Map<String, Object> parMap);

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
