import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Complaint } from 'src/app/complaint';
import { CompserviceService } from 'src/app/service/compservice.service';

@Component({
  selector: 'app-farmercomplaintlist',
  templateUrl: './farmercomplaintlist.component.html',
  styleUrls: ['./farmercomplaintlist.component.css']
})
export class FarmercomplaintlistComponent implements OnInit {
  complaint_status = 'Unread';
  complaints: Complaint[] = [];
  dcomplaints: Complaint[] = [];
  complaint: Complaint = new Complaint(0, "", "", "", 0);

  comp!: Observable<Complaint[]>;
  dcomp!: Observable<Complaint>;
  Ucomp!: Observable<Complaint>;
  constructor(private ComplaintService: CompserviceService, private router: Router) { }

  ngOnInit(): void {
    this.comp = this.ComplaintService.getComplaints();
    this.comp.subscribe((data) => this.complaints = data);
  }

  deleteComplaint(complaint_id: number): void {
    this.dcomp = this.ComplaintService.deleteComplaint(complaint_id);
    alert("Complaint deleted Successfully");
    location.reload();
    this.dcomp.subscribe(() => this.ComplaintService.getComplaints());
  }


  updateComplaint(complaint_id: number): void {
    this.router.navigate(['update', complaint_id]);
  }

}
