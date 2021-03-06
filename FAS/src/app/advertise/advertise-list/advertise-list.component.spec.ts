import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvertiseListComponent } from './advertise-list.component';

describe('AdvertiseListComponent', () => {
  let component: AdvertiseListComponent;
  let fixture: ComponentFixture<AdvertiseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdvertiseListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvertiseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
