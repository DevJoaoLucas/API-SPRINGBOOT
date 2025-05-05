package com.joaodev.apicursos.repository.interfaces;

import java.util.List;
import com.joaodev.apicursos.model.Curso;

public interface CursoRepositoryInterface {
	List<Curso> listarTodos();
	Curso obterCursoPorId(int id);
}