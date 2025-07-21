import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {EmplacementService} from '../services/emplacement-service';

@Component({
  selector: 'app-new-emplacement',
  standalone: false,
  templateUrl: './new-emplacement.html',
  styleUrl: './new-emplacement.css'
})
export class NewEmplacement implements OnInit
{
  emplacementForm!: FormGroup;

  constructor(private formBuilder: FormBuilder ,
              private emplacementService: EmplacementService) { }
  ngOnInit() {
    this.emplacementForm = this.formBuilder.group({
      nomEmplacement : this.formBuilder.control(''),
      service : this.formBuilder.control(''),


    })
  }


  SaveEmplacement() {
    let formData = new FormData();
    formData.set('nomEmplacement', this.emplacementForm.value.nomEmplacement);
    formData.set('service', this.emplacementForm.value.service);
    this.emplacementService.saveEmplacement(formData).subscribe({
      next: data => {
        alert('Emplacement successfully saved');
      },
      error: err => {
        console.log(err);
      }
    })

  }
}
