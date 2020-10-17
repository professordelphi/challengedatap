package challenge.dataprev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/*
 * Marcos Amaral Dev Java
 * 17-10-2020
 * Challenge DataPrev
 * Crud Customer 
 * Class Customer*/
@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", length = 50, nullable = false, unique = false)
	private String name;

	@Column(name = "CPF", length = 50, nullable = false, unique = true)
	private String cpf;

	@Column(name = "ADDRESS", length = 50, nullable = false, unique = false)
	private String address;
	
}
