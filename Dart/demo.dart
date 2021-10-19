class Teacher {
  teachs() => print('He is teaching to student');
}

class PhysicsTeacher extends Teacher {
  profession() => print("He's profession is to teach physics");
}

void main(List<String> args) {
  PhysicsTeacher()
    ..teachs()
    ..profession();
}
