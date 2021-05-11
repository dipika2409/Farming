import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Complaint } from '../complaint';
import { CompserviceService } from '../service/compservice.service';

@Component({
  selector: 'app-create-complaint',
  templateUrl: './create-complaint.component.html',
  styleUrls: ['./create-complaint.component.css']
})
export class CreateComplaintComponent implements OnInit {

  //complaint:Complaint=new Complaint(0,"","","",0);
  complaint: Complaint = new Complaint(0, "", "", "", 0);

  Createcom!: Observable<Complaint>;


  submitted = false;

  constructor(private ComplaintService: CompserviceService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.submitted = true;
    this.Createcom = this.ComplaintService.createComplaint(this.complaint);

    this.Createcom.subscribe(data => alert("Complaint created successfully."));

    //location.reload();

    this.router.navigate(['/add']);
    //this.router.navigate(['/complaints']);
    location.reload();
  }

  home() {
    this.router.navigate(['/farmerHome']);
  }
}


