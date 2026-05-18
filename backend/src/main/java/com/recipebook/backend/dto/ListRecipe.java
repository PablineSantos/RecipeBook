package com.senai.pabline.recipebookbackend.dto;



import com.recipebook.backend.enums.Categoria;

import java.time.LocalDateTime;

public class ListRecipe {
    private Long id;
    private String nome;
    private Integer tempoPreparo;
    private Integer porcoes;
    private Categoria categoria;

    public ListRecipe(Long id, String nome, Integer tempoPreparo, Integer porcoes, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.tempoPreparo = tempoPreparo;
        this.porcoes = porcoes;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public Integer getPorcoes() {
        return porcoes;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
