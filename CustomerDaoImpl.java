package com.luv2code.springdemo.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override

	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer order by firstName", Customer.class);

		List<Customer> customers = query.getResultList();

		System.out.println("Customers are  " + customers);

		return customers;
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int custid) {

		System.out.println("id of Customer " + custid);

		Session session = sessionFactory.getCurrentSession();

		Customer theCustomer = session.get(Customer.class, custid);

		System.out.println("Customer Details in DAO Method " + theCustomer);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int cid)
	{
		Session session = sessionFactory.getCurrentSession();
		
		Customer cust = session.get(Customer.class,cid);
		
		
		session.delete(cust);
		
		
	}

}
