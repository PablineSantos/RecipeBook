package com.recipebook.backend.repository;

import com.recipebook.backend.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long>  {
    List<Recipe> findAllByOrderByDataCadastroDesc();

    List<Recipe> findByNomeContainingIgnoreCaseOrderByDataCadastroDesc(String nome);

    boolean existsByNomeIgnoreCase(String nome);

}
