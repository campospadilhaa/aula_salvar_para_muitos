package com.campospadilhaa.aula_salvar_para_muitos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campospadilhaa.aula_salvar_para_muitos.dto.CategoryDTO;
import com.campospadilhaa.aula_salvar_para_muitos.dto.ProductDTO;
import com.campospadilhaa.aula_salvar_para_muitos.entities.Category;
import com.campospadilhaa.aula_salvar_para_muitos.entities.Product;
import com.campospadilhaa.aula_salvar_para_muitos.repositories.CategoryRepository;
import com.campospadilhaa.aula_salvar_para_muitos.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public ProductDTO insert(ProductDTO productDTO) {

		Product product = new Product();

		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());

		for (CategoryDTO categoryDTO : productDTO.getCategories()) {

			/*
			Category category = new Category();
			category.setId(categoryDTO.getId());*/

			Category category = categoryRepository.getReferenceById(categoryDTO.getId());

			product.getCategories().add(category);
		}

		productRepository.save(product);

		return new ProductDTO(product);
	}
}