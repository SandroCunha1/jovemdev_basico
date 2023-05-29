package br.com.trier.aula_4.diciplinas.models;
import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Teacher {
	private int id;
	@NonNull
	private String name;
	@NonNull
	private EnumEducation education;
	
	
}
