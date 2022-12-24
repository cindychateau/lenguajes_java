package com.codingdojo.cynthia.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.cynthia.modelos.Lenguaje;
import com.codingdojo.cynthia.servicios.AppService;

@Controller
public class ControladorLenguajes {
	
	@Autowired
	private AppService servicio;
	
	@GetMapping("/languages")
	public String index(Model model,
						@ModelAttribute("nuevoLenguaje") Lenguaje lenguaje) {
		
		List <Lenguaje> lenguajes = servicio.todos_lenguajes();
		model.addAttribute("lenguajes", lenguajes);
		
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("nuevoLenguaje") Lenguaje lenguaje,
						 BindingResult result) {
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			servicio.nuevo_lenguaje(lenguaje);
			return "redirect:/languages";
		}
		
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id,
					   @ModelAttribute("lenguaje") Lenguaje lenguaje,
					   Model model) {
		Lenguaje lenguaje_edit = servicio.buscar_lenguaje(id);
		model.addAttribute("lenguaje", lenguaje_edit);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String update(@PathVariable("id") Long id,
					     @Valid @ModelAttribute("lenguaje") Lenguaje lenguaje,
					     BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			servicio.editar_lenguaje(lenguaje);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/{id}")
	public String eliminarUsuario( @PathVariable("id") Long id ) {
		servicio.borrar_lenguaje(id);
		return "redirect:/languages";
	}
	
}
