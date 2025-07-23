import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MachineService} from '../services/machine-service';
import {Auth} from '../services/auth';
import {Router} from '@angular/router';

@Component({
  selector: 'app-machines',
  standalone: false,
  templateUrl: './machines.html',
  styleUrl: './machines.css'
})
export class Machines implements OnInit {
  public machines : any;
  public dataSource: any;
  public displayedColumns: string[] = ['numMachine', 'ecran','marque','fournisseur','carteVideo','disqueDur','emplacement','typeMachine','dateAchat','ram','adrIP','suprimer'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private router:Router ,public auth:Auth, private http: HttpClient , private cdRef : ChangeDetectorRef,private machineService:MachineService) {
  }
  ngOnInit() {
    this.http.get('https://localhost:8080/machines').subscribe({
      next: value => {
        this.machines = value;
        this.dataSource= new MatTableDataSource(this.machines);
        setTimeout(() => {
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        });
        this.cdRef.detectChanges(); // 👈 Force la mise à jour
      },
      error: err => {console.log(err);}
    })
  }
  onDeleteMachine(id: number) {
    if (confirm("Voulez-vous vraiment supprimer cette machine ?")) {
      this.machineService.deleteMachine(id).subscribe({
        next: () => {
          alert("machine supprimé avec succès.");
          this.ngOnInit(); // Recharge la liste après suppression
        },
        error: err => {
          console.error(err);
          alert("Erreur lors de la suppression.");
        }
      });
    }
  }

  goToNewMachine() {
    this.router.navigate(['/admin/new-machine']);

  }


}
