import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Advertise } from 'src/app/advertise';
import { CompserviceService } from 'src/app/service/compservice.service';

@Component({
  selector: 'app-update-advertise',
  templateUrl: './update-advertise.component.html',
  styleUrls: ['./update-advertise.component.css']
})
export class UpdateAdvertiseComponent implements OnInit {

  idA: number | undefined;
  advertise!: Advertise;
  Uadv!: Observable<Advertise>;
  sid!: string;

  constructor(private route: ActivatedRoute, private router: Router,
    private ComplaintService: CompserviceService) { }

  ngOnInit(): void {
    this.sid = this.route.snapshot.params['id_adv'];
    this.idA = Number.parseInt(this.sid);
    this.advertise = new Advertise(this.idA, "", "");
    console.log(this.idA);
    this.ComplaintService.getAdvertiseById(this.idA).subscribe(data => {
      console.log(data)
      this.advertise = data;
    }, (error: any) => console.log(error));
  }


  onSubmit() {
    this.Uadv = this.ComplaintService.updateAdvertise(this.advertise);
    this.Uadv.subscribe(data => { alert("Advertise updated successfully."); },
      error => alert("Advertise does not exist in the database cannot be updated"));
    this.router.navigate(['/advertises']);
  }
  listA() {
    this.router.navigate(['advertises']);
  }

}
