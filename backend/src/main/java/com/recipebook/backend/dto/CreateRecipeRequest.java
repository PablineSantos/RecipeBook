package com.recipebook.backend.dto;

import com.recipebook.backend.enums.Categoria;
import jakarta.validation.constraints.*;

import java.util.List;


public class CreateRecipeRequest {

    @Size(min = 3,message = "O nome da Receita deve ter no mínimo 3 caracteres ")
    private String nome;

    @Min(value = 1, message = "Tempo de preparo tem que ser de mínimo  1 minuto")
    private Integer tempoPreparo;

    @Min(value = 1 , message = "O número de porções tem que ser de mínimo 1")
    private Integer porcoes;

    @NotEmpty(message = "A lista de ingredientes não deve ser vazia")
    private List<String> ingredientes;

    @NotBlank(message = "O modo de preparo não deve estar vazio")
    private String modoPreparo;

    @NotNull(message = "Escolha uma Categoria")
    private Categoria categoria;

    public String getNome() {
        return nome;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public Integer getPorcoes() {
        return porcoes;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
