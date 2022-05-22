package com.prueba.core.controllers;


import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.prueba.core.configuration.Paginas;
import com.prueba.core.models.Post;
import com.prueba.core.models.UsuarioC;
import com.prueba.core.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerBasic {
	
	@GetMapping(path="/home")
	public String saludar() {
		return Paginas.HOME;
	}
	
	@GetMapping(path={"/salas","/"})
	public String salas() {
		return Paginas.SALAS;
	}
	
	
	   @Autowired
	     private UsuarioService usuarioservice;

		//mostrando la lista de los usuarios
	     
		@GetMapping("/colaboradores")
		public String verlista(Model model) {
			
			List<UsuarioC> listausu =  usuarioservice.buscarporrol(4);
			
			model.addAttribute("listaUsuarios",listausu);
			
			return "colaboradores";
		}
		
		@GetMapping("/muestranuevoColaborador")
		
		public String muestranuevoColaborador(Model model) {
			UsuarioC usuarioC = new UsuarioC();
			model.addAttribute("usuario",usuarioC);
			//usamos este modelo para bindear la informacion del form
		
			return "nuevo_usuario";
		}
		
		@PostMapping("/guardarUsuario")
		public String guardarUsuario(@ModelAttribute("usuario") UsuarioC usuarioC){
			//guardar el empleado ala base de datos
			usuarioservice.guardarUsuario(usuarioC);
			return "redirect:/";
		
		}
		
		
//	@GetMapping(path={"/colaboradores","/"})
//	public String colaboradores() {
//		return Paginas.COLABORADORES;
//	}
	
//	public List<Post> getPosts(){
//		ArrayList<Post> post = new ArrayList<>();
//		post.add(new Post(1,"kkkkkkkkkk","http://localhost:8080/img/post.jpg","Chile"));
//		post.add(new Post(2,"eeeeeee","http://localhost:8080/img/post.jpg","Chiles"));
//		return post;
//	}
//	
// NO USABLE POR AHORA-------------------------------------------------------------	
//	@GetMapping(path ={"/post","/"})
//	public String saludar(Model model) {
//		model.addAttribute("posts",this.getPosts());
//		return "index2";
//	}
// NO USABLE POR AHORA-------------------------------------------------------------	
	
	
	
//	@GetMapping(path="/index2")
//	public ModelAndView post() {
//		ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
//		modelAndView.addObject("posts",this.getPosts());
//		return modelAndView;
//		
//	}
// NO USABLE POR AHORA-------------------------------------------------------------	
	
	
	
//	@GetMapping(path={})
//	public ModelAndView getPostIndividual(
//			@RequestParam(defaultValue ="1", name="id", required= false)
//			int id) {
//		ModelAndView modelandview= new ModelAndView(Paginas.POST);
//		List<Post> postFiltrado = this.getPosts().stream().filter((p)-> { 
//			return p.getId() ==id;}).collect(Collectors.toList());
//		modelandview.addObject("post",postFiltrado.get(0));
//				return modelandview;
//		
// NO USABLE POR AHORA-------------------------------------------------------------	
		
//	}
//ESTE SI
	
	
	
	
}
