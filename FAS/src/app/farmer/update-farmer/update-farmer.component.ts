import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Farmer } from 'src/app/farmer';
import { CompserviceService } from 'src/app/service/compservice.service';

@Component({
  selector: 'app-update-farmer',
  templateUrl: './update-farmer.component.html',
  styleUrls: ['./update-farmer.component.css']
})
export class UpdateFarmerComponent implements OnInit {

  idF!: number;
  farmer!: Farmer;
  Ufar!: Observable<Farmer>;
  sid!: string;

  constructor(private route: ActivatedRoute, private router: Router,
    private ComplaintService: CompserviceService) { }

  ngOnInit(): void {
    this.sid = this.route.snapshot.params['idF'];
    this.idF = Number.parseInt(this.sid);
    this.farmer = new Farmer(this.idF, "", "", "", "");
    console.log(this.idF);
    this.ComplaintService.getFarmerById(this.idF).subscribe(data => {
      console.log(data)
      this.farmer = data;
    }, error => console.log(error));
  }



  onSubmit() {
    this.Ufar = this.ComplaintService.updateFarmer(this.farmer);
    this.Ufar.subscribe(data => { alert("Farmer updated successfully."); },
      error => alert("farmer does not exist in the database cannot be updated"));
    this.router.navigate(['/farmers']);
  }
  listF() {
    this.router.navigate(['farmers']);
  }

}
