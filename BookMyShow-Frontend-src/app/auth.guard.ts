import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserAuthService } from 'src/services/auth-services/user-auth.service';
import { UserService } from 'src/services/auth-services/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor (private userAuthService: UserAuthService,
    private router: Router,
    private userService: UserService
) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.userAuthService.getToken() !== null) {
        const role = route.data["roles"] as string;
        console.log(role)

        if(role) {
          const match = this.userService.roleMatch(role);

          if(match) {
            return true;
          } else {
            this.router.navigate(['/user-home']);
            return false;
          }
        }
      }
      this.router.navigate(['/'])
      return false;
  }
}

