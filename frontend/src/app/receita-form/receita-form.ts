import { Component } from '@angular/core';

@Component({
  selector: 'app-receita-form',
  imports: [],
  templateUrl: './receita-form.html',
  styleUrl: './receita-form.css',
})
// Localizado em: src/app/pages/receita-form/receita-form.ts

export class ReceitaForm {
  receita: Recipe = {
    id: 0,
    nome: '',
    categoria: '',
    tempoPreparo: 1,
    porcoes: 1,
    ingredientes: [],
    modoPreparo: '',
    dataCadastro: new Date()
  };

  ingredientesTexto: string = '';
  categoriasAtuais = ['DOCE', 'SALGADO', 'BEBIDA', 'SOBREMESA'];
  salvando: boolean = false;

  constructor(
    private receitaService: RecipeService,
    private router: Router,
    private messageService: MessageService
  ) {}

  salvar() {
    this.salvando = true;

    this.receita.ingredientes = this.ingredientesTexto
      .split(',')
      .map(ingrediente => ingrediente.trim())
      .filter(ingrediente => ingrediente.length > 0);

    this.receitaService.cadastrarReceita(this.receita).subscribe({
      next: (resposta) -> {
        this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Receita cadastrada com sucesso!' });
        setTimeout(() => this.router.navigate(['/receitas']), 1000);
      },
      error: (erro) -> {
        this.salvando = false;
      }
    });
  }
}
