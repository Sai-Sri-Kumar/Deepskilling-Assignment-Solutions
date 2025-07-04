package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);


    @Autowired
    private EmployeeService employeeService;



    public void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee();
        employee.setId(1); // Set ID (adjust based on your data)
        employee.setName("John Doe"); // Set name
        employeeService.addEmployee(employee);
        LOGGER.info("Employee added: id={}, name={}", employee.getId(), employee.getName());
        LOGGER.info("End");
    }

    public static void main(String[] args) {
        LOGGER.info("Inside main");
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        OrmLearnApplication app = context.getBean(OrmLearnApplication.class);
        app.testGetAllCountries();
        app.testAddEmployee();
    }
}