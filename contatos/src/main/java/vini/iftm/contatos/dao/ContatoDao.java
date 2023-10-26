package vini.iftm.contatos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import vini.iftm.contatos.domain.*;

@Component
public class ContatoDao {

    @Autowired
    JdbcTemplate db;

    public List<Contato> getContatos() {
		String sql = "select nome,email,senha,numero from tb_contato";

		return db.query(sql, (res, rowNum) -> {
			return new Contato(
					res.getString("nome"),
					res.getString("email"),
					res.getString("senha"),
					res.getString("numero")
			);
		});
	}

	public List<Contato> getContatos(String nome) {
		String sql = "select nome,email,senha,numero from tb_contato where lower(nome) like ?";

		return db.query(sql,
		                new BeanPropertyRowMapper<>(Contato.class),
						new Object[]{"%"+nome+"%"});
	}

	public Contato getContato(String email) {
		String sql = "select nome,email,senha,numero from tb_contato where email = ?";

		List<Contato> contatos=  db.query(sql,
		                new BeanPropertyRowMapper<>(Contato.class),
						new Object[]{email});
		if (contatos != null && contatos.size() > 0) {
			return contatos.get(0);
		} else {
			return null;
		}
	}

	public void inserirContato(Contato contato) {
		String sql = "insert into tb_contato(nome,email,senha,numero) values(?,?,?,?)";

		db.update(sql,new Object[]{contato.getNome(),contato.getEmail(),contato.getSenha(), contato.getNumero()});
	}

	public void updateContato(Contato contato) {
		String sql = "update tb_contato set nome = ?, senha = ?, numero = ? where email = ?";
	
		db.update(sql,new Object[]{contato.getNome(), contato.getSenha(), contato.getNumero(), contato.getEmail()});
	}

	public void deleteContato(String email) {
		String sql = "delete from tb_contato where email = ?";

		db.update(sql,new Object[]{email});
	}

	
	


}