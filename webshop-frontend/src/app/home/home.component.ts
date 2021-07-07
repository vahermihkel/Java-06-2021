import { Component, OnInit } from '@angular/core';
import { Product } from '../models/product.model';
import { ProductService } from '../services/product.service';
// relatiivne teekond - alustan siit kohast ja liigun mööda kaustu alates siit
// absoluutne teekond - alustan src-st ehk rootist ja liigun mööda kaustu alates sealt

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
  // , interface segregation princible
  // solid: 5 printsiipi
  // providers: [
  //   { provide: ProductService, useClass: ProductMockService }
  // ]
})
export class HomeComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.products = this.productService.products;
    // vasakul pool on tühi massiiv
    // paremal pool on service sees asuv pikk massiiivirodu [{},{}]
    // onInit läheb käima sel hetkel kui kasutaja vajutab et tuleb siia componendi sisse
    // sel hetkel võetakse kõik tooted Service seest ja pannakse tühja massiivi asemele
    console.log("TULIN HOME COMPONENTI");
  }

  // addProduct() {
  //   let lisatavToode = {imgSrc: "www.ee", title: "Toode1", price: 1, category: "blac"};
  //   this.products.push(lisatavToode);
  // }
}
