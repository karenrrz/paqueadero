import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { UserModel } from "./vehiculo.model";

@Injectable({ providedIn: 'root' })
export class VehiculoService {
  private apiUserUrl = 'http://localhost:8080/api/parking/';

  constructor(private httpClient: HttpClient) {}

  getAllVehiculo(): Observable<UserModel[]> {
    return this.httpClient.get<UserModel[]>(this.apiUserUrl);
  }

  getVehiculoByPlaca(placa: string): Observable<UserModel> {
    const url = `${this.apiUserUrl}?placa=${placa}`;
    return this.httpClient.get<UserModel>(url);
  }
    horaSalida(id: number): Observable<UserModel> {
        const url = `${this.apiUserUrl}${id}`;
        const nuevaHoraSalida = new Date().toISOString();

        // Enviar la nueva hora de salida en el cuerpo de la solicitud PUT
        return this.httpClient.put<UserModel>(url, { horaSalida: nuevaHoraSalida });
    }
    deleteVehiculo(id: number): Observable<void> {
        const url = `${this.apiUserUrl}/${id}`;
        return this.httpClient.delete<void>(`http://localhost:8080/api/parking/${id}`);
    }
}
