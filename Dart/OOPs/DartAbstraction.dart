
/// Abstraction
///
/// Abstraction is the process of hiding the internal details of an application and showing only functionality to the user.
/// It is used to create a boundary between the application and the client programs.
///
/// Abstraction in Real life
/// => Your car is a great example of abstraction. You can start a car by turning the key or pressing the start button.
///    You do not need to know how to engine is getting started, what all components your car has. The car internal implmentation
///    and complex logic is completely hidden from the user.
///
///
abstract class Car {
  void turnOnCar();
  void turnOffCar();
  String getCarType();
}

class ManualCar extends Car {

  String carType = "Manual";

  @override
  void turnOnCar() {
    print('Turn on the manual car');
  }

  @override
  void turnOffCar() {
    print('Turn off the manual car');
  }

  @override
  String getCarType() {
    return this.carType;
  }
}

class AutomaticCar extends Car {
  String carType = "Automatic";

  @override
  void turnOnCar() {
    print('Turn on the automatic car');
  }

  @override
  void turnOffCar() {
    print('Turn off the automatic car');
  }

  @override
  String getCarType() {
    return this.carType;
  }
}
void main(){
  var car1 = ManualCar();
  var car2 = AutomaticCar();

  car1.turnOnCar();
  car1.turnOffCar();
  print(car1.getCarType());

  car2.turnOnCar();
  car2.turnOffCar();
  print(car2.getCarType());
}
/// The client program only know about the Car and the functions that the car provides.
/// The internal implementation details are hidden from the client program.
