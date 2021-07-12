import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  error = "";

  constructor(private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
  }

  onSignup(signupForm: NgForm) {
    let signupValues = signupForm.value;
    if (signupValues.password == signupValues.confirm) {
      this.authService.signup(signupValues.username, signupValues.password).subscribe(()=>{
        this.router.navigateByUrl("/");
        console.log("SIIA JÕUAN HILJEM");
      });
      console.log("SIIA JÕUAN ENNE");
    } else {
      this.error = "Passwords do not match!";
    }
  }
}
