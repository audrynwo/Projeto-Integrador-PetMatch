package model.dao;

import model.entities.Usuario;

public interface UsuarioDao {
	void insert(Usuario obj);
	void update(Usuario obj);
	void delete(Usuario obj);
}
