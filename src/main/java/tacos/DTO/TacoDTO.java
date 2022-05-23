package tacos.DTO;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tacos.Ingredient;
import tacos.Taco;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacoDTO {

	private Long id;
	private String name;
	private String createdAt;
	private List<IngredientDTO> ingredients;
	
	public Taco toEntity () throws ParseException  {
		List<Ingredient> ingredis = ingredients.stream()
				.map(e -> e.toEntity()).collect(Collectors.toList());
		DateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");

		Date date= newFormat.parse(createdAt);
		return new Taco(name, date, ingredis);
	}
	
}
