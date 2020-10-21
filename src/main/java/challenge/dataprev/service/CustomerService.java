package challenge.dataprev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import challenge.dataprev.dto.CustomerRequestDto;
import challenge.dataprev.entity.Customer;

@Service
public interface CustomerService {
		
	//all customer		
	public List<Customer> getFindAll();
	//customer
	public Optional<Customer> getCustomerById(Long id);   
	//save customer
	public  Customer save(CustomerRequestDto customerRequestDto);
	//update customer
	public Customer update(CustomerRequestDto customerRequestDto, Long id);
	//delete customer
	public void delete(Long id);   
	
	   		

	}
	

