package app.backend.usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterUserDTO {
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
	private String nome;
	
	@NotBlank(message = "Email é obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@NotBlank(message = "Senha é obrigatória")
	@Size(min = 3, max = 50, message = "A senha deve ter entre 3 e 50 caracteres")
	private String senha;
	
	public RegisterUserDTO() {
	}

	public RegisterUserDTO(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
