package com.joaodev.apicursos.repository;

import com.joaodev.apicursos.model.Curso;
import com.joaodev.apicursos.repository.interfaces.CursoRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CursoRepository implements CursoRepositoryInterface {
	
	public List<Curso> listarTodos() {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso(1, "Java Básico", "Programação"));
        cursos.add(new Curso(2, "Spring Boot", "Back-End"));
        cursos.add(new Curso(3, "Banco de Dados", "Dados"));
        cursos.add(new Curso(4, "Python Básico", "Programação"));
        return cursos;
	}
	
	public Map<String, List<Curso>> listarCursosPorCategoria() {
		List<Curso> cursos = listarTodos();
		Map<String, List<Curso>> cursosPorCategoria = new HashMap<>();
		
		for (Curso curso : cursos) {
			cursosPorCategoria
				.computeIfAbsent(curso.getCategoria(), k -> new ArrayList<>())
				.add(curso);
		}
		return cursosPorCategoria;
	}
	
	@Override
	public Curso obterCursoPorId(int id) {
	    List<Curso> cursos = listarTodos();
	    for (Curso curso : cursos) {
	        if (curso.getId() == id) { 
	            return curso;
	        }
	    }
	    return null;
	}
}