import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';

@Component({
  selector: 'app-emplacement',
  standalone: false,
  templateUrl: './emplacement.html',
  styleUrl: './emplacement.css'
})
export class Emplacement implements OnInit {
  public emplacement : any;
  public dataSource: any;
  public displayedColumns: string[] = ['numEmplacement','nomEmplacement','service']
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private http: HttpClient, private cdRef : ChangeDetectorRef) {
  }
  ngOnInit() {
    this.http.get('http://localhost:8080/emplacements').subscribe({
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

}
