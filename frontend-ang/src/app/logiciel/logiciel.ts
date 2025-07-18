import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthGuard} from '../gards/auth-guard';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';

@Component({
  selector: 'app-logiciel',
  standalone: false,
  templateUrl: './logiciel.html',
  styleUrl: './logiciel.css'
})
export class Logiciel implements OnInit {
  public logiciel: any;
  public dataSource: any;
  public displayedColumns: string[] = ['numL', 'nomL', 'typeL', 'licenceL', 'versionL', 'editeurL', 'dateL']
@ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private http: HttpClient, private cdRef : ChangeDetectorRef) {
  }

  ngOnInit() {
    this.http.get('http://localhost:8080/logiciels').subscribe({
      next: value => {
        this.logiciel = value;
        this.dataSource = new MatTableDataSource(this.logiciel);
        setTimeout(() => {
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        });
        setTimeout(() => this.dataSource.paginator = this.paginator);

        this.cdRef.detectChanges(); // 👈 Force la mise à jour
      },
      error: err => {
        console.log(err);
      }
    })

  }
}
