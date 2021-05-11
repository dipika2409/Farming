import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Farmer } from 'src/app/farmer';
import { CompserviceService } from 'src/app/service/compservice.service';

@Component({
  selector: 'app-create-farmer',
  templateUrl: './create-farmer.component.html',
  styleUrls: ['./create-farmer.component.css']

})
export class CreateFarmerComponent implements OnInit {
  farmer: Farmer = new Farmer(0, "", "", "", "");
  Cfar!: Observable<Farmer>;
  submitted = false;

  constructor(private ComplaintService: CompserviceService, private router: Router) {

  }

  ngOnInit(): void {

  }

  onSubmit() {
    this.submitted = true;
    this.Cfar = this.ComplaintService.createFarmer(this.farmer);
    this.Cfar.subscribe(data => alert("Farmer created successfully."));
    // location.reload();
    this.router.navigate(['/farmers']);
  }

}
