import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() {}

  public setRoles(roles:[]){
    sessionStorage.setItem('roles',JSON.stringify(roles));
  }

  public getRoles(): []{
    return JSON.parse(sessionStorage.getItem('roles') || '{}');
  }

  public setToken(jwtToken:string) {
    sessionStorage.setItem('jwtToken',jwtToken);
  }

  public getToken() :string | null{
    return sessionStorage.getItem('jwtToken');
  }

  public setUsername(username:string){
    return sessionStorage.setItem("username",username)
  }

  public getUsername():string | null{
    return sessionStorage.getItem("username")
  }


  public clear() {
    sessionStorage.clear();
  }

  public isLoggedIn() {
    return this.getRoles() && this.getToken();
  }
}
