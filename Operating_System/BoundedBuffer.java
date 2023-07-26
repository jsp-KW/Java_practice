public class BoundedBuffer<E> {
    ArrayQueue<E> aq; // bounded buffer is implemented in aq
    /* Constructor*/
    public BoundedBuffer(int n) {
        aq= new ArrayQueue<E>(n);// n의 크기인 빈 버퍼 생성
    }
    /*데이터 v를 삽입  */
    public synchronized void produce(E v) {
        while (aq.isFull()) 
            try { wait(); }//버퍼가 꽉차면, 대기상태로 들어감
            catch (InterruptedException e) {}
        aq.put(v);
        notifyAll(); // 작업이 끝났음을 다른 스레드에게 알리기 위해
    }
    /*버퍼에서 요소를 제거하고 반환 */   
    public synchronized E consume() {
        while (aq.isEmpty())
            try { wait(); }// 버퍼가 꽉차면, 대기상태
            catch (InterruptedException e) {}
        E item= aq.take(); // 요소 제거후 반환
        notifyAll(); // 작업이 끝났음을 알린다.
        return item;
    }
}
