package net.docket.project.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.docket.project.entity.Cartorio;
import net.docket.project.entity.Certidao;
import net.docket.project.model.CartorioForm;
import net.docket.project.repository.CartorioRepository;
import net.docket.project.repository.CertidaoRepository;

@Controller
@RequestMapping("cartorios")
public class CartorioController {
	
	//autowire cartorio repository
	@Autowired
	private CartorioRepository cartorioRepository;

	@Autowired
	private CertidaoRepository certidaoRepository;
	
	@GetMapping("/showForm")
	public String getAddCartorio() {
		return "add-cartorio";
	}
	
	@PostMapping("/add")
	public String submitCartorio(@Valid CartorioForm cartorioForm, BindingResult result) {
		if(result.hasErrors()) {
			return "add-cartorio";
		}
		Cartorio cartorio = cartorioForm.toCartorio();
		cartorioRepository.save(cartorio);	
		
		Certidao nascimentoCertidao = cartorioForm.toNascimentoCertidao(cartorio);
		Certidao casamentoCertidao = cartorioForm.toCasamentoCertidao(cartorio);
		Certidao obitoCertidao = cartorioForm.toObitoCertidao(cartorio);
		
		if(nascimentoCertidao != null)
			certidaoRepository.save(nascimentoCertidao);
		if(casamentoCertidao != null)
			certidaoRepository.save(casamentoCertidao);
		if(obitoCertidao != null)
			certidaoRepository.save(obitoCertidao);
		
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String cartorios(Model model) {
		model.addAttribute("cartorios", this.cartorioRepository.findAll());
		model.addAttribute("certidoes", this.certidaoRepository.findAll());
		return "list";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Cartorio cartorio = this.cartorioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cartório Inválido id:" + id));
		
		model.addAttribute("cartorio", cartorio);
		return "update-cartorio";		
	}
	
	@PostMapping("update/{id}")
	public String updateCartorio(@PathVariable("id") long id, @Valid Cartorio cartorio, BindingResult result, Model model) {
		if(result.hasErrors()) {
			cartorio.setId(id);
			return "update-cartorio";
		}
		
		// update cartorio
		cartorioRepository.save(cartorio);
		
		//get all cartorios(com o update)
		model.addAttribute("cartorios", this.cartorioRepository.findAll());
		return "list";
	}
	
	@GetMapping("delete/{id}")
	public String deleteCartorio(@PathVariable("id") long id, Model model) {
		Cartorio cartorio = this.cartorioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cartório Inválido id:" + id));
		
		this.cartorioRepository.delete(cartorio);

		model.addAttribute("cartorios", this.cartorioRepository.findAll());
		return "list"; 
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/index";
	}
	
}
