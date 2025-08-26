import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {LogicielService} from '../services/logiciel-service';
import {Auth} from '../services/auth';
import {Router} from '@angular/router';

@Component({
  selector: 'app-logiciel',
  standalone: false,
  templateUrl: './logiciel.html',
  styleUrl: './logiciel.css'
})
export class Logiciel implements OnInit {
  public logiciel: any;
  public dataSource: any;
  public displayedColumns: string[] = ['numL', 'nomL', 'typeL', 'licenceL', 'versionL', 'editeurL', 'dateL','suprimer']
@ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private router: Router, public auth: Auth, private http: HttpClient, private cdRef : ChangeDetectorRef, private logicielService: LogicielService) {
  }

  ngOnInit() {
    this.http.get('https://localhost:8443/logiciels').subscribe({
      next: value => {
        this.logiciel = value;
        this.dataSource = new MatTableDataSource(this.logiciel);
        setTimeout(() => {
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        });

        this.cdRef.detectChanges(); // 👈 Force la mise à jour
      },
      error: err => {
        console.log(err);
      }
    })

  }
  onDeleteLogiciel(id: number) {
    if (confirm("Voulez-vous vraiment supprimer ce logiciel ?")) {
      this.logicielService.deleteLogiciel(id).subscribe({
        next: () => {
          alert("logiciel supprimé avec succès.");
          this.ngOnInit(); // Recharge la liste après suppression
        },
        error: err => {
          console.error(err);
          alert("Erreur lors de la suppression.");
        }
      });
    }
  }

  goToNewLogiciel() {
    this.router.navigate(['/admin/new-logiciel']);

  }
}
