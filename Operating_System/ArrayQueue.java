public class ArrayQueue <E>{
    private E[] b; // queue 배열
    private int n; // queue 에 저장된 요소의 개수를 저장하는 변수
    private int h; // queue 배열의 인덱스 정보를 저장하는 변수

    /*생성자
    * 크기가 최대 s인 빈 큐를 생성함.
    */
    public ArrayQueue(int s) {
        b= (E[])new Object[s];
    }

    /*큐가 비어있는지 체크하는 함수*/
    public boolean isEmpty () {return n==0;}

    /*큐가 가득 차있는지 체크하는 함수*/
    public boolean isFull() {return  n==b.length;}
    /*큐에 요소 추가*/
    public void put(E e) {
        if(n==b.length)
            throw new RuntimeException("Queue full");
        b[(h+n)%b.length] =e;
        n= n+1;
    }

    /*큐에 데이터 첫번째 요소를 반환*/
    public E peek() {
        if(n==0)
            throw new RuntimeException("Queue empty");
        return b[h];
    }
    /*큐에 첫번째 데이터를 제거하고 반환.*/
    public E take() {
        if(n==0)
            throw new RuntimeException("Queue empty");
        E e = b[h] ;
        h= (h+1)%b.length; //논리적인 삭제
        n= n-1;
        return e;
    }
}
