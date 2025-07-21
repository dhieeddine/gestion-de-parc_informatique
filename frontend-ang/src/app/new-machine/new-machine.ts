import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MachineService} from '../services/machine-service';
import {Fournisseur, FournisseurService} from '../services/fournisseur-service'; // pareil pour les autres
import {Marque, MarqueService} from '../services/marque-service';
import {Ecran, EcranService} from '../services/ecran-service';
import {Garantie, GarantieService} from '../services/garantie-service';
import {CarteVideo, CarteVideoService} from '../services/carte-video-service';
import {Ddur, DdurService} from '../services/ddur-service';
import {Emplacement, EmplacementService} from '../services/emplacement-service';

@Component({
  selector: 'app-new-machine',
  standalone: false,
  templateUrl: './new-machine.html',
  styleUrls: ['./new-machine.css']
})
export class NewMachine implements OnInit {

  machineForm!: FormGroup;

  fournisseurs: Fournisseur[] = [];
  marques: Marque[] = [];
  ecrans: Ecran[] = [];
  garanties: Garantie[] = [];
  carteVideos: CarteVideo[] = [];
  ddurs: Ddur[] = [];
  emplacements: Emplacement[] = [];

  constructor(
    private fb: FormBuilder,
    private machineService: MachineService,
    private fournisseurService: FournisseurService,
    private marqueService: MarqueService,
    private ecranService: EcranService,
    private garantieService: GarantieService,
    private carteVideoService: CarteVideoService,
    private ddurService: DdurService,
    private emplacementService: EmplacementService,
  ) {}

  ngOnInit(): void {
    this.machineForm = this.fb.group({
      typeMachine: ['', Validators.required],
      dateAchat: [null],
      processeur: [''],
      stockage: [''],
      ram: [''],
      adrIP: [''],
      numF: ['', Validators.required],
      numMarque: ['', Validators.required],
      numEcran: ['', Validators.required],
      numGarantie: ['', Validators.required],
      numCarteVideo: ['', Validators.required],
      numDD: ['', Validators.required],
      numEmplacement: ['', Validators.required],
    });

    this.loadData(); // Charger les listes liées
  }

  loadData(): void {
    this.fournisseurService.getAll().subscribe(data => this.fournisseurs = data);
    this.marqueService.getAll().subscribe(data => this.marques = data);
    this.ecranService.getAll().subscribe(data => this.ecrans = data);
    this.garantieService.getAll().subscribe(data => this.garanties = data);
    this.carteVideoService.getAll().subscribe(data => this.carteVideos = data);
    this.ddurService.getAll().subscribe(data => this.ddurs = data);
    this.emplacementService.getAll().subscribe(data => this.emplacements = data);
  }

  onSubmit(): void {
    if (this.machineForm.valid) {
      const formData = new FormData();
      const formValue = this.machineForm.value;

      for (const key in formValue) {
        let value = formValue[key];
        if (value !== null && value !== undefined && value !== '') {
          if (value instanceof Date) {
            const formatted = `${value.getFullYear()}-${value.getMonth() + 1}-${value.getDate()}`;
            formData.append(key, formatted);
          } else {
            formData.append(key, value);
          }
        }
      }

      this.machineService.saveMachine(formData).subscribe({
        next: () => {
          alert("✅ Machine enregistrée avec succès");
          this.machineForm.reset();
        },
        error: err => {
          console.error('❌ Erreur lors de l\'enregistrement', err);
          alert('Erreur lors de l\'enregistrement');
        }
      });
    }
  }
}
