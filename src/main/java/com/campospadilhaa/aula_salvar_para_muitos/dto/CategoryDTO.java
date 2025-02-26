package com.campospadilhaa.aula_salvar_para_muitos.dto;

import java.util.Objects;

import com.campospadilhaa.aula_salvar_para_muitos.entities.Category;

public class CategoryDTO {

	private Long id;
	private String name;

	public CategoryDTO() {

	}

	public CategoryDTO(Category category) {

		this.id = category.getId();
		this.name = category.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
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

		CategoryDTO other = (CategoryDTO) obj;

		return Objects.equals(id, other.id);
	}
}