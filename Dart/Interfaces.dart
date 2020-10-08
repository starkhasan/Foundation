class Employee {
  void showEmpInfo() {}
}

class Manager implements Employee {
  @override
  void showEmpInfo() {
    print("I Am Manager");
  }
}

void main() {
  Manager mng = new Manager();
  mng.showEmpInfo();
}
