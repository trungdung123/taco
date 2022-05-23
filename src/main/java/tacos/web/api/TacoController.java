package tacos.web.api;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.Ingredient;
import tacos.Taco;
import tacos.DTO.IngredientDTO;
import tacos.DTO.TacoDTO;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepo;

@RestController
@RequestMapping("/tacos")
@CrossOrigin(origins = "*")
public class TacoController {
	
	@Autowired
	private TacoRepo tacoRepo;
	
	@Autowired
	private IngredientRepository ingredientRepository;

	@GetMapping
	public List<Taco> getAllTacos (){
		return tacoRepo.findAll();
	}
	
	@PostMapping("/add")
	public Taco addNewTaco (@RequestBody TacoDTO tacoDTO) throws ParseException {
		List<Ingredient> res = new ArrayList<>();
		for (IngredientDTO i : tacoDTO.getIngredients()) {
			
			res.add(ingredientRepository.findById(i.getId()));
		}
		Taco taco = tacoDTO.toEntity();
		taco.setIngredients(res);
		System.out.println(taco.getCreatedAt());
		//return tacoRepo.save(taco);
		return taco;
	}
	
}
