import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {LogicielService} from '../services/logiciel-service';

@Component({
  selector: 'app-new-logiciel',
  standalone: false,
  templateUrl: './new-logiciel.html',
  styleUrls: ['./new-logiciel.css'] // <== ici c'était `styleUrl` au lieu de `styleUrls`
})
export class NewLogiciel implements OnInit {

  logicielForm!: FormGroup;

  constructor(private logicielService: LogicielService, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.logicielForm = this.fb.group({
      nomL: ['', Validators.required],
      typeL: ['', Validators.required],
      licenceL: [''],
      versionL: [''],
      editeurL: [''],
      numSerieL: [''],
      dateL: [null]
    });
  }

  onSubmit(): void {
    if (this.logicielForm.valid) {
      const formData = new FormData();

      for (const key in this.logicielForm.value) {
        let value = this.logicielForm.value[key];
        if (value instanceof Date) {
          let date = new Date(value);
           value= date.getDate()+'/'+(date.getMonth()+1)+'/'+date.getFullYear();

        }

        if (value !== null && value !== undefined) {
          formData.append(key, value);
        }
      }
      for (const pair of formData.entries()) {
        console.log(`${pair[0]}: ${pair[1]}`);
      }

      this.logicielService.saveLogiciel(formData).subscribe({
        next: data => {
          alert('✅ Logiciel enregistré avec succès');
          this.logicielForm.reset(); // Réinitialiser le formulaire
        },
        error: err => {
          console.error('❌ Erreur lors de l\'enregistrement du logiciel', err);
          alert('Erreur lors de l\'enregistrement');
        }
      });
    }
  }
}
