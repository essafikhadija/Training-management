import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Formation} from '../model/model.formation';
import {URL_FORMATIONS_SEARCH} from '../app/constants/Constants'
import {AuthenticationService} from "../app/service/authentication.service";

@Injectable()
export class FormationService {

  //public host:string="http://localhost:8080";

  constructor(public http: HttpClient,private authService: AuthenticationService) {
  }

  getFormations(motCle: string, page: number, size: number) {

    let headers =new HttpHeaders({'authorization':'Bearer '+this.authService.jwt});
    return this.http.get(URL_FORMATIONS_SEARCH + motCle + '&page=' + page + '&size=' + size + '',{headers:headers});
  }

  saveFormation(formation: Formation) {
    let headers =new HttpHeaders({'authorization':'Bearer '+this.authService.jwt});
    return this.http.post('/create', formation,{headers:headers});
  }

  getFormation(id: number) {
    let headers =new HttpHeaders({'authorization':'Bearer '+this.authService.jwt});
    return this.http.get('/formations/' + id,{headers:headers});

  }

  updateFormation(formation: Formation) {
    let headers =new HttpHeaders({'authorization':'Bearer '+this.authService.jwt});
    return this.http.put('/formations/' + formation.id, formation,{headers:headers});
  }

  deleteFormation(id: number) {
    let headers =new HttpHeaders({'authorization':'Bearer '+this.authService.jwt})
    return this.http.delete('/formations/' + id,{headers:headers});
  }

}
