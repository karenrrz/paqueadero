import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiculoInComponent } from './vehiculo-in.component';

describe('VehiculoInComponent', () => {
  let component: VehiculoInComponent;
  let fixture: ComponentFixture<VehiculoInComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VehiculoInComponent]
    });
    fixture = TestBed.createComponent(VehiculoInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
