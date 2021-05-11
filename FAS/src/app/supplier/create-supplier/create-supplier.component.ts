import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpClientService } from 'src/app/service/http-client.service';
import { Supplier1 } from 'src/app/supplier1';

@Component({
  selector: 'app-create-supplier',
  templateUrl: './create-supplier.component.html',
  styleUrls: ['./create-supplier.component.css']
})
export class CreateSupplierComponent implements OnInit {

  supplier1: Supplier1 = new Supplier1(0, "", "");
  Cemp!: Observable<Supplier1>;
  submitted = false;

  constructor(private httpClientService: HttpClientService, private router: Router) {

  }

  ngOnInit(): void {

  }

  onSubmit() {
    this.submitted = true;
    this.Cemp = this.httpClientService.createSupplier(this.supplier1);
    this.Cemp.subscribe(_data => alert("Supplier created successfully."));
    // location.reload();
    this.router.navigate(['/suppliers']);
  }






}