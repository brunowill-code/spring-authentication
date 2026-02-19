package app.backend.usuarios;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.backend.exceptions.UserAlreadyExists;
import app.backend.usuarios.dto.RegisterUserDTO;
import app.backend.usuarios.dto.UserRegisteredDTO;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder ) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public List<UsuarioModel> getAll() {
		System.out.println("usuarios" + usuarioRepository.findAll());
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
		userToSave.setSenha(passwordEncoder.encode(newUser.getSenha()));
		
		usuarioRepository.save(userToSave);
		
		return new UserRegisteredDTO(userToSave.getNome(),userToSave.getEmail());
		
	}
	
}
