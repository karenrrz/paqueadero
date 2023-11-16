export interface VehiculoModel{
  id: number;
  placa: string;
  horaEntrada: string;
  horaSalida: Date;
  tipoVehiculo: string;
  isEditing?:boolean
}
