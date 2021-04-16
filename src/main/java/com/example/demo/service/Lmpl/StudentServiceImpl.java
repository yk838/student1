package com.example.demo.service.Lmpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.service.StrdentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class StudentServiceImpl implements StrdentService{

	@Resource
	StudentDao studentDao;
	
	@Override
	public PageInfo<Map<String, Object>> queryStudentList(Map<String, Object> parMap) {
		
		int pageNo = (int)parMap.get("pageNo");//当前页
		int pageSize = (int)parMap.get("pageSize");//每页条数
		
		PageHelper.startPage(pageNo,pageSize);
        List<Map<String, Object>> queryStudentList = studentDao.queryStudentList(parMap);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(queryStudentList);
        return pageInfo;
	}
	
	@Override
	public Map<String, Object> queryStudentInfo(Map<String, Object> parMap) {
		
        Map<String, Object> queryStudentInfo = studentDao.queryStudentInfo(parMap);
        return queryStudentInfo;
	}

	@Override
	public int insertStudent(Student student) {
		int insertNum = studentDao.insertStudent(student);
		return insertNum;
	}

	@Override
	public int updateStudent(Map<String, Object> parMap) {
		int updateNum = studentDao.updateStudent(parMap);
		return updateNum;
	}

	@Override
	public int deleteStudent(Map<String, Object> parMap) {
		int deleteNum = studentDao.deleteStudent(parMap);
		return deleteNum;
	}

}
