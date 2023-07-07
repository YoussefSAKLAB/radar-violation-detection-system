import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Owner} from "../models/owner.model";
import {Observable, retry} from "rxjs";
const baseUrl = "http://localhost:8890/REGISTRATION-SERVICE/api/restOwner/";
@Injectable({
  providedIn: 'root'
})
export class OwnersService {
  private owners! : Owner[];
  private errMessage! : string;

  constructor(private http : HttpClient) {
    this.http.get(`http://localhost:8890/REGISTRATION-SERVICE/owners?projection=fullOwner`).subscribe({
      next : data => {
        this.owners = data as Owner[];
      },
      error : err => {
        this.errMessage = err;
      }
    });
  }
  getAllOwners():Observable<Owner[]>{
    return this.http.get<Owner[]>(`http://localhost:8890/REGISTRATION-SERVICE/owners?projection=fullOwner`).pipe(retry(1))
  }
  getOwnersCount(): Observable<number> {
    return this.http.get<number>(`${baseUrl}count`);
  }
  public deleteOwner(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`http://localhost:8890/REGISTRATION-SERVICE/owners/${id}`);
  }
}
