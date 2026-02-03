package app.backend.usuarios;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.backend.exceptions.UserAlreadyExists;
import app.backend.usuarios.dto.RegisterUserDTO;
import app.backend.usuarios.dto.UserRegisteredDTO;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<UsuarioModel> getAll() {
		return usuarioRepository.findAll();
	}

	public UserRegisteredDTO register(@Valid RegisterUserDTO newUser) {
		UsuarioModel usuarioExistente = usuarioRepository.findByEmail(newUser.getEmail());
		
		if(usuarioExistente != null) {
			throw new UserAlreadyExists();
		} 
		
		UsuarioModel userToSave = new UsuarioModel();
		userToSave.setNome(newUser.getNome());
		userToSave.setEmail(newUser.getEmail());
		userToSave.setSenha(newUser.getSenha());
		
		usuarioRepository.save(userToSave);
		
		return new UserRegisteredDTO(userToSave.getNome(),userToSave.getEmail());
		
	}
	
}
