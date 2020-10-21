package challenge.dataprev.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

	@Id
	private Long id;

	@Column(nullable =false, unique = false)
	private String name;

	@Column(nullable =false, unique = true)
	private String cpf;

	@Column(nullable =false, unique = false)
	private String address;
	
}
