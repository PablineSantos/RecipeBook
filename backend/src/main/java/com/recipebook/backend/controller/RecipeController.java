package com.recipebook.backend.controller;


import com.recipebook.backend.dto.CreateRecipeRequest;
import com.recipebook.backend.dto.RecipeResponse;
import com.recipebook.backend.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/receitas")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @PostMapping
    public ResponseEntity<RecipeResponse> criarReceita(@Valid @RequestBody CreateRecipeRequest createRecipeRequest){
        RecipeResponse recipeResponse= recipeService.CriarReceita(createRecipeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeResponse);
    }

}
