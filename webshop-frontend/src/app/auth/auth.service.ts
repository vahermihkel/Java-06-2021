import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url = "";

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    return this.http.post(this.url + "login", {username: username, password: password});
  }

  signup(username: string, password: string) {
    return this.http.post(this.url + "signup", {username: username, password: password});
  }
}
