import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Farmer } from 'src/app/farmer';
import { CompserviceService } from 'src/app/service/compservice.service';

@Component({
  selector: 'app-farmer-list',
  templateUrl: './farmer-list.component.html',
  styleUrls: ['./farmer-list.component.css']
})
export class FarmerListComponent implements OnInit {

  farmers: Farmer[] | undefined;
  // dfarmers:Farmer[];
  farmer: Farmer = new Farmer(0, "", "", "", "");

  fars!: Observable<Farmer[]>;
  dfar!: Observable<Farmer>;
  // Ufar:Observable<Farmer>;
  constructor(private ComplaintService: CompserviceService, private router: Router) { }

  ngOnInit(): void {
    this.fars = this.ComplaintService.getFarmers();
    this.fars.subscribe((data) => this.farmers = data);
  }

  deleteFarmer(farmer_id: number): void {
    this.dfar = this.ComplaintService.deleteFarmer(farmer_id);
    alert("Farmer deleted Successfully");
    location.reload();
    this.dfar.subscribe(() => this.ComplaintService.getFarmers());
  }

  updateFarmer(idF: number): void {
    this.router.navigate(['updates', idF]);
  }
}
