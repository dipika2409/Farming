import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpClientService } from 'src/app/service/http-client.service';
import { Supplier1 } from 'src/app/supplier1';

@Component({
  selector: 'app-update-supplier',
  templateUrl: './update-supplier.component.html',
  styleUrls: ['./update-supplier.component.css']
})
export class UpdateSupplierComponent implements OnInit {


  id: number | undefined;
  supplier1!: Supplier1;
  Uemp: Observable<Supplier1> | undefined;
  sid: string = "";

  constructor(private route: ActivatedRoute, private router: Router,
    private httpClientService: HttpClientService) { }

  ngOnInit(): void {
    this.sid = this.route.snapshot.params['id_supp'];
    this.id = Number.parseInt(this.sid);
    this.supplier1 = new Supplier1(this.id, "", "");
    console.log(this.id);
    this.httpClientService.getSupplierById(this.id).subscribe(data => {
      console.log(data)
      this.supplier1 = data;
    }, error => console.log(error));
  }

  onSubmit() {
    this.Uemp = this.httpClientService.updateSupplier(this.supplier1);
    this.Uemp.subscribe(data => { alert(" Supplier updated successfully."); },
      error => alert("supplier does not exist in the database cannot be updated"));
    this.router.navigate(['/suppliers']);
  }
  listSup() {
    this.router.navigate(['suppliers']);
  }

}
