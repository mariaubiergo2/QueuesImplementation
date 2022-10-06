public class QueueImplementation<E> implements Queue<E> {
    int n; //numero d'elements a la cua
    int maxLen;
    E[] v; //el vector on aniran els elements de la cua

    public QueueImplementation(int len){
        this.n=0;
        this.maxLen = len;
        this.v = (E[]) new Object[len];
    }

    @Override
    public void push(E e) throws FullQueueException{
        if (isFull())
            throw new FullQueueException();
        else{
            v[n]= e;
            n+=1;
        }
    }

    @Override
    public E pop() throws EmptyQueueException{
        if (isEmpty())
            throw new EmptyQueueException();
        E popedElement = v[0];
        rearrange(v);
        n--;
        return popedElement;
    }

    @Override
    public int size() {
        return n;
    }

    private boolean isFull(){
        return (n==maxLen);
    }

    private boolean isEmpty(){
        return (n==0);
    }

    private void rearrange(E[] v){
        for (int i=0; i<v.length-1; i++){
            v[i] = v[i+1];
        }
    }


}
