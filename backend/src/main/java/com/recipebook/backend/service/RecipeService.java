package com.recipebook.backend.service;

import com.recipebook.backend.entity.Recipe;
import com.recipebook.backend.repository.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }


    public List<com.senai.pabline.recipebookbackend.dto.ListRecipe> listarReceitas(String nome) {
        List<Recipe> recipes;
        if (nome != null && !nome.isBlank()) {
            recipes = repository.findByNomeContainingIgnoreCaseOrderByDataCadastroDesc(nome);
        } else {
            recipes = repository.findAllByOrderByDataCadastroDesc();
            ;
        }
        return recipes.stream().map(recipe -> new com.senai.pabline.recipebookbackend.dto.ListRecipe(recipe.getId(), recipe.getNome(), recipe.getTempoPreparo(), recipe.getPorcoes(), recipe.getCategoria())).toList();
    }





}
