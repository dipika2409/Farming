import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClientService } from '../service/http-client.service';
import { User1 } from '../user1';

@Component({
  selector: 'app-farmer-login',
  templateUrl: './farmer-login.component.html',
  styleUrls: ['./farmer-login.component.css']
})
export class FarmerLoginComponent implements OnInit {
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
    this.router.navigate(['/farmerHome']);

  }

  home1() {
    this.router.navigate(['/home']);
  }
}
