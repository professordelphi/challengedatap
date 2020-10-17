package challenge.dataprev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge.dataprev.entity.Customer;

/*
 * Marcos Amaral Dev Java
 * 17-10-2020
 * Challenge DataPrev
 * Crud Customer 
 * Customer Repository*/
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	

}
