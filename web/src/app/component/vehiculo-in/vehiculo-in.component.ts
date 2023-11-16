import { Component } from '@angular/core';
import { UserModel } from "../../domain/vehiculo-in/vehiculo.model";
import { VehiculoService } from "../../domain/vehiculo-in/vehiculo.service";

@Component({
    selector: 'app-vehiculo-in',
    templateUrl: './vehiculo-in.component.html',
    styleUrls: ['./vehiculo-in.component.scss']
})
export class VehiculoInComponent {
    listUser: UserModel[] = [];
    placaSearch: string = '';

    constructor(private vehiculoService: VehiculoService) {}

    ngOnInit(): void {
        this.loadAllVehiculos();
    }

    loadAllVehiculos(): void {
        this.vehiculoService.getAllVehiculo().subscribe(data => {
            this.listUser = data;
            console.log(data);
        });
    }

    searchByPlaca(): void {
        if (this.placaSearch) {
            this.vehiculoService.getVehiculoByPlaca(this.placaSearch).subscribe(data => {
                this.listUser = data ? [data] : [];
            });
        } else {
            this.loadAllVehiculos();
        }
    }

    horaSalida(id: number): void {
        this.vehiculoService.horaSalida(id).subscribe(updatedUser => {
            console.log('Hora de salida actualizada con éxito.');

            // Encuentra y actualiza el vehículo en la lista
            const index = this.listUser.findIndex(user => user.id === id);
            if (index !== -1) {
                this.listUser[index] = updatedUser;
            }

            // Elimina el vehículo de la lista después de actualizar la hora de salida
            // Esto asume que la operación de horaSalida en el servidor no elimina el vehículo, solo actualiza la hora de salida
            // Si la operación en el servidor elimina el vehículo, entonces debes quitar esta línea
            // y dejar que la lista se actualice con loadAllVehiculos() en el próximo paso.
            this.listUser.splice(index, 1);
        });
    }
    deleteVehiculo(id: number): void {
        this.vehiculoService.deleteVehiculo(id).subscribe(() => {
            this.loadAllVehiculos();
        });
    }

    }
