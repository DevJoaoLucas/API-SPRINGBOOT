package com.joaodev.apicursos.service;

import com.joaodev.apicursos.model.Curso;
import com.joaodev.apicursos.repository.interfaces.CursoRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CursoService {
	private final CursoRepositoryInterface cursoRepository;
	
	public CursoService(CursoRepositoryInterface cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	public List<Curso> listarTodos() {
		return cursoRepository.listarTodos();
	}
	
	public Map<String, List<Curso>> listarPorCategoria() {
		List<Curso> cursos = cursoRepository.listarTodos();
		return cursos.stream().collect(Collectors.groupingBy(Curso::getCategoria));
	}
}