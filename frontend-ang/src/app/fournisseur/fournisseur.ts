import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';

@Component({
  selector: 'app-fournisseur',
  standalone: false,
  templateUrl: './fournisseur.html',
  styleUrl: './fournisseur.css'
})
export class Fournisseur implements OnInit {
  public fournisseur : any;
  public dataSource: any;
  public displayedColumns: string[] = ['numF','nomF','adresseF','codePF','telF']
@ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private http: HttpClient, private cdRef: ChangeDetectorRef) {
  }
  ngOnInit() {
    this.http.get('http://localhost:8080/fournisseurs').subscribe({
      next: value => {
        this.fournisseur = value;
        this.dataSource= new MatTableDataSource(this.fournisseur);
        setTimeout(() => this.dataSource.paginator = this.paginator);
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
