//package com.ddlab.rnd.test;
//
//import java.util.List;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ddlab.rnd.entity.UserEntity;
//import com.ddlab.rnd.service.IUserService;
//
//public class Test1 {
//
//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		
//		
//		MyServices services = (MyServices) context.getBean("myServices");
//		System.out.println("services---------->"+services);
//		System.out.println("------>>>>>>>>>"+services.getUserService());
//		
//		IUserService userService = services.getUserService();
//		
//		UserEntity userEntity = new UserEntity("Deba1");
//		userService.save(userEntity);
//		
//		List<UserEntity> usersList = (List<UserEntity>) userService.getAll();
//		for(UserEntity user : usersList) {
//			System.out.println(user.getId()+"---->"+user.getName());
//		}
//		
//		UserEntity user1 = userService.getById(1L);
//		System.out.println("User Name :::"+user1.getName());
//	}
//}
