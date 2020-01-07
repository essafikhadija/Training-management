import { Component, OnInit } from '@angular/core';
import {Formation} from "../../model/model.formation";
import {HttpClient} from "@angular/common/http";
import {FormationService} from "../../services/formation.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrls: ['./formation.component.css']
})
export class FormationComponent implements OnInit {

  pageFormations: any;
  motCle = '';
  currentPage = 0;
  size = 10;
  pages: Array<number>;
  constructor(public http: HttpClient, public formationservice: FormationService, public router: Router, private authService: AuthenticationService ) {
  }

  ngOnInit() {this.doSearch();}
  doSearch() {
    this.formationservice.getFormations(this.motCle, this.currentPage, this.size)
      .subscribe((data: any) => {
        this.pageFormations = data;
        this.pages = new Array(data.totalPages);
      }, err => {
        console.log(err);
      });
  }
  chercher() {
    this.doSearch();
  }
  gotoPage(i: number) {
    this.currentPage = i;
    this.doSearch();
  }

  onEditFormation(id: number) {
    this.router.navigate(['edit-formation', id]);

  }

  ondeleteFormation(f: Formation ) {
    const confirm = window.confirm('Confirmez-vous la suppression');
    if (confirm === true) {
      this.formationservice.deleteFormation(f.id).subscribe(data => {
        console.log(data);
        alert('Suppression réussite !');
        this.pageFormations.content.splice(this.pageFormations.content.indexOf(f), 1);

      }, err => {
        console.log(err);
        alert('Suppression en echec !');
      });
    }

  }
  isAdmin(){
    return this.authService.isAdmin();
  }

}
