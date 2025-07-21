import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {FournisseurService} from '../services/fournisseur-service';

@Component({
  selector: 'app-new-fournisseur',
  standalone: false,
  templateUrl: './new-fournisseur.html',
  styleUrl: './new-fournisseur.css'
})
export class NewFournisseur implements OnInit {
  fournisseurForm!: FormGroup;

  constructor(private formBuilder: FormBuilder ,
              private fournisseurService: FournisseurService) { }
  ngOnInit() {
    this.fournisseurForm = this.formBuilder.group({
      nomF: this.formBuilder.control(''),
      adresseF : this.formBuilder.control(''),
      codePF : this.formBuilder.control(''),
      telF : this.formBuilder.control(''),



    })
  }


  SaveFournisseur() {
    let formData = new FormData();
    formData.set('nomF', this.fournisseurForm.value.nomF);
    formData.set('adresseF', this.fournisseurForm.value.adresseF);
    formData.set('codePF', this.fournisseurForm.value.codePF);
    formData.set('telF', this.fournisseurForm.value.telF);


    this.fournisseurService.saveFournisseur(formData).subscribe({
      next: data => {
        alert('Fournisseur successfully saved');
      },
      error: err => {
        console.log(err);
      }
    })

  }

}
