package br.com.trier.aula_3.biblioteca;

import javax.swing.JOptionPane;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Author {
    private String name;
    private EnumGender gender;
    private int age;

    public Author() {
    }

    public void cadastraAutor() {
        boolean cadastroValido = false;

        while (!cadastroValido) {
            try {
                setName(JOptionPane.showInputDialog("Nome e Sobrenome"));
                setAge(Integer.parseInt(JOptionPane.showInputDialog("Idade")));
                setGender(EnumGender.escolheGenero());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "\nErro no cadastro!");
                continue;
            }
            cadastroValido = true;
        }
    }

    public void setName(String name) throws Exception {
        this.name = name;
        String[] palavras = this.name.split(" ");
        int quantidadePalavras = palavras.length;
        if (this.name.trim().equals("") || quantidadePalavras < 2) {
            throw new Exception("Digite o nome e sobrenome!");
        }
    }

    public void setAge(int age) throws Exception {
        this.age = age;
        if (this.age <= 0) {
            throw new Exception("Idade inválida!");
        }
    }

    public void setGender(EnumGender gender) throws Exception {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "   [" + this.name + "]\n    Idade: " + this.age + "\n    Sexo: " + gender.getDescription() + "\n";
    }
}

