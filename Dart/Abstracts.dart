abstract class Employee {
  void printDetails();
}

class Manager extends Employee {
  @override
  void printDetails() {
    print("I am a Manager");
  }
}

class Engineer extends Employee {
  @override
  void printDetails() {
    print("I am an Enginner");
  }
}
void main(List<String> args) {
  Manager mng = new Manager();
  Engineer eng = new Engineer();
  mng.printDetails();
  eng.printDetails();
}