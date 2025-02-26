package com.campospadilhaa.aula_salvar_para_muitos.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.campospadilhaa.aula_salvar_para_muitos.entities.Category;
import com.campospadilhaa.aula_salvar_para_muitos.entities.Product;

public class ProductDTO {

	private Long id;
	private String name;
	private Double price;

	private List<CategoryDTO> categories = new ArrayList<>();

	public ProductDTO() {

	}

	public ProductDTO(Long id, String name, Double price) {

		this.id = id;
		this.name = name;
		this.price = price;
	}

	public ProductDTO(Product product) {

		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();

		for (Category category : product.getCategories()) {
			this.categories.add(new CategoryDTO(category));
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		ProductDTO other = (ProductDTO) obj;

		return Objects.equals(id, other.id);
	}
}