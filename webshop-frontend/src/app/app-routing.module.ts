import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './admin/add-product/add-product.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { EditProductComponent } from './admin/edit-product/edit-product.component';
import { ViewProductsComponent } from './admin/view-products/view-products.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { ViewComponent } from './home/view/view.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "cart", component: CartComponent },
  { path: "login", component: LoginComponent },
  { path: "signup", component: SignupComponent },
  { path: "view/:productId", component: ViewComponent },
  { path: "admin", component: AdminHomeComponent },
  { path: "admin/add-product", component: AddProductComponent },
  { path: "admin/edit-product/:productId", component: EditProductComponent },
  { path: "admin/view-products", component: ViewProductsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
