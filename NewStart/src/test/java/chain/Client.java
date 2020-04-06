package chain;

public class Client {

    public static void main(String[] args) {
        Handler handlerA = new Handler() {
            @Override
            public void process() {
                System.out.println("handler by a");
            }
        };


        Handler handlerB = new Handler() {
            @Override
            public void process() {
                System.out.println("handler by b");
            }
        };

        Handler handlerC = new Handler() {
            @Override
            public void process() {
                System.out.println("handler by c");
            }
        };

        handlerA.setNext(handlerB);
        handlerB.setNext(handlerC);
        handlerA.execute();
    }

}
