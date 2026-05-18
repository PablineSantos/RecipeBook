package com.recipebook.backend.dto;


import com.recipebook.backend.enums.Categoria;

import java.time.LocalDateTime;
import java.util.List;

public class RecipeResponse {
    private Long id;
    private String nome;
    private Integer tempoPreparo;
    private Integer porcoes;
    private List<String> ingredientes;
    private String modoPreparo;
    private LocalDateTime dataCadastro;
    private Categoria categoria;


    public RecipeResponse(Long id, Categoria categoria, LocalDateTime dataCadastro, String modoPreparo, List<String> ingredientes, Integer porcoes, Integer tempoPreparo, String nome) {
        this.id = id;
        this.categoria = categoria;
        this.dataCadastro = dataCadastro;
        this.modoPreparo = modoPreparo;
        this.ingredientes = ingredientes;
        this.porcoes = porcoes;
        this.tempoPreparo = tempoPreparo;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public Categoria getCategoria() { return categoria; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public String getModoPreparo() { return modoPreparo; }
    public List<String> getIngredientes() { return ingredientes; }
    public Integer getPorcoes() { return porcoes; }
    public Integer getTempoPreparo() { return tempoPreparo; }
    public String getNome() { return nome; }
    }