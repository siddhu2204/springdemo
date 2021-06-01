package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	// private CustomerDAO customerdao;
	private CustomerService customerservice;

	@RequestMapping("/list")
	public String listCustomers(Model model) {

		List<Customer> listcustomers = customerservice.getCustomers();

		System.out.println("customer details " + listcustomers);

		model.addAttribute("customers", listcustomers);

		return "list-Customers";

	}

	@RequestMapping("/showAddForm")
	public String showForm(Model model) {
		Customer customer = new Customer();

		model.addAttribute("AddCustomer", customer);

		return "Customer-Master";

	}

	@PostMapping("/saveCustomer")
	public String AddCustomer(@ModelAttribute("AddCustomer") Customer customer) {
		customerservice.save(customer);

		return "redirect:/customer/list";

	}

	@GetMapping("/showUpdateForm")
	public String updateCustomer(@RequestParam("customerId") int custid, Model model) {

		Customer thecustomer = customerservice.getCustomer(custid);

		System.out.println("into Update Method " + thecustomer);

		model.addAttribute("AddCustomer", thecustomer);

		return "Customer-Master";

	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int cid, Model model) {

		customerservice.deleteCustomer(cid);

		return "redirect:/customer/list";

	}
}
