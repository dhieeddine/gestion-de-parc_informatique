import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {UtilisateurService} from '../services/utilisateur-service';
import {Auth} from '../services/auth';
import {Router} from '@angular/router';

@Component({
  selector: 'app-utilisateur',
  standalone: false,
  templateUrl: './utilisateur.html',
  styleUrl: './utilisateur.css'
})
export class Utilisateur implements OnInit {
  public utilisateur : any;
  public dataSource: any;
  public displayedColumns: string[] = ['numU', 'nomU','prenomU','droitU','suprimer'];
 @ViewChild(MatPaginator) paginator! : MatPaginator;
 @ViewChild(MatSort) sort!: MatSort;
  constructor(private router :Router,public auth:Auth, private http: HttpClient, private cdRef : ChangeDetectorRef, private utilisateurService : UtilisateurService) {
  }
  ngOnInit() {
    this.http.get('http://localhost:8080/utilisateurs').subscribe({
      next: value => {
        this.utilisateur = value;
        this.dataSource= new MatTableDataSource(this.utilisateur);
        setTimeout(() => {
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        });
        this.cdRef.detectChanges(); // 👈 Force la mise à jour
      },
      error: err => {console.log(err);}
    })
  }
  onDeleteUtilisateur(id: number) {
    if (confirm("Voulez-vous vraiment supprimer ce utilisateur? ?")) {
      this.utilisateurService.deleteUtilisateur(id).subscribe({
        next: () => {
          alert("utilisateur supprimé avec succès.");
          this.ngOnInit(); // Recharge la liste après suppression
        },
        error: err => {
          console.error(err);
          alert("Erreur lors de la suppression.");
        }
      });
    }
  }

  goToNewUtilisateur() {
    this.router.navigate(['/admin/new-utilisateur']);

  }
}
