package challenge.dataprev.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired(required=false)
	private CustomerService customerService;

	public CustomerController()
	{}
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/test")
	private String getTest() {
		
		return "Test access";
	}
	

	@ApiOperation(value = "Return people list")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Return people list"),
	    @ApiResponse(code = 403, message = "You don´t have permission to access"),
	    @ApiResponse(code = 500, message = "Service out"),
	})
	@GetMapping
	private ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> listOf = customerService.getFindAll();

		return ResponseEntity.ok(listOf);
	}

	// It posts the Customer detail in the database
	@PostMapping
	private ResponseEntity<Customer> save(@RequestBody CustomerRequestDto customerRequestDto) {

		Customer customer = customerService.save(customerRequestDto);

		return ResponseEntity.ok(customer);
	}

	// It finds customer by id
	@GetMapping("/{customerid}")
	private ResponseEntity<Customer> getCustomerById(@PathVariable("customerid") Long customerid) {

		Optional<Customer> customer = this.customerService.getCustomerById(customerid);

		if (customer.isPresent()) {
			return ResponseEntity.ok(customer.get());

		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	// It deletes a specified customer
	@DeleteMapping("/{customerid}")
	private void deletecustomer(@PathVariable("customerid") Long customerid) {
		this.customerService.delete(customerid);
	}

	// It updates the customer detail
	@PutMapping("/{customerid}")
	private ResponseEntity<Customer> update(@RequestBody CustomerRequestDto customerRequestDto,
			@PathVariable("customerid") Long customerid) {
		Customer customer = this.customerService.update(customerRequestDto, customerid);
		return ResponseEntity.ok(customer);
	}
}
