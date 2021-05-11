import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FarmercomplaintlistComponent } from './farmercomplaintlist.component';

describe('FarmercomplaintlistComponent', () => {
  let component: FarmercomplaintlistComponent;
  let fixture: ComponentFixture<FarmercomplaintlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FarmercomplaintlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FarmercomplaintlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
