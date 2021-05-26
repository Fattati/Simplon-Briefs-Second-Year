import { Component, OnInit } from '@angular/core';
import {LocalstorageService} from '../services/localstorage/localstorage.service';
import {AuthenticationService} from '../services/authentication/authentication.service';
import {FormBuilder} from '@angular/forms';
import {LoginData} from '../models/login-data.model';
import {AuthResponse} from '../models/auth-response.model';


@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {

  loginForm = this.formBuilder.group({
    email: '',
    password: ''
  });

  constructor(private localStorageService: LocalstorageService, private authenticationService: AuthenticationService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    let formData: LoginData = new LoginData().deserialize(this.loginForm.value);
    this.authenticationService.login(formData).subscribe((data: AuthResponse) => {
      this.localStorageService.set('token', data.token || '');
      alert('good');
    }, error => {
      console.error(error.error);
      alert('bad');
    });
  }

}
