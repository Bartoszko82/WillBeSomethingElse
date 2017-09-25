package com.sda.project;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sda.project.configuration.AppConfig;
import com.sda.project.service.ItemService;
import com.sda.project.service.UserService;
 
 
public class AppMain {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
 
//        UserService userService = (UserService) context.getBean("userService");
//        	UserService userServiceII = context.getBean(UserService.class); 
//        
//        ItemService itemService = (ItemService) context.getBean("itemService");
// 
//        context.close();
    }
}
