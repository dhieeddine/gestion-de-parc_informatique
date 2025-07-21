import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NewFournisseur} from './new-fournisseur';

describe('NewFournisseur', () => {
  let component: NewFournisseur;
  let fixture: ComponentFixture<NewFournisseur>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NewFournisseur]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewFournisseur);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
