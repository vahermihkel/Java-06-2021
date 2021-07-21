import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';
import { catchError, retry, timeout } from 'rxjs/operators'
import { Observable } from 'rxjs';
import { throwError } from 'rxjs/internal/observable/throwError'

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  
  private url = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  addProduct(product: Product) {
    return this.http.post(this.url + "add-item", product);
  }

  getProducts() {
    return this.http.get<Product[]>(this.url + "items");
  }

  getOneProduct(id: number) {
    // päringu tagastus backist - pipe paneb külge, modifitseerib ja lubab ikka minna võtma
    return this.http.get<Product>(this.url + "item/" + id+1).pipe(
      timeout(3000),
      retry(1),
      catchError(this.handleError)
    );
  }

  deleteProduct(id: number) {
    return this.http.delete(this.url + "delete-item/" + id);
  }

  editProduct(id: number, product: Product) {
    return this.http.post(this.url + "edit-item/" + id, product)
  }

  // this.productService.products[this.id] = new Product(form.value, .......);

  handleError(err: any) {
    console.log(err);
    let errorMessage = "Tundmatu viga!";
    if (err.error) {
      errorMessage = err.error.message;
    }
    return throwError(errorMessage);
  }

}
