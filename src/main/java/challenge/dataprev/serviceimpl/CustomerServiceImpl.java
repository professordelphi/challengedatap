package challenge.dataprev.serviceimpl;

import java.util.List;

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
		return null;
	}

	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer save(@RequestBody CustomerRequestDto customerRequestDto) {

		customer = new Customer();
		customer.setName("Nome Marcos");
		customer.setAddress("Endereco Rua marangua");
		customer.setCpf("12345");
		
		//inserir o map
		return this.customerRepository.save(customer);
	
	}

	@Override
	public void update(CustomerRequestDto CustomerRequestDto, Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
