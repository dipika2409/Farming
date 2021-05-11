import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Complaint } from '../complaint';
import { CompserviceService } from '../service/compservice.service';

@Component({
  selector: 'app-update-complaint',
  templateUrl: './update-complaint.component.html',
  styleUrls: ['./update-complaint.component.css']
})
export class UpdateComplaintComponent implements OnInit {

  id: number | undefined;
  complaint!: Complaint;
  Ucomp!: Observable<Complaint>;
  sid: string = "";

  constructor(private route: ActivatedRoute, private router: Router,
    private ComplaintService: CompserviceService) { }

  ngOnInit(): void {
    this.sid = this.route.snapshot.params['id'];
    this.id = Number.parseInt(this.sid);
    this.complaint = new Complaint(this.id, "", "", "", 0);
    console.log(this.id);
    this.ComplaintService.getComplaintById(this.id).subscribe(data => {
      console.log(data)
      this.complaint = data;
    }, (error: any) => console.log(error));
  }


  onSubmit() {
    this.Ucomp = this.ComplaintService.updateComplaint(this.complaint);
    this.Ucomp.subscribe(data => { alert("Complaint updated successfully."); },
      error => alert("Complaint does not exist in the database cannot be updated"));

    this.router.navigate(['/complaints']);

  }
  list() {
    this.router.navigate(['complaints']);
  }

}
