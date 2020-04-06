package pointtooffer;

import java.util.HashMap;
import java.util.Map;

public class CopyWithRandomList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur!=null){
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }

     class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
