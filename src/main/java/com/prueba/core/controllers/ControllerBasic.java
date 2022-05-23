package com.prueba.core.controllers;




import java.util.List;


import com.prueba.core.configuration.Paginas;
import com.prueba.core.models.Turno;
import com.prueba.core.models.UsuarioC;
import com.prueba.core.repository.UsuarioRepository;
import com.prueba.core.services.TurnoService;
import com.prueba.core.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



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
			 System.out.println("&//////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			 
			
			usuarioservice.guardarUsuario(usuarioC);
			System.out.println(usuarioC);
			 System.out.println(usuarioC.getRut());
			return "redirect:/";
		
		}
		
		@GetMapping("/muestraFormUpdate/{id}")
		public String muestraFormUpdate(@PathVariable(value ="id") long id, Model model) {
			// obtener usuarios desde el servicio
			UsuarioC usuarioC= usuarioservice.obtenerUsuaruioPorID(id);
			//ponemos al usuario como un atributo modelo para rellenar el formulario
			model.addAttribute("usuario",usuarioC);
			return "actualizar_usuario";
			
					}
		@GetMapping("/eliminarUsuarios/{id}")
		public String eliminarUsuarios(@PathVariable(value ="id") long id) {
			// llamamos el metodo de eliminar colaboradores/usuarios 
			this.usuarioservice.eliminarUsuariosPorId(id);
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
