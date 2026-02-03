package app.backend.usuarios;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.backend.usuarios.dto.RegisterUserDTO;
import app.backend.usuarios.dto.UserRegisteredDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping(value="/usuarios")
	public ResponseEntity<List<UsuarioModel>> getAll(){
		List<UsuarioModel> usersList = usuarioService.getAll();
		return ResponseEntity.ok().body(usersList);
	}
	
	@PostMapping(value="cadastrar")
	public ResponseEntity<UserRegisteredDTO> register(@Valid @RequestBody RegisterUserDTO newUser){  
		UserRegisteredDTO userToSave = usuarioService.register(newUser);
		return ResponseEntity.ok().body(userToSave);
		
	} 
	
}
