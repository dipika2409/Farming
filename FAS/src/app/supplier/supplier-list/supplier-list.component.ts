import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpClientService } from 'src/app/service/http-client.service';
import { Supplier1 } from 'src/app/supplier1';

@Component({
  selector: 'app-supplier-list',
  templateUrl: './supplier-list.component.html',
  styleUrls: ['./supplier-list.component.css']
})
export class SupplierListComponent implements OnInit {

  suppliers!: Supplier1[];
  dsuppliers!: Supplier1[];
  supplier1: Supplier1 = new Supplier1(0, "", "");

  emps!: Observable<Supplier1[]>;
  demp!: Observable<Supplier1>;
  Uemp!: Observable<Supplier1>;
  constructor(private httpClientService: HttpClientService, private router: Router) { }

  ngOnInit(): void {
    this.emps = this.httpClientService.getSuppliers();
    this.emps.subscribe((data) => this.suppliers = data);
  }

  deleteSupplier(supplier_id: number): void {
    this.demp = this.httpClientService.deleteSupplier(supplier_id);
    alert("Supplier deleted Successfully");
    location.reload();
    this.demp.subscribe(() => this.httpClientService.getSuppliers());
  }

  updateSupplier(supplier_id: number): void {
    this.router.navigate(['update/supplier', supplier_id]);
  }
}