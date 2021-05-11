import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from 'src/app/product';
import { HttpClientService } from 'src/app/service/http-client.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products!: Product[];
  dproducts!: Product[];
  product: Product = new Product(0, "", 0, 0, "");

  prod!: Observable<Product[]>;
  dprod!: Observable<Product>;
  Uprod!: Observable<Product>;


  constructor(private httpClientService: HttpClientService, private router: Router) { }

  ngOnInit(): void {
    this.prod = this.httpClientService.getProducts();
    this.prod.subscribe((data) => this.products = data);
  }

  deleteProduct(product_id: number): void {
    this.dprod = this.httpClientService.deleteProduct(product_id);
    alert("Product deleted Successfully");
    location.reload();
    this.dprod.subscribe(() => this.httpClientService.getProducts());
  }

  updateProduct(product_id: number): void {
    this.router.navigate(['update/product', product_id]);
  }
}
