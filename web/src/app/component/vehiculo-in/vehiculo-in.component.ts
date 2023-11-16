import { Component } from '@angular/core';
import { VehiculoModel } from 'src/app/domain/vehiculo/vehiculo.model';
import { VehiculoService } from 'src/app/domain/vehiculo/vehiculo.service';

@Component({
    selector: 'app-vehiculo-in',
    templateUrl: './vehiculo-in.component.html',
    styleUrls: ['./vehiculo-in.component.scss']
})
export class VehiculoInComponent {
    listUser: VehiculoModel[] = [];
    placaSearch: string = '';


    constructor(private vehiculoService: VehiculoService) {}


    isEditing:boolean=false

    ngOnInit(): void {
        this.loadAllVehiculos();
    }

    loadAllVehiculos(): void {
        this.vehiculoService.getAllVehiculo().subscribe(data => {
            this.listUser = data;
            console.log(data);
        });

    }

    searchByPlaca(){

       this.listUser = this.placaSearch ?
        this.listUser.filter(vehicle => vehicle.placa.includes(this.placaSearch)) :
        [...this.listUser];

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

    updateVehiculo(user:any):void {

      this.vehiculoService.updateVehiculo(user.id,user).subscribe(updatedUser => {
            console.log('Hora de salida actualizada con éxito.');
            this.loadAllVehiculos()
            // Encuentra y actualiza el vehículo en la lista
            })

      console.log(user)
    }
      toggleEdit(user: any): void {
       user.isEditing = !user.isEditing;
      }

    }
