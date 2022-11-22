///What is prime number
///For integer to be prime it must be greater than 1, and the only integers that divide into it exactly are 1 and itself such as 3 and 13 etc.
///
///Why is 1 not a prime number?
///The short answer is that if 1 were prime, then numbers would not have unique prime factorizations
///
///Why isn't 1 a prime number and also why isn't 0?
///Both of these have to do with what is known as the Fundamental Theorem of Arithmetic, which states that every positive integer
///can be written uniquely (up to order) as a product of prime number.
///
///
///Here's why this prevents 0 and 1 from being prime numbers:
///1. We can't have 0 as a prime number becuase 0 will never show up in the prime factorization of any positive integer.
///2. we cannot have 1 as a primce number because this would break the uniquely part of the Fundamental Theorem of Arithmetic.
///Ex -
void main(){
  var number = 0;
  if(checkPrimeNumberIterative(number: number)){
    print('Number is prime');
  }else{
    print('Number is not prime');
  }
}

bool checkPrimeNumberRecursive({required int number}){
  return false;
}

bool checkPrimeNumberIterative({required int number}){
  if(number <= 1){
    return false;
  }else{
    for(var i=2;i<=number/2;i++){
      if(number%i == 0){
        return false;
      }
    }
    return true;
  }
}