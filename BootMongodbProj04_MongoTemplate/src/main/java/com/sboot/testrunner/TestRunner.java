package com.sboot.testrunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.sboot.document.Customer;
import com.sboot.service.IServiceCustomerImp;

@Component("runner")
public class TestRunner implements CommandLineRunner {

    
    
	
	@Autowired
	private IServiceCustomerImp empService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			//empService.getAllEmployees().forEach(System.out::println);
			
			
			//empService.getAllEmployeeEqual(25000.0,"Mumbai").forEach(System.out::println);
			
			//empService.getAllEmployeeBetweeen(25000.0, 30000.0).forEach(System.out::println);
			
			//empService.getAllEmployeeEquals(30).forEach(System.out::println);
			
			//empService.getAllEmployeeNotEquals("Mumbai").forEach(System.out::println);
			
			//empService.getAllEmployeeInCity("Mumbai","Pune","Hyderbad").forEach(System.out::println);
			
			//empService.getAllEmployeeAnd("Anita", "Mumbai").forEach(System.out::println);
			
			//empService.getAllEmployeeExsistsCol().forEach(System.out::println);
			
			/*Customer emp=new Customer("balu","balu@gmail.com",42323234545l,800,"Ananthapur");
					
			String registerEmployee = empService.registerCustomer(emp);
			System.out.println(registerEmployee);*
			
			Customer cust=new Customer("jashwanth","jash@gmail.com",9325235235l,800,"Ananthapur");
			Customer cust1=new Customer("askash","akash@gmail.com",49583928532l,800,"kurnool");
			Customer cust2=new Customer("vamsi","vamsi@gmail.com",453535355l,800,"Hyderbad");
			Customer cust3=new Customer("rajuu","raju@gmail.com",9876545675l,800,"Delhi");
			Customer cust4=new Customer("ravi","ravi@gmail.com",3434343656l,800,"Nellore");
		   List<Customer> list = List.of(cust,cust1,cust2,cust3,cust4);
		   String batch = empService.registerCustomerBatch(list);
		   System.out.println(batch);*/
			
//			Customer fetchCustomer = empService.fetchCustomer("68a8afd58150e0d046c8eda8");
//			System.out.println(fetchCustomer);
			Class<Customer> cls=Customer.class;
			
			//empService.fetchAll(cls).forEach(System.out::println);
			//empService.showCustomersByNumberAndAddress(42323234545l, "Ananthapur", cls).forEach(System.out::println);
			 //empService.showCustomersByCbill(750, cls).forEach(System.out::println);
			//String updateCustomer = empService.updateCustomer("68a8afd58150e0d046c8eda7", "Dubai", "Alli", cls);
			//System.out.println(updateCustomer);
			/*String updateCustomerAddrss = empService.updateCustomerAddrss("^A" ,"NewYork", cls);
			System.out.println(updateCustomerAddrss);*/
			
			/*String update = empService.registerOrUpdate("NewuYork",800, cls,"Ananthapur");
			System.out.println(update);*/
			
//			String customer = empService.removeCustomer("68aa9d8c64fb47baf42446df",cls);
//			System.out.println(customer);
//			
			 empService.findAllandRemove(cls,600).forEach(System.out::println);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
			}

}
