import { Component, OnInit } from '@angular/core';
import {Formation} from "../../model/model.formation";
import {ActivatedRoute, Router} from "@angular/router";
import {FormationService} from "../../services/formation.service";

@Component({
  selector: 'app-edit-formation',
  templateUrl: './edit-formation.component.html',
  styleUrls: ['./edit-formation.component.css']
})
export class EditFormationComponent implements OnInit {
  mode = 1;
  formation: any = new Formation();
  idFormation: number;

  constructor(public activatedRoute: ActivatedRoute , public formationService: FormationService , public router: Router ) {
    this.idFormation = activatedRoute.snapshot.params.id;
  }

  ngOnInit() {
    this.formationService.getFormation(this.idFormation).subscribe(data => {

      this.formation = data;

    }, err => {
      console.log(err);
    });
  }
  updateFormation() {

    this.formationService.updateFormation( this.formation)
      .subscribe(data => {
        console.log(data);
        alert('mise à jour réussi');
        this.router.navigate(['/formations']);
      }, err => {

        alert('Problème de mise à jour !');
        console.log(err);
      });  }

}
