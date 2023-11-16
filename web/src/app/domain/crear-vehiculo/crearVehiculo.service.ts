import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { CrearModel } from "./crearVehiculo.model";

@Injectable({ providedIn: 'root' })
export class CrearVehiculoService {

  // The API URL where you will send the POST request
  apiUserUrl = 'http://localhost:8080/api/parking/create';

  constructor(private httpClient: HttpClient) {}

  // Method to make a POST request with id, placa, and horaEntrada
  crearNuevoVehiculo(nuevoVehiculo: { id: number; placa: string; horaEntrada: string; tipoVehiculo: string }): Observable<any> {
    return this.httpClient.post(this.apiUserUrl, nuevoVehiculo);
  }

  // Method to get all data
  postAllCrear(): Observable<CrearModel[]> {
    return this.httpClient.get<CrearModel[]>(this.apiUserUrl);
  }
}
