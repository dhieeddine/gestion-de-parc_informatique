import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NewLogiciel} from './new-logiciel';

describe('NewLogiciel', () => {
  let component: NewLogiciel;
  let fixture: ComponentFixture<NewLogiciel>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NewLogiciel]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewLogiciel);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
