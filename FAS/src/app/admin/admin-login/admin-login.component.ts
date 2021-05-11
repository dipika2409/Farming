import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClientService } from 'src/app/service/http-client.service';
import { User1 } from 'src/app/user1';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  loading = false;
  submitted = false;
  loginForm!: FormGroup;

  admin: User1 = new User1();
  constructor(private adminservice: HttpClientService, private router: Router, private formBuilder: FormBuilder) {



  }

  ngOnInit(): void {


    this.loginForm = this.formBuilder.group({
      uId: [''],
      emailId: ['', Validators.compose([Validators.required, Validators.minLength(7)])],

      password: ['', [Validators.required, Validators.minLength(6)]],
    })
  }

  get f() {
    return this.loginForm.controls;
  }
  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }
    this.router.navigate(['/adminHome']);

  }

  home() {
    this.router.navigate(['/home']);
  }
}
