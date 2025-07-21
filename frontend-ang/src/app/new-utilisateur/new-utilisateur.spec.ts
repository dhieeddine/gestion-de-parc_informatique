import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NewUtilisateur} from './new-utilisateur';

describe('NewUtilisateur', () => {
  let component: NewUtilisateur;
  let fixture: ComponentFixture<NewUtilisateur>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NewUtilisateur]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewUtilisateur);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
