package lojaDeGames.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lojaDeGames.model.Usuario;

@Repository
public interface UsuarioRepository {

	public Optional<Usuario> findByUsuario(String usuario);
	//select * from tb_usuarios where ususario = "usuario";

	public List<Usuario> findAllByNomeContainingIgnoreCase(String string);
}
