import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';
// relatiivne teekond - alustan siit kohast ja liigun mööda kaustu alates siit
// absoluutne teekond - alustan src-st ehk rootist ja liigun mööda kaustu alates sealt

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {
  products: Product[] = [];

  // läheb kompileerimisel
  constructor(private productService: ProductService) { }

  // läheb käima koguaeg kui kasutaja componenti tuleb
  ngOnInit(): void {
    this.products = this.productService.products;
  }

  onDeleteProduct() {
      console.log("KUSTUTAN TOOTE");
  }

  onEditProduct() {
    console.log("MUUDAN TOODET");
  }
}
