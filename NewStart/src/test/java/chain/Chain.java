package chain;

import java.util.List;

public class Chain {
    private List<ChainHandler>chainHandlers;

    public void setChainHandlers(List<ChainHandler> chainHandlers) {
        this.chainHandlers = chainHandlers;
    }

    private int index = 0;

    public void process(){
        if(index>=chainHandlers.size())
            return;

        chainHandlers.get(index++).process();
    }
}
