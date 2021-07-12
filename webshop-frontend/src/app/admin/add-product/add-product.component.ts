import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  // compile-time
  // Dependency Injection - Service-i componenti sisse süstimine
  constructor(private productService: ProductService) { }

  // itemService: ItemService;                   private ItemService itemservice;
  // constructor(_itemService: ItemService) {
//       this.itemService = _itemService;
  // }

  // run-time
  ngOnInit(): void {
  }

  onAddProduct(addProductForm: NgForm) {
    // kahe tüüpi muutujad: let ja klassimuutuja
    // let - ÜHE funktsiooni sees kasutatav muutuja

    // klassimuutuja - on deklareeritud klassi all ja on kasutatav nii HTMLs kui kõikides funktsioonides

    // let lisatavToode = {imgSrc: "www.ee", title: "Toode1", price: 1, category: "blac"};
    console.log(addProductForm);
    console.log(addProductForm.value);
    if (addProductForm.valid) {
      let newProduct = new Product(
        addProductForm.value.imgSrc,
        addProductForm.value.title,
        addProductForm.value.price,
        addProductForm.value.category );
        this.productService.products.push(newProduct);
        addProductForm.reset();
      }
  }

}
