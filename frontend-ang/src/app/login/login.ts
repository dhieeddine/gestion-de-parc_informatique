import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Auth} from '../services/auth';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login implements OnInit {
  public logiForm!: FormGroup;
  constructor(private formBuilder: FormBuilder , private auth: Auth , private router: Router) {
  }
  ngOnInit() {
    this.logiForm = this.formBuilder.group({
      username:this.formBuilder.control('admin'),
     password:this.formBuilder.control('admin'),
    })
  }

  login() {
    let username = this.logiForm.value.username;
    let password = this.logiForm.value.password;
    let authService = this.auth.login(username, password);
    if(authService){
      this.router.navigateByUrl('/admin/acceuil');

    }


  }
}
