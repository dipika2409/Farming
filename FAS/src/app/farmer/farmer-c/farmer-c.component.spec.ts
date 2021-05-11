import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FarmerCComponent } from './farmer-c.component';

describe('FarmerCComponent', () => {
  let component: FarmerCComponent;
  let fixture: ComponentFixture<FarmerCComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FarmerCComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FarmerCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
