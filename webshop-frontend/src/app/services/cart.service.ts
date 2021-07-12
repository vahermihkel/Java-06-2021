import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  productsInCart: Product[] = [];
  url = "";

  constructor(private http: HttpClient) { }

  addOrder() {
    return this.http.post(this.url, this.productsInCart);
  }
}
