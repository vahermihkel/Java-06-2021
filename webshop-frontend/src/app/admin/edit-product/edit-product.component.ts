import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
  id!: number;
  product!: Product;
  editProductForm!: FormGroup;

  constructor(private route: ActivatedRoute,
    private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
    let productId = this.route.snapshot.paramMap.get("productId");
    if (productId != null) {
      this.id = Number(productId);
      // this.product = this.productService.products[this.id]; // this.productService.getOneProduct(id);
      this.productService.getOneProduct(this.id).subscribe(productFromBackend=>{
        this.product = productFromBackend;
        this.editProductForm = new FormGroup({
          id: new FormControl(this.product.id),
          imgSrc: new FormControl(this.product.imgSrc),
          title: new FormControl(this.product.title),
          price: new FormControl(this.product.price),
          category: new FormControl(this.product.category)
        })
      })
    }
  }

  onEditProduct() {
    let newProduct = new Product(
      this.editProductForm.value.imgSrc,
      this.editProductForm.value.title,
      this.editProductForm.value.price,
      this.editProductForm.value.category,
      this.editProductForm.value.id
    );
    // this.productService.products[this.id] = newProduct; // this.productService.editProduct(id, newProduct); ( this.products[id] = newProduct )
    this.productService.editProduct(this.id, newProduct).subscribe(()=>{
      this.router.navigateByUrl("/admin/view-products");
    });
  }

}
