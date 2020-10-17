package challenge.dataprev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.dataprev.dto.CustomerRequestDto;
import challenge.dataprev.entity.Customer;
import challenge.dataprev.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	private ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> lista = customerService.getFindAll();

		System.out.println("proximo passo eh save" + lista);

		return ResponseEntity.ok(lista);
	}

	// It posts the Customer detail in the database
	@PostMapping
	private ResponseEntity<Customer> save(@RequestBody CustomerRequestDto customerRequestDto) {

		Customer customer = customerService.save(customerRequestDto);

		return ResponseEntity.ok(customer);
	}
	
	//It finds customer by id
	@GetMapping("/customer/{customerid}")  
	private Customer getCustomer(@PathVariable("customerid") Long customerid)   
	{  
	return this.customerService.getCustomerById(customerid);  
	}  
	
	//It deletes a specified customer  
	@DeleteMapping("/customer/{customerid}")  
	private void deletecustomer(@PathVariable("customerid") Long customerid)   
	{  
		this.customerService.delete(customerid);  
	}  
	 
	//It updates the customer detail   
	@PutMapping("/customer")  
	private ResponseEntity<Customer> update(@RequestBody CustomerRequestDto customerRequestDto)   
	{  
	    Customer customer =  this.customerService.save(customerRequestDto);  
	    return ResponseEntity.ok(customer);
	}  
}
