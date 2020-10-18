package challenge.dataprev.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import challenge.dataprev.dto.CustomerRequestDto;
import challenge.dataprev.entity.Customer;
import challenge.dataprev.repository.CustomerRepository;
import challenge.dataprev.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired 
	CustomerRepository customerRepository;
	
	Customer customer;
	
	@Override
	public List<Customer> getFindAll() {
		// TODO Auto-generated method stub
	return this.customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return this.customerRepository.findById(id).orElse(null);
	}

	@Override
	public Customer save(CustomerRequestDto customerRequestDto) {

		customer = new Customer();
		customer.setName("Nome Marcos");
		customer.setAddress("Endereco Rua marangua");
		customer.setCpf("12345");
		
		//inserir o map
		return this.customerRepository.save(customer);
	
	}

	@Override
	public Customer update(CustomerRequestDto CustomerRequestDto, Long id) {
		// TODO Auto-generated method stub
		//completar
		customer = new Customer();
		customer.setName("Nome Marcos");
		customer.setAddress("Endereco Rua marangua");
		customer.setCpf("12345");
       return this.customerRepository.save(customer);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
      this.customerRepository.deleteById(id);
	}

}
