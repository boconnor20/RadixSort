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
  return 1;
return (int) (Math.log10(Math.abs(n))+1);
}
public static void merge(SortableLinkedList original,SortableLinkedList[]buckets){
  for (int i=0; i<buckets.length; i++){
    original.extend(buckets[i]);
  }
}
public static void radixSortSimpleZ(SortableLinkedList data){
  SortableLinkedList[]buckets = new SortableLinkedList[10];
  for (int i=0; i<10; i++){
    buckets[i] = new SortableLinkedList();
  }
  int current=1;
  for (int i=0; i<current;i++){
    while(data.size()>0){
      if (length(data.get(0))>current){
        current=length(data.get(0));

      }
      int element=data.get(0);
      int digit= nth(element,i);
      buckets[digit].add(element);
      data.remove(0);
    }
    merge(data,buckets);
  }
}
  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[]buckets = new SortableLinkedList[10];
    for (int i=0; i<10; i++){
      buckets[i] = new SortableLinkedList();
    }
    //find max digits
    int max=0;
    while(data.size()!=0){
      int tempmax=data.get(0);
      if (length(tempmax)>max){
        max=length(tempmax);
      }
        buckets[nth(tempmax,0)].add(tempmax);
        data.remove(0);
      }

      merge(data, buckets);
      for (int i=0; i<max;i++){
        while (data.size()!=0){
          int temp=data.get(0);
          buckets[nth(temp,i)].add(temp);
          data.remove(0);
        }
        merge(data, buckets);
      }

  }

public static void radixSort(SortableLinkedList data){
  SortableLinkedList whole= new SortableLinkedList();
  SortableLinkedList negative= new SortableLinkedList();

  for (int i=0; i<data.size(); i++){
    if(data.get(i)>=0){
         whole.add(data.remove(i));
        }
        else{
          negative.add(data.remove(i) * -1);
  }
}
    radixSortSimple(whole);
    radixSortSimple(negative);
    

    //add from greatest abs to smallest
    for (int i = negative.size() - 1; i >= 0; i--) {
      data.add(negative.get(i) * -1);
    }

    data.extend(whole);
  }

//public static void main(String[] args) {
  //System.out.println(nth(123,1));
//System.out.println(  nth(-123,1));
//}
}
