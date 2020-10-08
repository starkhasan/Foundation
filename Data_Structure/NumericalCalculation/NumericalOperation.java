import java.math.BigInteger;
class NumericalOperation {
    
    public boolean isEven(int _number){
        return _number%2==0 ? true :false;
    }

    public boolean isPalindrome(Object _number){
        boolean palindromeFlag=false;
        try {
            if(String.valueOf(_number).length()<3){
                throw new Exception("Invalid Number");
            }else{
                if(_number.getClass() == String.class){
                    String stringVariable = String.valueOf(_number);
                    String tempString = "";
                    for(int i=stringVariable.length()-1;i>=0;i--){
                        tempString = tempString + String.valueOf(stringVariable.charAt(i));
                    }
                    palindromeFlag = stringVariable.equals(tempString) ? true : false;
                }else if(_number.getClass() == Integer.class){
                    int intVariable = (int)_number;
                    int _temp=intVariable;
                    int _x=0,_y=0;
                    while(intVariable>0){
                        _y = intVariable%10;
                        _x = _x*10 + _y;
                        intVariable = intVariable/10;
                    }
                    palindromeFlag =  _x==_temp ? true :false;
                }
            }
        } catch (Exception e) {
            palindromeFlag=false;
        }
        return palindromeFlag;
    }

    public boolean isPrime(int _number){
        boolean primeFlag=true;
        for(int i=2;i<=_number/2;i++){
            if(_number%i==0){
                primeFlag=false;
                break;
            }
        }
        return primeFlag;
    }
    public String type(Object _number){
        String type="";
        if(_number.getClass() == String.class){
            type = _number.getClass().getName();
        }else if(_number.getClass() == Integer.class){
            type = _number.getClass().getName();
        }else if(_number.getClass() == Float.class){
            type = _number.getClass().getName();
        }else if(_number.getClass() == Double.class){
            type = _number.getClass().getName();
        }else if(_number.getClass() == Long.class){
            type = _number.getClass().getName();
        }else if(_number.getClass() == Character.class){
            type = _number.getClass().getName();
        }else if(_number.getClass() == Byte.class){
            type = _number.getClass().getName();
        }else if(_number.getClass() == Boolean.class){
            type = _number.getClass().getName();
        }else if(_number.getClass() == BigInteger.class){
            type = _number.getClass().getName();
        }else if(_number.getClass() ==  Short.class){
            type = _number.getClass().getName();
        }
        return type;
    }

    public String isString(String _input){
        String type = _input.getClass().getName();
        return type;
    }
    
    public int[] sort(int ar[]){
        int ar_length = ar.length;
        int key=0;
        for(int j=1;j<ar_length;j++){
            key=ar[j];
            int i=j-1;
            while(i>=0 && ar[i]>key){
                ar[i+1]=ar[i];
                i-=1;
            }
            ar[i+1]=key;
        }
        return ar;
    }

    public int[] reverse(int ar[]){
        int ar_length = ar.length;
        int[] temp=new int[ar_length];
        int k=0;
        for(int i=ar_length-1;i>=0;i--){
            temp[k]=ar[i];
            k++;
        }
        return temp;
    } 

    public boolean isarmstrong(Object _number){
        boolean armstrongFlag = false;
        if(_number.getClass() == String.class){
            armstrongFlag = false;
        }else if(_number.getClass() == Integer.class){
            String number  = String.valueOf(_number);
            int checkedNumber = 0;
            for(int i=0;i<number.length();i++){
                int finalValue = 1;
                int tempNumber = Integer.parseInt(String.valueOf(number.charAt(i)));
                for(int j=0;j<number.length();j++){
                    finalValue = finalValue * tempNumber;
                }
                checkedNumber = checkedNumber + finalValue;
            }
            armstrongFlag =  checkedNumber==Integer.parseInt(number) ? true : false;
        }
        return armstrongFlag;
    }

    public String reverseString(String _input){
        String temp="";
        for(int i=_input.length()-1;i>=0;i--){
            temp = temp + String.valueOf(_input.charAt(i));
        }
        return temp;
    }

    public String sortString(String _input){
        char chr[] = _input.toCharArray();
        int int_ar[] = new int[_input.length()];
        for(int i=0;i<_input.length();i++){
            int_ar[i]=chr[i];
        }
        int_ar = sort(int_ar);
        for(int i=0;i<_input.length();i++){
            chr[i]=(char)int_ar[i];
        }
        String temp = new String(chr);
        return temp;
    }

    public boolean isAnagram(String _input1,String _input2){
        boolean anaramFlag=false;
        _input1 = sortString(_input1);
        _input2 = sortString(_input2);
        if(_input1.equals(_input2)){
            anaramFlag=true;
        }else{
            anaramFlag=false;
        }
        return anaramFlag;
    }

}