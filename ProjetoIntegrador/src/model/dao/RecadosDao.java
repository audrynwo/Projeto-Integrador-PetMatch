package model.dao;

//import java.util.List;
import model.entities.Recados;

public interface RecadosDao {

	void insert(Recados obj);
	void update(Recados obj);
	void deleteById(int id);
	//List<Recados> findByEspecie(String especie);

}
