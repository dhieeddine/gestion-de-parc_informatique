import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NewEmplacement} from './new-emplacement';

describe('NewEmplacement', () => {
  let component: NewEmplacement;
  let fixture: ComponentFixture<NewEmplacement>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NewEmplacement]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewEmplacement);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
