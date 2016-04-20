package com.cn.hnust.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;

import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.Person;

@Controller
@RequestMapping("/rest")
public class RestController {

	/** 日志实例 */
	private static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/hello", produces = MediaTypes.JSON_UTF_8)
	public @ResponseBody String hello() {
		return "你好！hello";
	}

	@RequestMapping(value = "/say/{msg}", produces = MediaTypes.JSON_UTF_8 ,method = RequestMethod.POST)
	public @ResponseBody String say(@PathVariable(value = "msg") String msg) {
		return "{\"msg\":\"you say:'" + msg + "'\"}";
	}
	
	@RequestMapping(value = "/test", produces = MediaTypes.JSON_UTF_8)
	public @ResponseBody Person getRequest(@RequestBody Person p){
		Person person = new Person();
		person.setAge(p.getAge());
		person.setId(p.getId());
		person.setName(p.getName());
		person.setSex(p.getSex());
		return person;
	}
	

	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET)
	public @ResponseBody Person getPerson(@PathVariable("id") int id) {
		logger.info("获取人员信息id=" + id);
		Person person = new Person();
		person.setName("张三");
		person.setSex("男");
		person.setAge(30);
		person.setId(id);
		return person;
	}

	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.DELETE)
	public @ResponseBody Object deletePerson(@PathVariable("id") int id) {
		logger.info("删除人员信息id=" + id);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "删除人员信息成功");
		return jsonObject;
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public @ResponseBody Object addPerson(Person person) {
		logger.info("注册人员信息成功id=" + person.getId());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "注册人员信息成功");
		return jsonObject;
	}

	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public @ResponseBody Object updatePerson(Person person) {
		logger.info("更新人员信息id=" + person.getId());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "更新人员信息成功");
		return jsonObject;
	}

}
