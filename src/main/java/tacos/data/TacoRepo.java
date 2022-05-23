package tacos.data;

import org.springframework.data.jpa.repository.JpaRepository;

import tacos.Taco;

public interface TacoRepo extends JpaRepository<Taco, Long>{

}
