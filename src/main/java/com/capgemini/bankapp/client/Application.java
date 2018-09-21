package com.capgemini.bankapp.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankController;

public class Application {
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		BankController bankController= context.getBean("bankController",BankController.class);
		System.out.println(bankController.getBalance(2025));
		System.out.println(bankController.deposit(2025,5000));
		
		
	}

}
