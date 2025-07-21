import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NewMachine} from './new-machine';

describe('NewMachine', () => {
  let component: NewMachine;
  let fixture: ComponentFixture<NewMachine>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NewMachine]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewMachine);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
