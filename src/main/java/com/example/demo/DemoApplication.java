package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.OrderService;
import com.example.demo.service.PayPalPaymentService;
import com.example.demo.service.ShopifyPaymentService;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		// Creatng a repository
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		// var orderService = context.getBean(OrderService.class);
		// // OrderService orderService = new OrderService(new PayPalPaymentService());
		// orderService.placeOrder();

		// var orderService2 = context.getBean(OrderService.class);
		// // OrderService orderService = new OrderService(new PayPalPaymentService());
		// orderService2.placeOrder();

		var repositoryDept = context.getBean(DepartmentRepository.class);

		// // Creatng a new deparment 
		var department = new Department();
		department.setName("Sales");

		// // Saving the department
		repositoryDept.save(department);

		// // // Retrieving a department
		var dept = repositoryDept.findById(1L).get();
		if (dept == null)
		 	System.out.println("Department not found in the department!");
		else
		  	System.out.println("Dept id: " + dept.getId() + "  Dept name: " + dept.getName());
				
	}
}


