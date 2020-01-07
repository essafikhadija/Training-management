import { Component, OnInit } from '@angular/core';
import {Formation} from "../../model/model.formation";
import {FormationService} from "../../services/formation.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-new-formation',
  templateUrl: './new-formation.component.html',
  styleUrls: ['./new-formation.component.css']
})
export class NewFormationComponent implements OnInit {



  formation: any = new Formation();
  mode = 1;

  constructor(public formationService: FormationService, public router: Router) { }

  ngOnInit() {

  }

  saveFormation() {

    this.formationService.saveFormation(this.formation).subscribe(data => {

      this.formation = data ;
      this.mode = 2;
    }, err => {
      console.log(err);
    });
  }



}
