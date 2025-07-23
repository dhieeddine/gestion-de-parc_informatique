import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Router} from '@angular/router';
import {FournisseurService} from '../services/fournisseur-service';
import {Auth} from '../services/auth';

@Component({
  selector: 'app-fournisseur',
  standalone: false,
  templateUrl: './fournisseur.html',
  styleUrl: './fournisseur.css'
})
export class Fournisseur implements OnInit {
  public fournisseur : any;
  public dataSource: any;
  public displayedColumns: string[] = ['numF','nomF','adresseF','codePF','telF','suprimer']
@ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(public auth :Auth ,private http: HttpClient, private cdRef: ChangeDetectorRef, private router: Router, private fournisseurService: FournisseurService) {
  }
  ngOnInit() {
    this.http.get('https://localhost:8080/fournisseurs').subscribe({
      next: value => {
        this.fournisseur = value;
        this.dataSource= new MatTableDataSource(this.fournisseur);
        setTimeout(() => {
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        });

        this.cdRef.detectChanges(); // 👈 Force la mise à jour
      },
      error: err => {console.log(err);}
    })
  }


  newFournisseur() {
    this.router.navigate(['/admin/new-fournisseur']);

  }

  onDeleteFournisseur(id: number) {
    if (confirm("Voulez-vous vraiment supprimer ce fournisseur ?")) {
      this.fournisseurService.deleteFournisseur(id).subscribe({
        next: () => {
          alert("Fournisseur supprimé avec succès.");
          this.ngOnInit(); // Recharge la liste après suppression
        },
        error: err => {
          console.error("Erreur lors de la suppression :", err);
          alert("Erreur lors de la suppression.");
        }
      });
    }
  }
}
