import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  PATH_OF_API = "http://localhost:8888/";

  requestHeader = new HttpHeaders(
    {"No-Auth":"True"}
  );
  constructor(private httpclient: HttpClient,
              private userAuthService: UserAuthService
              ) { }


  public login(loginData: any) {
    console.log(loginData)
    return this.httpclient.post(this.PATH_OF_API+"auth/public/authenticate",loginData,{headers: this.requestHeader});
  }

  public register(signupData: any) {
    console.log(signupData)
    return this.httpclient.post(this.PATH_OF_API+"auth/public/registerNewUser",signupData);
  }

  public roleMatch(allowedRoles:any) :any {
    let isMatch = false;
    const userRoles: any = this.userAuthService.getRoles();

      if(userRoles !=  null && userRoles){
        // for(let i=0; i< userRoles.length;i++) {
          for(let j=0;j< allowedRoles.length;j++) {

            if(userRoles.roleName === allowedRoles[j]) {
              isMatch = true;
              return isMatch;
            } else {
              return isMatch;
            }
          }
        // }
      }
  }

}
