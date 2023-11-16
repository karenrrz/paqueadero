import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { VehiculoModel} from "./vehiculo.model";

@Injectable({ providedIn: 'root' })
export class VehiculoService {
  private apiUserUrl = 'http://localhost:8080/api/parking/';

  constructor(private httpClient: HttpClient) {}

  getAllVehiculo(): Observable<VehiculoModel[]> {
    return this.httpClient.get<VehiculoModel[]>(this.apiUserUrl);
  }

  getVehiculoByPlaca(placa: string): Observable<VehiculoModel> {
    const url = `${this.apiUserUrl}?placa=${placa}`;
    return this.httpClient.get<VehiculoModel>(url);
  }
    horaSalida(id: number): Observable<VehiculoModel> {
        const url = `${this.apiUserUrl}update/${id}`;
        const nuevaHoraSalida = new Date().toISOString();

        // Enviar la nueva hora de salida en el cuerpo de la solicitud PUT
        return this.httpClient.put<VehiculoModel>(url, { horaSalida: nuevaHoraSalida });
    }
    deleteVehiculo(id: number): Observable<void> {
        const url = `${this.apiUserUrl}/${id}`;
        return this.httpClient.delete<void>(`http://localhost:8080/api/parking/${id}`);
    }


  crearNuevoVehiculo(nuevoVehiculo: { id: number; placa: string; horaEntrada: string; tipoVehiculo: string }): Observable<any> {
    return this.httpClient.post(`${this.apiUserUrl}create`, nuevoVehiculo);
  }

  // Method to get all data
  postAll(): Observable<VehiculoModel[]> {
    return this.httpClient.get<VehiculoModel[]>(this.apiUserUrl);
  }


  updateVehiculo(id:number,vehiculo:{id:number,placa:string,horaEntrada:string,tipoVehiculo:string}): Observable<any> {

    return this.httpClient.put(`${this.apiUserUrl}updateParking/${id}`,{id:vehiculo.id,placa:vehiculo.placa,horaEntrada:vehiculo.horaEntrada,tipoVehiculo:vehiculo.tipoVehiculo})
  }
}
