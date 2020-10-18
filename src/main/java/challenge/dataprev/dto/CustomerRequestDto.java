package challenge.dataprev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

	private Long id;

	
	private String name;

	
	private String cpf;

	
	private String address;
	
}