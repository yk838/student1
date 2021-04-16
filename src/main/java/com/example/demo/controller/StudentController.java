package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StrdentService;
import com.github.pagehelper.PageInfo;

/**
 * 学生相关接口
 * @author YK
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	@Resource
	StrdentService strdentService;
	
	/**
	 * 分页查询学生信息
	 * @param request
	 * @param response
	 * @return
	 */
	@CrossOrigin //解决跨域
	@RequestMapping("/queryStudentList")
	public Map<String,Object> queryStudentList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="pageNo",defaultValue="1")int pageNo, 
			@RequestParam(value="pageSize",defaultValue="10")int pageSize) {
		Map<String,Object> parMap = new HashMap<>();
		Map<String,Object> resMap = new HashMap<>();
		
		try {
			String userId = request.getParameter("userId");//学号
			String name = request.getParameter("name");//姓名
			
			parMap.put("userId", userId);
			parMap.put("name", name);
			parMap.put("pageNo", pageNo);//当前页
			parMap.put("pageSize", pageSize);//每页条数
			PageInfo<Map<String,Object>> queryStudentList = strdentService.queryStudentList(parMap);
			
			resMap.put("success", true);
			resMap.put("data", queryStudentList);
		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("success", false);
			resMap.put("msg", "未知错误");
			resMap.put("e", e);
		}
		
		return resMap;
	}
	
	@CrossOrigin //解决跨域
	@RequestMapping(value="/queryStudentInfo")
	public Map<String,Object> queryStudentInfo(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> parMap = new HashMap<>();
		Map<String,Object> resMap = new HashMap<>();
		
		try {
			String userId = request.getParameter("userId");//学号
			
			parMap.put("userId", userId);
			Map<String,Object> queryStudentInfo = strdentService.queryStudentInfo(parMap);
			
			resMap.put("success", true);
			resMap.put("data", queryStudentInfo);
		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("success", false);
			resMap.put("msg", "未知错误");
			resMap.put("e", e);
		}
		
		return resMap;
	}
	
	@CrossOrigin
	@RequestMapping(value="/insertStudent")
	public Map<String,Object> insertStudent(HttpServletRequest request, HttpServletResponse response,
			Student student) {
		Map<String,Object> parMap = new HashMap<>();
		Map<String,Object> resMap = new HashMap<>();
		
		try {
			int insertNum = strdentService.insertStudent(student);
			
			resMap.put("success", true);
			resMap.put("data", insertNum);
		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("success", false);
			resMap.put("msg", "未知错误");
			resMap.put("e", e);
		}
		
		return resMap;
	}
	

	@CrossOrigin
	@RequestMapping(value="/updateStudent")
	public Map<String,Object> updateStudent(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> parMap = new HashMap<>();
		Map<String,Object> resMap = new HashMap<>();
		
		try {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String birthday = request.getParameter("birthday");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			String role = request.getParameter("role");
			
			parMap.put("userId", userId);
			parMap.put("password1", password);
			parMap.put("name2", name);
			parMap.put("birthday", birthday);
			parMap.put("sex", sex);
			parMap.put("address", address);
			parMap.put("role", role);
			int updateNum = strdentService.updateStudent(parMap);
			
			resMap.put("success", true);
			resMap.put("data", updateNum);
		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("success", false);
			resMap.put("msg", "未知错误");
			resMap.put("e", e);
		}
		
		return resMap;
	}
	
	@CrossOrigin
	@RequestMapping(value="/deleteStudent")
	public Map<String,Object> deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> parMap = new HashMap<>();
		Map<String,Object> resMap = new HashMap<>();
		
		try {
			String userId = request.getParameter("userId");
			
			parMap.put("userId", userId);
			
			int deleteNum = strdentService.deleteStudent(parMap);
			
			resMap.put("success", true);
			resMap.put("data", deleteNum);
		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("success", false);
			resMap.put("msg", "未知错误");
			resMap.put("e", e);
		}
		
		return resMap;
	}
}
