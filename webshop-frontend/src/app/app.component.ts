import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webshop-frontend';
// 3 toodet:
// Nimetustega: Toode1, Toode2, Toode
// Hindadega: 10,12,17

  toode1Name = "Toode1";
  toode2Name = "Toode2";

  toodeNames = ["Toode1", "Toode2", "Toode3"];
  toodePrices = [10,12,17];

  toode1Object = {name: "Toode1", price: 10};
  toode2Object = {name: "Toode2", price: 12};

  tooted = [
    {name: "Toode1", price: 10}, 
    {name: "Toode2", price: 12},
    {name: "Toode3", price: 17}
  ]
}
