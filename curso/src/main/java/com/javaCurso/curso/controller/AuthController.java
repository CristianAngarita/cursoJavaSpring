package com.javaCurso.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaCurso.curso.dao.UsuarioDAO;
import com.javaCurso.curso.models.Usuario;

@RestController
public class AuthController {
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@RequestMapping(value = "api/login", method = RequestMethod.POST)
	public String login(@RequestBody Usuario usuario) {
		if(usuarioDao.verificarCredenciales(usuario)) {
			return "ok";
		}else
			return "FAIL";
	}
}
