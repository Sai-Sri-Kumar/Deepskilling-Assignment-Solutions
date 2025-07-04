package org.example;

import org.example.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get bookService bean from Spring container
        BookService service = context.getBean("bookService", BookService.class);

        // Test dependency injection
        service.addBook("Spring in Action");
    }
}
