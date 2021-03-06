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
  isLoading = false;
  error!: string;

  constructor(private route: ActivatedRoute,
    private productService: ProductService) { }

  ngOnInit(): void {
    let productId = this.route.snapshot.paramMap.get("productId");
    if (productId != null) {
      this.id = Number(productId);
      // this.productService.getOneProduct(this.id).subscribe(productFromBackend=>{
      //   this.product = productFromBackend;
      // });
      this.isLoading = true;
      this.productService.getOneProduct(this.id).subscribe(
        productFromBackend=>{
          this.product = productFromBackend;
          this.isLoading = false;
        }, 
        errorRes => { 
          console.log(errorRes)
          this.error = errorRes;
          this.isLoading = false;
        });
    }

    // setTimeout(()=>{this.isLoading=false},2000);

    // console.log(this.product);
    // console.log("SIIN KUVATAKSE HTMLs VÄÄRTUST");
  }

}
