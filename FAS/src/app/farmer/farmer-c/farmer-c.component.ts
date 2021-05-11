import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-farmer-c',
  styles: [`

  backg {

    padding:1000px;

    background: rgb(171, 236, 118);

    color: snow;

    

}

`],

  templateUrl: './farmer-c.component.html',
  styleUrls: ['./farmer-c.component.css']
})
export class FarmerCComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
