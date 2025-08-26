import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Router} from '@angular/router';
import {EmplacementService} from '../services/emplacement-service';
import {Auth} from '../services/auth';

@Component({
  selector: 'app-emplacement',
  standalone: false,
  templateUrl: './emplacement.html',
  styleUrl: './emplacement.css'
})
export class Emplacement implements OnInit {
  public emplacement : any;
  public dataSource: any;
  public displayedColumns: string[] = ['numEmplacement','nomEmplacement','service','suprimer']
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private http: HttpClient, private cdRef : ChangeDetectorRef,  private router: Router ,private emplacementService: EmplacementService, public auth:Auth) {
  }
  ngOnInit() {
    this.http.get('https://localhost:8443/emplacements').subscribe({
      next: value => {
        this.emplacement = value;
        this.dataSource= new MatTableDataSource(this.emplacement);
        setTimeout(() => {
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        });

        this.cdRef.detectChanges(); // 👈 Force la mise à jour
      },
      error: err => {console.log(err);}
    })
  }

  newEmplacement() {
    this.router.navigate(['/admin/new-emplacement']);
  }

  onDeleteEmplacement(id: number) {
    if (confirm("Voulez-vous vraiment supprimer cet emplacement?")) {
      this.emplacementService.deleteEmplacement(id).subscribe({
        next: () => {
          alert("Emplacement supprimé avec succès.");
          this.ngOnInit(); // Recharge la liste après suppression
        },
        error: err => {
          console.error(err);
          alert("Erreur lors de la suppression.");
        }
      });
    }
  }

}
