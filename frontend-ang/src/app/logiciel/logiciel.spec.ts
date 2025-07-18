import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Logiciel } from './logiciel';

describe('Logiciel', () => {
  let component: Logiciel;
  let fixture: ComponentFixture<Logiciel>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Logiciel]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Logiciel);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
