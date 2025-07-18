import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';

@Component({
  selector: 'app-utilisateur',
  standalone: false,
  templateUrl: './utilisateur.html',
  styleUrl: './utilisateur.css'
})
export class Utilisateur implements OnInit {
  public utilisateur : any;
  public dataSource: any;
  public displayedColumns: string[] = ['numU', 'nomU','prenomU','droitU'];
 @ViewChild(MatPaginator) paginator! : MatPaginator;
 @ViewChild(MatSort) sort!: MatSort;
  constructor(private http: HttpClient, private cdRef : ChangeDetectorRef) {
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

}
