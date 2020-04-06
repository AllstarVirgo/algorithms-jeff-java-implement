package chain;

public abstract class Handler {
    private Handler next;

    public void setNext(Handler next){
        this.next = next;
    }

    public void execute(){
        process();
        if(next!=null){
            next.execute();
        }
    }

    public abstract void process();
}
