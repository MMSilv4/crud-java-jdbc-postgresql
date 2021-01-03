package Beans;

public class Pessoa {
	
	private int cpf;
	private String nome;
	private String sobrenome;
	private String email;
	private String senioridade;
	private String tecnologia;
	private String experiencia;
	
	public Pessoa() {
		
	}
	
	public Pessoa(Integer cpf, String nome, String sobrenome, String email, 
			String senioridade, String tecnologia, String experiencia) {
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senioridade = senioridade;
		this.tecnologia = tecnologia;
		this.experiencia = experiencia;		
	}
	
	

	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenioridade() {
		return senioridade;
	}

	public void setSenioridade(String senioridade) {
		this.senioridade = senioridade;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	
	@Override
	public String toString() {
		return "Pessoa{cpf=" + cpf + "nome=" + nome + "sobrenome=" +sobrenome+ 
				"email=" +email+ " senioridade=" +senioridade+ "tecnologia=" 
				+tecnologia+ "experiencia=" +experiencia+  "}";
		
	}

}
