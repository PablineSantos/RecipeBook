package com.recipebook.backend.service;

import com.recipebook.backend.dto.CreateRecipeRequest;
import com.recipebook.backend.dto.RecipeResponse;
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


    public RecipeResponse CriarReceita(CreateRecipeRequest request) {
        Recipe recipe = new Recipe();
        boolean exiteNome = repository.existsByNomeIgnoreCase(request.getNome());

        if (exiteNome == true) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nome já existe");
        }

        recipe.setNome(request.getNome());
        recipe.setPorcoes(request.getPorcoes());
        recipe.setCategoria(request.getCategoria());
        recipe.setIngredientes(request.getIngredientes());
        recipe.setDataCadastro(LocalDateTime.now());
        recipe.setModoPreparo(request.getModoPreparo());
        recipe.setTempoPreparo(request.getTempoPreparo());

        repository.save(recipe);
        return new RecipeResponse(recipe.getId(), recipe.getCategoria(),recipe.getDataCadastro(),recipe.getModoPreparo(),recipe.getIngredientes(),recipe.getPorcoes(),recipe.getTempoPreparo(),recipe.getNome());

    }

}
