package com.sboot.service;

import java.util.List;

import com.sboot.document.Customer;

public interface IServiceCustomer {
	
	public String registerCustomer(Customer emp);
	
	public String registerCustomerBatch(List<Customer> list);
	
	public Customer fetchCustomer(String id);
	
	public List<Customer> fetchAll(Class<Customer> list);
	
	public List<Customer> showCustomersByNumberAndAddress(Long num,String addrss,Class<Customer> list);
	

	public List<Customer> showCustomersByCbill(Integer num,Class<Customer> list);
	
	public String updateCustomer(String id,String adds,String name,Class<Customer> list);
	
	public String updateCustomerAddrss(String regexp,String newaddrs,Class<Customer> cls);
	
	public String registerOrUpdate(String add,Integer cbill,Class<Customer> cls,String newAdd);
	
	public String removeCustomer(String id,Class<Customer> cls);
	
	public List<Customer> findAllandRemove(Class<Customer> cls,Integer cbill);
	
	
	
	
}
