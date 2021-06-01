package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.Dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerdao;

	@Override
	@Transactional

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerdao.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer customer)
	{
		customerdao.save(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int custid) {
		return customerdao.getCustomer(custid);
		
		
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int cid) {
		
		customerdao.deleteCustomer(cid);
		}

}
