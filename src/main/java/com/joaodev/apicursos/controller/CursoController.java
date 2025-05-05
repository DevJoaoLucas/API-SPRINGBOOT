package com.joaodev.apicursos.controller;

import com.joaodev.apicursos.model.Curso;
import com.joaodev.apicursos.exception.ResourceNotFoundException;
import com.joaodev.apicursos.service.CursoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Tag(name = "Endpoints disponíveis", description = "Aqui estão listados os endpoints da API de cursos")
@RestController
@RequestMapping("/cursos")

public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	@GetMapping
	public List<Curso> listarCursos() {
	    List<Curso> cursos = cursoService.listarTodos();

	    if (cursos.isEmpty()) {
	        throw new ResourceNotFoundException("Nenhum curso encontrado.");
	    }

	    return cursos;
	}
	
	@GetMapping("/por-categoria")
	public Map<String, List<Curso>> listarPorCategoria() {
		return cursoService.listarPorCategoria();
	}
}
