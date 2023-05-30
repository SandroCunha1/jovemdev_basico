package br.com.trier.aula_4.diciplinas.models;
import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Teacher {
	private int id;
	@NonNull
	private String name;
	@NonNull
	private EnumEducation education;
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
