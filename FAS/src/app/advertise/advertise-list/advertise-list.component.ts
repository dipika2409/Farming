import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Advertise } from 'src/app/advertise';
import { CompserviceService } from 'src/app/service/compservice.service';

@Component({
  selector: 'app-advertise-list',
  templateUrl: './advertise-list.component.html',
  styleUrls: ['./advertise-list.component.css']
})
export class AdvertiseListComponent implements OnInit {

  advertises: Advertise[] = [];
  //dadvertises:Advertise[]=[];
  advertise: Advertise = new Advertise(0, "", "");

  adv!: Observable<Advertise[]>;
  dadv!: Observable<Advertise>;
  //Uadv!: Observable<Advertise>;
  constructor(private ComplaintService: CompserviceService, private router: Router) { }

  ngOnInit(): void {
    this.adv = this.ComplaintService.getAdvertises();
    this.adv.subscribe((data) => this.advertises = data);
  }

  deleteAdvertise(adv_id: number): void {
    this.dadv = this.ComplaintService.deleteAdvertise(adv_id);
    alert("Advertise deleted Successfully");
    location.reload();
    this.dadv.subscribe(() => this.ComplaintService.getAdvertises());
  }


  updateAdvertise(idA: number): void {
    this.router.navigate(['updatead', idA]);
  }

}

