import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-complaintf',
  templateUrl: './complaintf.component.html',
  styleUrls: ['./complaintf.component.css']
})
export class ComplaintfComponent implements OnInit {
  ImagePath: string | undefined;
  constructor( ) {     this.ImagePath = '/assets/Image/advimg.jpg'}

  ngOnInit(): void {
  }

}
