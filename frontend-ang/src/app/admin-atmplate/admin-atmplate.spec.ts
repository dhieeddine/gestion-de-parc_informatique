import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAtmplate } from './admin-atmplate';

describe('AdminAtmplate', () => {
  let component: AdminAtmplate;
  let fixture: ComponentFixture<AdminAtmplate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminAtmplate]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminAtmplate);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
