package tacos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import tacos.DTO.IngredientDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@AllArgsConstructor
@Data
@Entity
public class Ingredient {
	@Id
	private final String id;
	private final String name;
	@Enumerated(EnumType.STRING)
	private final Type type;

	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
	
	public IngredientDTO toDTO () {
		return new IngredientDTO(id, name, type.toString());
	}
}
