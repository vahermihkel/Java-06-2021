import { Component, OnInit } from '@angular/core';
import { Product } from '../models/product.model';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  productsInCart: Product[] = [];

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.productsInCart = this.cartService.productsInCart;
  }

  onProceedToCheckout() {
    this.cartService.addOrder();
    this.productsInCart = [];
    this.cartService.productsInCart = [];
    alert("THANK YOU FOR YOUR ORDER");
  }
}
