import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from 'src/app/product';
import { HttpClientService } from 'src/app/service/http-client.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  product: Product = new Product(0, "", 0, 0, "");
  Createprod!: Observable<Product>;
  submitted = false;

  constructor(private httpClientService: HttpClientService, private router: Router) {

  }

  ngOnInit(): void {

  }

  onSubmit() {
    this.submitted = true;
    this.Createprod = this.httpClientService.createProduct(this.product);
    this.Createprod.subscribe(data => alert("Product created successfully."));
    // location.reload();
    this.router.navigate(['/add/product']);
    location.reload();
  }

  home() {
    this.router.navigate(['/farmerHome']);
  }
}

