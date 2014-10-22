package controllers;

import models.book.data.UserDTO;
import models.book.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.list;
import views.html.single;

import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 22.10.2014.
 */
public class Users extends Controller {
    public static Result list(){
        ApplicationContext ctx = new FileSystemXmlApplicationContext("conf/ApplicationContext.xml");
        UserService userService = (UserService)ctx.getBean("UserService");
        List<UserDTO> users = userService.getUsers();

        return ok(list.render(users));
    }

    public static Result single(int id){
        ApplicationContext ctx = new FileSystemXmlApplicationContext("conf/ApplicationContext.xml");
        UserService userService = (UserService)ctx.getBean("UserService");

        return ok(single.render(userService.getUser(id)));
    }
}
