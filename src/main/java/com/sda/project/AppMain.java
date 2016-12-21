package com.sda.project;
 
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sda.project.configuration.AppConfig;
import com.sda.project.model.User;
import com.sda.project.service.UserService;
 
 
public class AppMain {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
 
        UserService service = (UserService) context.getBean("userService");
 
//        /*
//         * Create Employee1
//         */
//        User user1 = new User();
//        user1.setLogin("Han Yenn");
// 
//        /*
//         * Create Employee2
//         */
// 
//        /*
//         * Persist both Employees
//         */
//        service.saveUser(user1);
// 
//        /*
//         * Get all employees list from database
//         */
//        List<User> users = service.findAllUsers();
//        for (User u : users) {
//            System.out.println(u);
//        }
 
        context.close();
    }
}