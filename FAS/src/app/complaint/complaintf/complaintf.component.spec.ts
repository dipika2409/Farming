import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplaintfComponent } from './complaintf.component';

describe('ComplaintfComponent', () => {
  let component: ComplaintfComponent;
  let fixture: ComponentFixture<ComplaintfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComplaintfComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComplaintfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
