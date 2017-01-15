package com.sda.project;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sda.project.configuration.AppConfig;
import com.sda.project.service.ItemService;
import com.sda.project.service.UserService;
 
 
public class AppMain {
 
    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
 
        UserService userService = (UserService) context.getBean("userService");
        
        ItemService itemService = (ItemService) context.getBean("itemService");
 
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
