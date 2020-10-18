package challenge.dataprev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import challenge.dataprev.dto.CustomerRequestDto;
import challenge.dataprev.entity.Customer;

@Service
public interface CustomerService {
		
	//all customer		
	public List<Customer> getFindAll();
	//customer
	public Customer getCustomerById(Long id);   
	//save customer
	public  Customer save(CustomerRequestDto customerRequestDto);
	//update customer
	public Customer update(CustomerRequestDto CustomerRequestDto, Long id);
	//delete customer
	public void delete(Long id);   
	
	   		

	}
	

