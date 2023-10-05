package com.javaCurso.curso.dao;

import java.util.List;

import com.javaCurso.curso.models.Usuario;

public interface UsuarioDAO {
	List<Usuario> getUsuarios();

	void eliminar(Long id);

	void registrar(Usuario usuario);
	
	boolean verificarCredenciales(Usuario usuario);
}
