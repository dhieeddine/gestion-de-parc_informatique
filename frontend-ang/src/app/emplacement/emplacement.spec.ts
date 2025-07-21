import {ComponentFixture, TestBed} from '@angular/core/testing';

import {Emplacement} from './emplacement';

describe('Emplacement', () => {
  let component: Emplacement;
  let fixture: ComponentFixture<Emplacement>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Emplacement]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Emplacement);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
