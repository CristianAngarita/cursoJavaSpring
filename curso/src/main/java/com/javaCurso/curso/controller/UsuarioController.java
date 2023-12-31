package com.javaCurso.curso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaCurso.curso.dao.UsuarioDAO;
import com.javaCurso.curso.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@RequestMapping(value = "api/usuarios/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre("Isai");
		usuario.setApellido("Angar");
		usuario.setEmail("asai@hotmail.com");
		usuario.setTelefono("14512131");
		usuario.setPassword("123456");
		return usuario;
	}
	
	@RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
	public List <Usuario> getUsuario2() {
		return usuarioDao.getUsuarios();
	}
	
	@RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
	public void registrarUsuario(@RequestBody Usuario usuario) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash= argon2.hash(1, 1024, 1, usuario.getPassword());
		usuario.setPassword(hash);
		usuarioDao.registrar(usuario);
	}
	
	@RequestMapping(value = "usuarioadf")
	public Usuario editar() {
		Usuario usuario = new Usuario();
		usuario.setNombre("Isai");
		usuario.setApellido("Angar");
		usuario.setEmail("asai@hotmail.com");
		usuario.setTelefono("14512131");
		usuario.setPassword("123456");
		return usuario;
	}
	
	@RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		usuarioDao.eliminar(id);
	}
	
	@RequestMapping(value = "usuarioaaaaaa")
	public Usuario buscar() {
		Usuario usuario = new Usuario();
		usuario.setNombre("Isai");
		usuario.setApellido("Angar");
		usuario.setEmail("asai@hotmail.com");
		usuario.setTelefono("14512131");
		usuario.setPassword("123456");
		return usuario;
	}
}
