package com.sboot.service;

import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.sboot.document.Customer;


@Service("custService")
public class IServiceCustomerImp implements IServiceCustomer {

	
	
	@Autowired
	private MongoTemplate temp;
	
	@Override
	public String registerCustomer(Customer emp) 
	{
		Customer insert = temp.insert(emp);
		
		//Employee2 collection will be created
	  // Customer insert2 = temp.insert(emp, "Employee2");
		return "Customer saved with id value:"+insert.getId();
		
		
			}

	@Override
	public String registerCustomerBatch(List<Customer> list) {
		Collection<Customer> all = temp.insertAll(list);
		int size = all.size();
		return "documents saved with id values:"+size;
	}

	@Override
	public Customer fetchCustomer(String id) {
		 return temp.findById(id, Customer.class);
		
		
	}

	@Override
	public List<Customer> fetchAll(Class<Customer> list) {
		
		return temp.findAll(list);
	}

	@Override
	public List<Customer> showCustomersByNumberAndAddress(Long num, String addrs,Class<Customer> list) {
	Query query=new Query();
	query.addCriteria(Criteria.where("PhoneNo").is(num).andOperator(Criteria.where("addrss").is(addrs)));
     return temp.find(query,list);
	

	}

	@Override
	public List<Customer> showCustomersByCbill(Integer num,Class<Customer> list) {
		
		Query query=new Query(Criteria.where("cbillScore").gt(num));
		 return temp.find(query, list);
	}

	@Override
	public String updateCustomer(String id, String adds, String name, Class<Customer> list) {
		
		Query query=new Query(Criteria.where("id").is(id));
		Update update=new Update();
		update.set("name", name);
		update.set("addrss", adds);
	    Customer customer = temp.findAndModify(query, update, list);
	    return customer==null?"Customer not found":"customer found and updated"; 
		
	}

	@Override
	public String updateCustomerAddrss(String regexp, String newaddrs,Class<Customer> cls)
	{
		Query query=new Query(Criteria.where("addrss").regex(regexp));
		Update update=new Update();
		update.set("addrss", newaddrs);
		UpdateResult result = temp.updateMulti(query, update, cls);
		return "Number of records modified are:"+result.getModifiedCount();
		
		
	}

	@Override
	public String registerOrUpdate(String add, Integer cbill, Class<Customer> cls,String newAdd) 
	{
		Query query=new Query(Criteria.where("cbillScore").gte(cbill).andOperator(Criteria.where("addrss").is(add)));
		Update update=new Update();
		//useed for both insertion and updation
		update.set("addrss", newAdd);
		update.set("cbillScore", 950);
		//setonInsert insert operations only performs
		/*update.setOnInsert("addrss", "Rome");
		update.setOnInsert("cbillScore", 670);*/
		
		UpdateResult upsert = temp.upsert(query, update, cls);
		return "Documents updated are:"+upsert.getModifiedCount();
		
		
	}

	@Override
	public String removeCustomer(String number,Class<Customer> cls) {
		
		Query query=new Query(Criteria.where("id").is(number));
		Customer remove = temp.findAndRemove(query, cls);
		 return "customer removed with:"+number;
		 
	}
	
	public List<Customer> findAllandRemove(Class<Customer> cls,Integer cbill)
	{
		Query query=new Query(Criteria.where("cbillScore").lte(cbill));
		List<Customer> list = temp.findAllAndRemove(query, cls);
		return list;
	}
	
}
