package app.backend.usuarios;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<UsuarioModel> getAll() {
		return usuarioRepository.findAll();
	}
	
}
