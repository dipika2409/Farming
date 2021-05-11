import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAdvertiseComponent } from './update-advertise.component';

describe('UpdateAdvertiseComponent', () => {
  let component: UpdateAdvertiseComponent;
  let fixture: ComponentFixture<UpdateAdvertiseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateAdvertiseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateAdvertiseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
