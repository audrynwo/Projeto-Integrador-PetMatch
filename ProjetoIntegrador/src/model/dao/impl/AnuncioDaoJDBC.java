package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import model.dao.AnuncioDao;
import model.entities.Anuncios;

public class AnuncioDaoJDBC implements AnuncioDao {

	private Connection conn;

	public AnuncioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Anuncios obj) {
	/*	PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO anuncio " 
							+ "(nome_do_animal, descricao, data_anuncio, idade, especie, raca, genero, porte, status_vacinanao, status_castracao, status_vermifugo, status_adocao, id_usuario, id_endereco) "
							+ "VALUES " 
							+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)",
							Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNomeDoAnimal());
			st.setString(2, obj.getDescricao());
			//st.setDate(3, obj.);
			st.setInt(4, obj.getIdade());
			st.setString(5, obj.getEspecie());
			st.setString(6, obj.getRaca());
			st.setString(7, obj.getGenero());
			st.setString(8, obj.getDescricao());
			st.setString(9, obj.getPorte());
			st.setBoolean(10, obj.isStatusVacinacao());
			st.setBoolean(11, obj.isStatusCastracao());
			st.setBoolean(12, obj.isStatusVermifugo());
			st.setBoolean(13, obj.isStatusAdocao());
			st.setString(14, obj.getDescricao());
		} */
	}

	@Override
	public void update(Anuncios obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Anuncios> findByEspecie(String especie) {
		// TODO Auto-generated method stub
		return null;
	} 


}
