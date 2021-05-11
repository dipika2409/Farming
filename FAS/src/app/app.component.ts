import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FAS';
  
  imgUrl="https://static.javatpoint.com/tutorial/angular7/images/angular-7-logo.png";
 
  selectedValue:number | undefined;

  onSave($event: any){
    console.log("Save button is clicked ",$event);
    document.write("Button is clicked ");
}
}
