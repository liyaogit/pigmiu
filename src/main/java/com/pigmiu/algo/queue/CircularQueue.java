package com.pigmiu.algo.queue;

/**
 * @Auther: yli
 * @Date: 2019/1/11 11:52
 * @Description:循环队列
 * 解决数组队列的数据搬移问题
 * 写出无bug循环队列,重点关注边界,即队列满和队列空的判断问题
 */
public class CircularQueue {
    private String[] items;
    private int head;   //头指针
    private int tail;   //尾指针
    private int capacity;  //队列容量

    public CircularQueue(int capacity) {
        items = new String[capacity];
        head = 0;
        tail = 0;
        this.capacity = capacity;
    }

    public boolean enqueue(String data){
        if ((tail+1)%capacity == head){
            return false;
        }
        items[tail] = data;
        tail = (tail+1)%capacity;
        return true;
    }

    public String dequeue(){
        if (tail == head) return null;
        String data = items[head];
        head = (head+1)%capacity;
        return data;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(6);
        circularQueue.enqueue("1");
        circularQueue.enqueue("2");
        circularQueue.enqueue("3");
        circularQueue.enqueue("4");
        circularQueue.enqueue("5");
        circularQueue.enqueue("1");
        circularQueue.enqueue("2");

        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
    }
}
