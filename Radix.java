public class Radix{
public static int nth(int n, int col){
  /*get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
  nth(123,1) -> 2
  nth(-123,1) -> 2
  nth(123,2) -> 1
  nth(-123,2) -> 1
  */
  int x=Math.abs(n/(int)(Math.pow(10,col)));
  return x %10;
}

public static int length(int n){
/*return the number of digits in n.
length(0) -> 1
length(15) -> 2
length(-10) -> 2
length(5112) -> 4*/
if (n==0)
  return 0;
return (int) (Math.log10(Math.abs(n))+1);
}
public static void merge(SortableLinkedList original,SortableLinkedList[]buckets){
  for (int i=0; i<buckets.length; i++){
    original.extend(buckets[i]);
  }
}
public static void main(String[] args) {
  System.out.println(nth(123,1));
System.out.println(  nth(-123,1));
}
}
