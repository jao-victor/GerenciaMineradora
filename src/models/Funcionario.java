package models;

public abstract class Funcionario {

	private String nome;
	private String cpf;
	private String cargo;
	protected double salario;
	private String horarioSaida;
	private String horarioEntrada;
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public abstract void setSalario(double salario);
	
	
	
	
}
