package model.dao;

import model.entities.Midia;

public interface MidiaDao {
	void insert(Midia obj);
	void update(Midia obj);
	void deleteById(int id);
	public Midia findById(Integer id);
}
