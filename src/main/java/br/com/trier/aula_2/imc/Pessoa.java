package br.com.trier.aula_2.imc;

import javax.swing.JOptionPane;

class Pessoa {
	private String nome;
	private char sexo;
	private double peso;
	private double altura;

	public Pessoa(String nome, char sexo, double peso, double altura) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	void cadastrar() {
		this.nome = JOptionPane.showInputDialog("Nome:");
		do {
			this.sexo = JOptionPane.showInputDialog("Sexo (M) ou (F):").toUpperCase().charAt(0);
		} while (this.sexo != 'M' && this.sexo != 'F');
		this.peso = Double.parseDouble(JOptionPane.showInputDialog("Peso (em kg):"));
		this.altura = Double.parseDouble(JOptionPane.showInputDialog("Altura (em metros):"));
	}

	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
	public double getIMC() {
		return this.peso / Math.pow(this.altura, 2);
	}
	
	public String getAvaliacaoIMC() {
		double imc = this.getIMC();
		if(sexo == 'F') {
			if (imc < 19.1) {
				return "Abaixo do peso";
			} else if (imc <= 25.8) {
				return "Peso ideal";
			} else if (imc <= 27.3) {
				return "Pouco acima do peso";
			} else if (imc <= 32.3) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}
			
		} else {
			if (imc < 20.7) {
				return "Abaixo do peso";
			} else if (imc <= 26.4) {
				return "Peso ideal";
			} else if (imc <= 27.8) {
				return "Pouco acima do peso";
			} else if (imc <= 31.1) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}
		}
	}

	@Override
	public String toString() {
		return String.format("Pessoa [nome= %s, sexo= %s, IMC= %.2f, Avaliação= %s ]", nome, sexo, getIMC(), getAvaliacaoIMC() );
	}
	
	
}
