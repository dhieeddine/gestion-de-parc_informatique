import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UtilisateurService} from '../services/utilisateur-service';

@Component({
  selector: 'app-new-utilisateur',
  standalone: false,
  templateUrl: './new-utilisateur.html',
  styleUrls: ['./new-utilisateur.css']
})
export class NewUtilisateur implements OnInit {

  utilisateurForm!: FormGroup;

  constructor(private utilisateurService: UtilisateurService, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.utilisateurForm = this.fb.group({
      nomU: ['', Validators.required],
      prenomU: ['', Validators.required],
      password: ['', Validators.required],
      droitU: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.utilisateurForm.valid) {
      const formData = new FormData();

      for (const key in this.utilisateurForm.value) {
        const value = this.utilisateurForm.value[key];
        if (value !== null && value !== undefined) {
          formData.append(key, value);
        }
      }

      for (const pair of formData.entries()) {
        console.log(`${pair[0]}: ${pair[1]}`);
      }

      this.utilisateurService.saveUtilisateur(formData).subscribe({
        next: data => {
          alert('✅ Utilisateur enregistré avec succès');
          this.utilisateurForm.reset();
        },
        error: err => {
          console.error('❌ Erreur lors de l\'enregistrement de l\'utilisateur', err);
          alert('Erreur lors de l\'enregistrement');
        }
      });
    }
  }
}
