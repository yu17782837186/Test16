package cn.dataStructure2.com;

public interface HeadLinked {

    //头插法
    void addFirst(Object data);

    //尾插法
    void addLast(Object data);

    //任意位置插入,第一个数据节点为0号下标
    boolean addIndex(int index,Object data);

    //查找是否包含关键字key是否在单链表当中
    boolean contains(Object key);

    //删除第一次出现关键字为key的节点
    Object remove(Object key);

    //删除所有值为key的节点
    void removeAllKey(Object key);

    //得到单链表的长度
    int getLength();

    //打印
    void display();

    //清空
    void clear();

}
