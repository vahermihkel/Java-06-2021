import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  id!: number;
  product!: Product;

  constructor(private route: ActivatedRoute,
    private productService: ProductService) { }

  ngOnInit(): void {
    let productId = this.route.snapshot.paramMap.get("productId");
    if (productId != null) {
      this.id = Number(productId);
      this.product = this.productService.products[this.id];
    }
  }

}
