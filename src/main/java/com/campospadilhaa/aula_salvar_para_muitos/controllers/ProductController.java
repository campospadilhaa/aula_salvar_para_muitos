package com.campospadilhaa.aula_salvar_para_muitos.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.campospadilhaa.aula_salvar_para_muitos.dto.ProductDTO;
import com.campospadilhaa.aula_salvar_para_muitos.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO productDTO) { // anotation '@Valid' considera as validações definidas no DTO

		productDTO = productService.insert(productDTO);

		// a criação de uma URI faz com que no header do response conste a URL para a busca do Product
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productDTO.getId()).toUri();

		// ResponseEntity com 'created' retorna o status 201 (created)
		return ResponseEntity.created(uri).body(productDTO);
	}
}