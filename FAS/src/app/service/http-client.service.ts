import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../product';
import { Supplier1 } from '../supplier1';
import { User1 } from '../user1';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  product!: Product;
  constructor(private httpClient: HttpClient) {

  }

  private baseUrl = "http://localhost:9090/api/";

  public createProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(`${this.baseUrl}addProduct`, product);
  }

  public getProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>("http://localhost:9090/api/getProduct");
  }

  public getProductById(product_id: number): Observable<Product> {
    return this.httpClient.get<Product>("http://localhost:9090/api/getProducts/" + product_id);
  }

  public deleteProduct(product_id: number): Observable<Product> {
    return this.httpClient.delete<Product>(`${this.baseUrl}deleteProducts/` + product_id);
  }



  public updateProduct(product: Product): Observable<Product> {
    return this.httpClient.put<Product>(`${this.baseUrl}updateProduct/`, product);
  }
  public createSupplier(supplier1: Supplier1): Observable<Supplier1> {
    return this.httpClient.post<Supplier1>(`${this.baseUrl}addSupplier`, supplier1);
  }

  public getSuppliers(): Observable<Supplier1[]> {
    return this.httpClient.get<Supplier1[]>("http://localhost:9090/api/getSupplier");
  }

  public getSupplierById(supplier_id: number): Observable<Supplier1> {
    return this.httpClient.get<Supplier1>("http://localhost:9090/api/getSuppliers/" + supplier_id);
  }

  public deleteSupplier(supplier_id: number): Observable<Supplier1> {
    return this.httpClient.delete<Supplier1>(`${this.baseUrl}delete/` + supplier_id);
  }



  public updateSupplier(supplier1: Supplier1): Observable<Supplier1> {
    return this.httpClient.put<Supplier1>(`${this.baseUrl}updateSupplier/`, supplier1);
  }



  public adminLogin(user1: User1): Observable<User1> {
    return this.httpClient.post<User1>("http://localhost:9090/login", user1);
  }
}




