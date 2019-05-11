package com.byc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class User {

	private String name;

	private Integer age;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "userName"+name+"age"+age;
	}
//lombok 底层使用字节码技术 ASM 修改字节码文件 生成set、get方法
	public static void main(String[] args) {
		User user = new User();
		user.setAge(20);
		user.setName("苏方宁");
		//System.out.println(user.toString());
		//lombok 减少代码重复
		log.info(user.toString());
	}
}