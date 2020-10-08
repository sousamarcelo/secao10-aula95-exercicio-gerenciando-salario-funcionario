package entities;

public class Funcionario {
	
	private Integer id;
	private String nome;
	private double salario;
	
	public Funcionario(Integer id, String nome, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}
	
	public void aumentar(Double valor) {
		this.salario += this.salario * valor/100;
	}	

}
