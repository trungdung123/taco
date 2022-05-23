package tacos.DTO;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tacos.Ingredient;
import tacos.Ingredient.Type;

@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@AllArgsConstructor
@Data
public class IngredientDTO {
	private final String id;
	private final String name;
	private final String type;

	public Ingredient toEntity () {
		return new Ingredient(id, name, Type.valueOf(type));
	}
}
