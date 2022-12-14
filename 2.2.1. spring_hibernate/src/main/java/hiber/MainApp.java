package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      Car car1 = new Car("nn", 0);
      Car car2 = new Car("Porshe", 6);
      Car car3 = new Car("Lada", 1);

      userService.add(new User("Vadim", "Drz", "vaddgdf@gmail.com", car1));
      userService.add(new User("Dmitriy", "Xdd", "hfgsh@gmail.com", car2));
      userService.add(new User("Joske", "Xsdd", "hgfsjgsfj@gmail.com", car3));

      User userWithCar1 = userService.getUserByCar("Lada",1);
      User userWithCar2 = userService.getUserByCar("Porshe",6);
      User userWithCar3 = userService.getUserByCar("nn",0);

      System.out.println();
      System.out.println("Id = " + userWithCar1.getId());
      System.out.println("First Name = " + userWithCar1.getFirstName());
      System.out.println("Last Name = " + userWithCar1.getLastName());
      System.out.println("Email = " + userWithCar1.getEmail());
      System.out.println("____________________________________________");
      System.out.println("Id = " + userWithCar2.getId());
      System.out.println("First Name = " + userWithCar2.getFirstName());
      System.out.println("Last Name = " + userWithCar2.getLastName());
      System.out.println("Email = " + userWithCar2.getEmail());
      System.out.println("____________________________________________");
      System.out.println("Id = " + userWithCar3.getId());
      System.out.println("First Name = " + userWithCar3.getFirstName());
      System.out.println("Last Name = " + userWithCar3.getLastName());
      System.out.println("Email = " + userWithCar3.getEmail());
      System.out.println("____________________________________________");

      context.close();
   }
}
