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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import challenge.dataprev.dto.CustomerRequestDto;
import challenge.dataprev.entity.Customer;
import challenge.dataprev.repository.CustomerRepository;

@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	File file;

	@Test(expected = Exception.class)
	public void findAllTest() throws IOException {

		List<Customer> value = new ArrayList<Customer>();

		Customer custumer = new Customer();

		custumer.setAddress("Rua A");
		custumer.setCpf("12345678911");
		custumer.setName("Marcos");
		custumer.setId(1l);

		value.add(custumer);

		value = this.customerServiceImpl.getFindAll();
		when(this.customerRepository.findAll()).thenReturn(value);

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

		Optional<Customer> value = this.customerServiceImpl.getCustomerById(custumer.getId());
		// value = this.customerRepository.findById(custumer.getId());
		when(this.customerRepository.findById(value.get().getId())).thenReturn(value);

		assertEquals("Marcos", value.get().getName());

	}

	@Test
	public void saveTest() {

		CustomerRequestDto customerRequestDto = new CustomerRequestDto();
		customerRequestDto.setAddress("Rua A");
		customerRequestDto.setCpf("12345678911");
		customerRequestDto.setName("Marcos");

		Customer cP = new Customer();
		cP.setAddress("Rua A");
		cP.setCpf("12345678911");
		cP.setName("Marcos");

		when(this.customerServiceImpl.save(customerRequestDto)).thenReturn(cP);

		assertEquals("Marcos", cP.getName());

	}

	@Test
	public void saveTestNull() {

		CustomerRequestDto customerRequestDto = mock(CustomerRequestDto.class);

		Customer value = this.customerServiceImpl.save(customerRequestDto);

		assertNull(value);

	}

	@Test
	public void updateeTest() {

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

	@Test
	public void updateTestNull() {

		CustomerRequestDto customerRequestDto = mock(CustomerRequestDto.class);
        Long id =1l;
		Customer value = this.customerServiceImpl.update(customerRequestDto, id);
		assertNotEquals("Rua A", customerRequestDto.getAddress());
		assertNull(value);

	}
	


}
