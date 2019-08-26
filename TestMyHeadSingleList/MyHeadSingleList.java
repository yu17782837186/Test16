package cn.dataStructure2.com;

public class MyHeadSingleList implements HeadLinked {
    //带头节点的单链表
    class Node {
        private Object data;
        private Node next;

        public Node() {

        }

        public Node(Object data) {
            this.data = data;
        }
    }
    private Node head;

    public MyHeadSingleList() {
        //让这个头节点自己存自己的地址
        this.head = new Node();
        this.head.next = this.head;
    }

    @Override
    public void addFirst(Object data) {
        //这个头节点的next存放的是自己的地址，让新的节点的next等于head
        //的next,再把新节点的地址给head的next,每添加一个节点就如此循环
        Node node = new Node(data);
        node.next = head.next;
        head.next = node;
    }

    @Override
    public void addLast(Object data) {
        Node p = this.head;
        //找到头节点的前一个节点
        while(p.next != head) {
            p = p.next;
        }
        Node node = new Node(data);
        node.next = head;
        p.next = node;
    }
    private void checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new RuntimeException("下标越界异常："+index);
        }
    }
    private Node pre(int index) {
        checkIndex(index);
        Node p = this.head;
        int i = 0;
        while(i < index) {
            p = p.next;
            i++;
        }
        return p;
    }
    @Override
    public boolean addIndex(int index, Object data) {
        Node p = pre(index);
        Node node = new Node(data);
        Node tmp = p.next;
        node.next = tmp;
        p.next = node;
        return true;
    }

    @Override
    public boolean contains(Object key) {
        Node p = head;
        while(p.next != head) {
            p = p.next;
            if (p.data == key) {
                return true;
            }
        }
        return false;
    }

    private Node searchPre(Object key) {
        Node p = head;
        while(p.next != head) {
            if (p.next.data == key) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
    @Override
    public Object remove(Object key) {
        Node p = searchPre(key);
        Object oldData;
        if (p == null) {
            throw new RuntimeException("不存在key!!!");
        }
        Node tmp = p.next;
        oldData = tmp.data;
        p.next = tmp.next;
        return oldData;
    }

    @Override
    public void removeAllKey(Object key) {
        //定义两个节点，一个指向头，一个指向头的下一个节点
        Node p = head;
        Node cur = head.next;
        //先判断这个cur是不是头节点
        while(cur != head) {
            //如果第0个节点的值等于key，删除这个节点，并且把cur指向新的第0个节点
            if (cur.data == key) {
                p.next = cur.next;
                cur = p.next;
            }else {
                //不是的话，先让p指向cur，再让cur指向cur的next
                p = cur;
                cur = cur.next;
            }
        }
    }

    @Override
    public int getLength() {
        Node p = this.head;
        int count = 0;
        while(p.next != head) {
            p = p.next;
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node p = this.head;
        if (p == null) {
            throw new RuntimeException("没有节点！！！！");
        }
        while(p.next != head) {
            p = p.next;
            System.out.print(p.data+" ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(head.next != head) {
            Node p = head.next;
            head.next = p.next;
        }
    }
}
