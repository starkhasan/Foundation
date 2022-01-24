printnumber(int num){
  if(num <= 100){
    print(num++);
    printnumber(num);
  }
}

main() {
  printnumber(1);
}
