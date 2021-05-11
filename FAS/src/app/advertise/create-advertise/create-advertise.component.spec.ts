import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAdvertiseComponent } from './create-advertise.component';

describe('CreateAdvertiseComponent', () => {
  let component: CreateAdvertiseComponent;
  let fixture: ComponentFixture<CreateAdvertiseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateAdvertiseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAdvertiseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
