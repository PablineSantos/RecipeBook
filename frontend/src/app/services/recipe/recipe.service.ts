import { Component } from '@angular/core';

@Component({
  selector: 'app-recipe.service',
  imports: [],
  templateUrl: './recipe.service.html',
  styleUrl: './recipe.service.css',
})

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/receitas';

  listarReceitas(nomeBusca?: string): Observable<Recipe[]> {
    let parametros = new HttpParams();

    if (nomeBusca) {
      parametros = parametros.set('nome', nomeBusca);
    }

    return this.http.get<Recipe[]>(this.apiUrl, { params: parametros });
  }

}
