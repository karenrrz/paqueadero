import { Component } from '@angular/core';
import { CrearModel } from "../../domain/crear-vehiculo/crearVehiculo.model";
import { CrearVehiculoService } from "../../domain/crear-vehiculo/crearVehiculo.service";

@Component({
  selector: 'app-crear-vehiculo',
  templateUrl: './crear-vehiculo.component.html',
  styleUrls: ['./crear-vehiculo.component.scss']
})
export class CrearVehiculoComponent {

  listUser: CrearModel[] = [];
  nuevoVehiculo: { id: number; placa: string; horaEntrada: string ; tipoVehiculo: string} = { id: 0, placa: '', horaEntrada: '', tipoVehiculo: '' };

  constructor(private crearService: CrearVehiculoService) {}

  ngOnInit(): void {
    this.obtenerTodosLosCrear();
  }

  obtenerTodosLosCrear() {
    this.crearService.postAllCrear().subscribe(
      (data: CrearModel[]) => {
        console.log(data);
        this.listUser = data;
      },
    );
  }

  registrarNuevoVehiculo() {
    this.crearService.crearNuevoVehiculo(this.nuevoVehiculo).subscribe(
      (response) => {
        console.log('Vehículo registrado exitosamente', response);
        // Refresh the list after successful registration if needed
        this.obtenerTodosLosCrear();
      },
      (error) => {
        console.error('Error al registrar vehículo', error);
      }
    );
  }
}
