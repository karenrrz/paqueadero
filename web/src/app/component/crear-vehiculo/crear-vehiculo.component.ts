import { Component } from '@angular/core';
import { VehiculoModel } from 'src/app/domain/vehiculo/vehiculo.model';
import { VehiculoService } from 'src/app/domain/vehiculo/vehiculo.service';

@Component({
  selector: 'app-crear-vehiculo',
  templateUrl: './crear-vehiculo.component.html',
  styleUrls: ['./crear-vehiculo.component.scss']
})
export class CrearVehiculoComponent {

  listUser: VehiculoModel[] = [];
  nuevoVehiculo: { id: number; placa: string; horaEntrada: string ; tipoVehiculo: string} = { id: 0, placa: '', horaEntrada: '', tipoVehiculo: '' };

  constructor(private vehiculoService: VehiculoService) {}

  ngOnInit(): void {
    this.obtenerTodosLosCrear();
  }

  obtenerTodosLosCrear() {
    this.vehiculoService.getAllVehiculo().subscribe(
      (data: VehiculoModel[]) => {
        console.log(data);
        this.listUser = data;
      },
    );
  }

  registrarNuevoVehiculo() {
    this.vehiculoService.crearNuevoVehiculo(this.nuevoVehiculo).subscribe(
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
