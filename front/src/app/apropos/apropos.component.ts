import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-apropos',
  templateUrl: './apropos.component.html',
  styleUrls: ['./apropos.component.css']
})
export class AproposComponent implements OnInit {


  informations = {'Nom Enreprise': 'ESS FORMATION', 'Date de création': '12 Avril 2019',
    'Nombre des formateurs': '4', Adresse: '253 Rue de Crimée 75019 Paris'};
  constructor() { }

  ngOnInit() {
  }

}
