package challenge.dataprev.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.dataprev.dto.CustomerRequestDto;
import challenge.dataprev.entity.Customer;
import challenge.dataprev.repository.CustomerRepository;
import challenge.dataprev.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private	CustomerRepository customerRepository;
	
	
	
	@Override
	public List<Customer> getFindAll() {
		// TODO Auto-generated method stub
	return this.customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return this.customerRepository.findById(id);
	}

	@Override
	public Customer save(CustomerRequestDto customerRequestDto) {

		
		Customer customerToSave = Customer.builder()
				.name(customerRequestDto.getName()) 
				.address(customerRequestDto.getAddress())
				.cpf(customerRequestDto.getCpf())
				.build();
				
		         Customer customerSaved  = this.customerRepository.save(customerToSave);
			
		return this.customerRepository.save(customerSaved);

	}

	@Override
	public Customer update(CustomerRequestDto customerRequestDto, Long id) {
		// TODO Auto-generated method stub
		Customer customerToSave = Customer.builder()
				.id(id)
				.name(customerRequestDto.getName()) 
				.address(customerRequestDto.getAddress())
				.cpf(customerRequestDto.getCpf())
				.build();
				
		         Customer customerSaved  = this.customerRepository.save(customerToSave);
			     
		return this.customerRepository.save(customerSaved);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
      this.customerRepository.deleteById(id);
	}

}
