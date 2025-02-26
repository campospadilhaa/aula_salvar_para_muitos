package com.campospadilhaa.aula_salvar_para_muitos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campospadilhaa.aula_salvar_para_muitos.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
