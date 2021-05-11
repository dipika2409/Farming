import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from 'src/app/product';
import { HttpClientService } from 'src/app/service/http-client.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  id: number | undefined;
  product!: Product;
  Uprod: Observable<Product> | undefined;
  sid: string = "";

  constructor(private route: ActivatedRoute, private router: Router,
    private httpClientService: HttpClientService) { }

  ngOnInit(): void {
    this.sid = this.route.snapshot.params['id_prod'];
    this.id = Number.parseInt(this.sid);
    this.product = new Product(this.id, "", 0, 0, "");
    console.log(this.id);
    this.httpClientService.getProductById(this.id).subscribe(data => {
      console.log(data)
      this.product = data;
    }, error => console.log(error));
  }

  onSubmit() {
    this.Uprod = this.httpClientService.updateProduct(this.product);
    this.Uprod.subscribe(data => { alert("Product updated successfully."); },
      error => alert("Product does not exist in the database cannot be updated"));
    this.router.navigate(['/products']);
  }
  listPro() {
    this.router.navigate(['products']);
  }

}
