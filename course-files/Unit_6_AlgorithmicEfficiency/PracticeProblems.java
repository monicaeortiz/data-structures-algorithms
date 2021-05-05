public class PracticeProblems{
  public static void main(String[] args){
    long startTime, estimatedTime;

    startTime = System.nanoTime();
    listPrimes(1000);
    estimatedTime = System.nanoTime() - startTime;
    System.out.println();
    System.out.println("listPrimes(1000) = " + (double) estimatedTime/1000000 + " ms");

    startTime = System.nanoTime();
    sieveOfEratosthenes(1000);
    estimatedTime = System.nanoTime() - startTime;
    System.out.println();
    System.out.println("sieveOfEratosthenes(1000) = " + (double) estimatedTime/1000000 + " ms");

    startTime = System.nanoTime();
    listPrimes(1000000);
    estimatedTime = System.nanoTime() - startTime;
    System.out.println();
    System.out.println("listPrimes(1000000) = " + (double) estimatedTime/1000000 + " ms");

    startTime = System.nanoTime();
    sieveOfEratosthenes(1000000);
    estimatedTime = System.nanoTime() - startTime;
    System.out.println();
    System.out.println("sieveOfEratosthenes(1000000) = " + (double) estimatedTime/1000000 + " ms");

    startTime = System.nanoTime();
    listPrimes(10000000);
    estimatedTime = System.nanoTime() - startTime;
    System.out.println();
    System.out.println("listPrimes(10000000) = " + (double) estimatedTime/1000000 + " ms");

    startTime = System.nanoTime();
    sieveOfEratosthenes(10000000);
    estimatedTime = System.nanoTime() - startTime;
    System.out.println();
    System.out.println("sieveOfEratosthenes(10000000) = " + (double) estimatedTime/1000000 + " ms");

  }

  public static void listPrimes(int upperBound){
    int value = 0;
    for(int i = 2; i <= upperBound; i++){
      if(isPrime(i)){
        value = i;
        // System.out.println(i);
      }
    }
    //System.out.println(lst);
  }

  public static boolean isPrime(int n){
    // check all nums 2 - sqrt(n)
    for(int i = 2; i <= (int)Math.sqrt(n); i++){
      if(n%i == 0){return false;}
    }
    return true;
  }

  public static void sieveOfEratosthenes(int num){
    boolean[] isNotPrime = new boolean[num];
    int value = 0;

    for (int i = 2; i< Math.sqrt(num); i++) {
       if(!isNotPrime[i]) {
          for(int j = i*i; j < num; j += i) {
             isNotPrime[j] = true;
          }
       }
    }
    for (int i = 2; i< isNotPrime.length; i++) {
       if(!isNotPrime[i]) {
          value = i;
          // System.out.println(i);
       }
    }
  }
}
