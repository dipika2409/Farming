import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Advertise } from 'src/app/advertise';
import { CompserviceService } from 'src/app/service/compservice.service';

@Component({
  selector: 'app-create-advertise',
  templateUrl: './create-advertise.component.html',
  styleUrls: ['./create-advertise.component.css']
})
export class CreateAdvertiseComponent implements OnInit {


  advertise: Advertise = new Advertise(0, "", "");
  Createadv!: Observable<Advertise>;
  submitted = false;

  constructor(private ComplaintService: CompserviceService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.submitted = true;
    this.Createadv = this.ComplaintService.createAdvertise(this.advertise);
    this.Createadv.subscribe(data => alert("Advertise created successfully."));
    // location.reload();
    this.router.navigate(['/advertises']);
    location.reload();
  }
  home() {
    this.router.navigate(['/supplierHome']);
  }

}
