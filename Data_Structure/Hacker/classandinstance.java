import java.util.*;
class Person {
    private int age;	
  
	public Person(int initialAge)
  {
    age=initialAge;
    if(age<0)
    {
      age=0;
      System.out.println("Age is not valid, setting age to 0.");
    } 
  		// Add some more code to run some checks on initialAge
	}

	public void amIOld()
  {
    if(age<13)
      System.out.println("You are young.");
      else if(age>=13 & age<18)
        System.out.println("You are a teenager.");
    else
  		// Write code determining if this person's age is old and print the correct statement:
        System.out.println("You are old.");
	}

	public void yearPasses()
  {
    age+=1;
  		// Increment this person's age.
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int age = sc.nextInt();
			Person p = new Person(age);
			p.amIOld();
			for (int j = 0; j < 3; j++) {
				p.yearPasses();
			}
			p.amIOld();
			System.out.println();
        }
		sc.close();
    }
}