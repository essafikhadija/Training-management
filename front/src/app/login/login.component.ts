import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthenticationService, private router : Router) { }

  ngOnInit() {
  }

  onLogin(data) {
    this.authService.login(data).subscribe(resp =>{
      let jwt = resp.headers.get("Authorization");
      this.authService.saveToken(jwt);
      this.router.navigateByUrl("/accueil");

    },err=>{
      console.log(err);
    })
  }



}
