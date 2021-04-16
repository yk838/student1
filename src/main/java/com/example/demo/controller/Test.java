package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * @author YK
 *
 */
@RestController
@RequestMapping("/test")
public class Test {

	@RequestMapping("/select")
	public String test() {
		
		return "123123";
	}
	
	@RequestMapping("/add")
	public String add() {
		
		return "123123";
	}
//controller层：调用后端系统第一层
//	作用：接受前端传过来的参数，处理参数（权限验证，数据验证），调用service层
//service层：第二层
//	作用：处理业务逻辑，调用dao层
//dao层：第三层，跟mapper.xml文件一起组成第三层
//	作用：调用数据库查询
//entity：数据库信息实体类
//	作用：匹配数据库表，作为参数或者返回值的时候，可以自动放进去
	
	
//	@RestController：标识这个类是controller层 = 类名上面@Controller + 方法名上面@ResponseBody
//	@RequestMapping("/test")：该类或者方法的访问路径
//	@CrossOrigin：防止出现跨域问题
//	@Resource：注入类，使用一个类之前，如果该类已经被spring管理过，则可以不用new，直接注入使用
//	@Override：标识这个方法是一个重写的方法
	
}
