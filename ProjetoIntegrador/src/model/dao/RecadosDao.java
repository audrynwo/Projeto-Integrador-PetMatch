package model.dao;

import model.entities.Anuncios;
//import java.util.List;
import model.entities.Recados;

public interface RecadosDao {

	void insert(Recados obj);
	void update(Recados obj);
	void deleteById(int id);
	public Recados findById(Integer id);

}
