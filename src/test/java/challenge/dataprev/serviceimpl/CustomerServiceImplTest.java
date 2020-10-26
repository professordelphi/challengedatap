package challenge.dataprev.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import challenge.dataprev.dto.CustomerRequestDto;
import challenge.dataprev.entity.Customer;
import challenge.dataprev.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@Spy
	private CustomerServiceImpl customerServiceImpl;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	File file;

	@Test(expected = Exception.class)
	public void findAllTest() throws IOException {

		//Popular dados

		Customer custumer = new Customer();

		custumer.setAddress("Rua A");
		custumer.setCpf("12345678911");
		custumer.setName("Marcos");
		custumer.setId(1l);
		List<Customer> value = new ArrayList<Customer>();
	//	value.add(custumer);

		CustomerRequestDto customerRequestDto = new CustomerRequestDto();
		
		customerRequestDto.setName(custumer.getName());
		customerRequestDto.setCpf(custumer.getCpf());
		customerRequestDto.setAddress(custumer.getAddress());
		customerRequestDto.setId(custumer.getId());
		
		this.customerServiceImpl.save(customerRequestDto);
		
		value = this.customerServiceImpl.getFindAll();
		//exec
		when(this.customerRepository.findAll()).thenReturn(value);
       //verification
		assertEquals("Marcos", value.get(0).getName());
		
	}

	@Test(expected = Exception.class)
	public void getCustomerById() {
		// TODO Auto-generated method stub
		Customer custumer = new Customer();

		custumer.setAddress("Rua A");
		custumer.setCpf("12345678911");
		custumer.setName("Marcos");
		custumer.setId(1l);

		//exec
		Optional<Customer> value = this.customerServiceImpl.getCustomerById(custumer.getId());

		when(this.customerRepository.findById(value.get().getId())).thenReturn(value);
       //verification
		assertEquals("Marcos", value.get().getName());

	}

	@Test(expected = Exception.class)
	public void saveTest() throws Exception{

		CustomerRequestDto customerRequestDto = new CustomerRequestDto();
		customerRequestDto.setAddress("Rua A");
		customerRequestDto.setCpf("12345678911");
		customerRequestDto.setName("Marcos");

		Customer cP = new Customer();
		cP.setAddress("Rua A");
		cP.setCpf("12345678911");
		cP.setName("Marcos");

		when(this.customerServiceImpl.save(customerRequestDto)).thenReturn(cP);

	

	}

	@Test(expected = Exception.class)
	public void saveTestNull() throws Exception{
		CustomerRequestDto customerRequestDto = mock(CustomerRequestDto.class);

		Customer value = this.customerServiceImpl.save(customerRequestDto);

		assertNull(value);

	}

	@Test(expected = Exception.class)
	public void updateTest() throws Exception{

		CustomerRequestDto customerRequestDto = new CustomerRequestDto();
		customerRequestDto.setAddress("Rua A");
		customerRequestDto.setCpf("12345678911");
		customerRequestDto.setName("Marcos");

		Customer cP = new Customer();
		cP.setId(1L);
		cP.setAddress("Rua A");
		cP.setCpf("12345678911");
		cP.setName("Marcos");
		when(this.customerServiceImpl.update(customerRequestDto,1l)).thenReturn(cP);

		assertEquals("Marcos", cP.getName());
		assertNotNull(cP);
	}

	@Test(expected = Exception.class)
	public void updateTestNull() throws Exception{
		CustomerRequestDto customerRequestDto = mock(CustomerRequestDto.class);
        Long id =1l;
		Customer value = this.customerServiceImpl.update(customerRequestDto, id);
		assertNotEquals("Rua A", customerRequestDto.getAddress());
		assertNull(value);

	}
	
	
}
