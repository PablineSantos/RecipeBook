package com.recipebook.backend.config;


import com.recipebook.backend.entity.Recipe;
import com.recipebook.backend.enums.Categoria;
import com.recipebook.backend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;

    public DataLoader(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (recipeRepository.count() == 0) {

            Recipe r1 = new Recipe();
            r1.setNome("Bolo de Chocolate Simples");
            r1.setCategoria(Categoria.DOCE);
            r1.setTempoPreparo(40);
            r1.setPorcoes(8);
            r1.setIngredientes(List.of("3 ovos", "2 xícaras de farinha", "1 xícara de açúcar", "1 xícara de achocolatado", "1 colher de fermento"));
            r1.setModoPreparo("Misture os ingredientes secos, adicione os ovos e líquidos. Bata tudo até ficar homogêneo e asse por 40 minutos.");
            r1.setDataCadastro(LocalDateTime.now());

            Recipe r2 = new Recipe();
            r2.setNome("Coxinha de Frango");
            r2.setCategoria(Categoria.SALGADO);
            r2.setTempoPreparo(60);
            r2.setPorcoes(15);
            r2.setIngredientes(List.of("500g de peito de frango", "1 litro de caldo de frango", "500g de farinha de trigo", "1 cebola", "2 dentes de alho"));
            r2.setModoPreparo("Cozinhe o frango e desfie. Use o caldo para fazer a massa com a farinha até soltar da panela. Modele as coxinhas com o recheio e frite.");
            r2.setDataCadastro(LocalDateTime.now());

            Recipe r3 = new Recipe();
            r3.setNome("Suco de Maracujá Cremoso");
            r3.setCategoria(Categoria.BEBIDA);
            r3.setTempoPreparo(10);
            r3.setPorcoes(4);
            r3.setIngredientes(List.of("2 maracujás azedos", "1 lata de leite condensado", "1 litro de água filtrada", "Gelo a gosto"));
            r3.setModoPreparo("Bata a polpa do maracujá com a água rapidamente no liquidificador e coe. Volte o suco para o liquidificador, adicione o leite condensado e o gelo, e bata até ficar cremoso.");
            r3.setDataCadastro(LocalDateTime.now());

            recipeRepository.saveAll(List.of(r1, r2, r3));

            System.out.println("Backend: Carga inicial de 3 receitas realizada com sucesso!");
        }
    }
}