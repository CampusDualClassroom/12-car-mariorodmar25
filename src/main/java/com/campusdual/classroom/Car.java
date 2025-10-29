package com.campusdual.classroom;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Car {
    public String brand;
    public String model;
    public static final int MAX_SPEED = 120;
    public String fuel;
    public int speedometer;
    public int tachometer;
    public String gear = "N";
    public boolean reverse = false;
    public int wheelsAngle = 0;

    public Car(String brand, String model, String fuel) {
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    public Car() {
        this.brand = "Citroën";
        this.model = "Xsara";
        this.fuel = "Diesel";
    }

    public void start() {
        if (this.tachometer == 0) {
            this.tachometer = 1000;
            System.out.println("Vehículo encendido");
        } else {
            System.out.println("Vehículo ya está encendido");
        }
    }

    public void stop() {
        if (this.speedometer == 0) {
            this.tachometer = 0;
            System.out.println("Vehículo apagado");
        } else {
            System.out.println("No se puede apagar el vehículo. Primero tiene que estar detenido");
        }
    }

    public void accelerate() {
        if (isTachometerGreaterThanZero()) {
            if (speedometer < MAX_SPEED) {
                speedometer += 10;
                System.out.println("Vehiculo acelerando. Velocidad " + speedometer);
            } else {
                speedometer = MAX_SPEED;
                System.out.println("Velocidad máxima alcanzada. Velocidad " + speedometer);
            }
        } else {
            System.out.println("No se puede acelerar, vehículo apagado");
        }
    }

    public void brake() {
        if (isTachometerGreaterThanZero()) {
            if (speedometer > 0) {
                speedometer-=10;
                System.out.println("Vehiculo frenando. Velocidad " + speedometer);
            } else {
                System.out.println("El vehículo no puede frenar más");
            }
        } else {
            System.out.println("El vehículo no puede frenar ya está apagado");
        }
    }

    public void turnAngleOfWheels(int angle) {
        int newAngle = wheelsAngle + angle;
        if (newAngle >45){
            wheelsAngle = 45;
        } else if (newAngle<-45) {
            wheelsAngle = -45;
        }else {
            wheelsAngle = newAngle;
        }
    }

    public String showSteeringWheelDetail() {

        return "Wheel angle " + wheelsAngle + "ª";
    }

    public boolean isReverse() {

        return reverse;
    }

    public void setReverse(boolean reverse) {
        if (speedometer == 0) {
            this.reverse = reverse;
            if (reverse) {
                gear = "R";
                System.out.println("Marcha atrás activada");
            } else {
                gear = "N";
                System.out.println("La marcha atrás no está activada");
            }
        } else {
            System.out.println("No se puede poner la marcha atrás porque el coche está en movimiento");
        }
    }


  public void showDetails (){
      System.out.println("=== Detalles del coche ===");
      System.out.println("Marca/Modelo: " + brand + " " + model);
      System.out.println("Combustible: " + fuel);
      System.out.println("Velocidad: " + speedometer + " km/h");
      System.out.println("Tacómetro: " + tachometer + " rpm");
      System.out.println("Marcha: " + gear + (reverse ? " (atrás)" : ""));
      System.out.println("Ángulo volante: " + wheelsAngle + "°");
      System.out.println("==========================");
    }
    public boolean isTachometerGreaterThanZero() {

        return tachometer > 0;
    }

    public boolean isTachometerEqualToZero() {

        return tachometer == 0;
    }

    public static void main(String[] args) {

    }


}
