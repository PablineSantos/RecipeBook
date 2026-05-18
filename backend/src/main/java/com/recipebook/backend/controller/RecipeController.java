package com.recipebook.backend.controller;


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

    @GetMapping
    public ResponseEntity<List<com.senai.pabline.recipebookbackend.dto.ListRecipe>> listarReceitas(@RequestParam(required = false) String nome){
        List<com.senai.pabline.recipebookbackend.dto.ListRecipe> recipes= recipeService.listarReceitas(nome);
        return ResponseEntity.status(HttpStatus.OK).body(recipes);
    }

}
