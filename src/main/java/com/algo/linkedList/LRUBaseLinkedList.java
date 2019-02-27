package com.algo.linkedList;

import java.util.Scanner;

/**
 * @Auther: yli
 * @Date: 2019/1/10 15:29
 * @Description:用单向链表实现LRU缓存淘汰算法
 */
public class LRUBaseLinkedList<T> {

    /**
     * 链表长度
     */
    private int length;


    /**
     * 头结点
     */
    private SNode<T> head;

    /**
     * 链表容量
     */
    private int capacity;


    public LRUBaseLinkedList() {
        this.length = 0;
        this.head = new SNode<>();
        this.capacity = 10;
    }

    public void add(T item){
        SNode preNode = findPreNode(item);
        if (preNode == null){
            if (length < capacity){
                insertNodeAtBegin(item);
            }else {
                deleteNodeAtEnd();
                insertNodeAtBegin(item);
            }
        }else {
            deleteNextNode(preNode);
            insertNodeAtBegin(item);
        }
    }

    /**
     * 查询data结点的前一个结点
     */
    private SNode findPreNode(T data){
        SNode node = head;
        while (node.next != null){
            //注意重写equals方法
            if (node.next.item.equals(data)){
                return node;
            }
            node = node.next;
        }
        return null;
    }


    /**
     * 删除node结点的后一个结点
     */
    private void deleteNextNode(SNode node){
        SNode tempNode = node.next;
        node.next = tempNode.next;
        tempNode = null;
        length--;
    }

    /**
     * 删除尾结点
     */
    private void deleteNodeAtEnd(){
        SNode tempNode = head;
        if (tempNode.next == null)
            return;
        while (tempNode.next.next != null){
            tempNode = tempNode.next;
        }
        SNode release = tempNode.next;
        tempNode.next = null;
        //方便GC
        release = null;
        length--;
    }

    /**
     * 在头结点后新增结点
     */
    private void insertNodeAtBegin(T item){
        SNode next = head.next;
        SNode n = new SNode(item, next);
        head.next = n;
        length++;
    }

    private void delete(T data){
        for (SNode node = head; node.next != null;){
            if (node.next.equals(data)){
                SNode nextNode = node.next;
                node.next = nextNode.next;
                nextNode.next = null;
                nextNode.item = null;
                return;
            }
        }
    }

    private void printAll(){
        SNode node = head.next;
        while (node != null){
            System.out.println(node.item + ",");
            node = node.next;
        }
    }

    private static class SNode<T>{
        T item;
        SNode<T> next;

        public SNode(T item, SNode<T> next) {
            this.item = item;
            this.next = next;
        }

        public SNode(){
            this.next = null;
        }
    }


    public static void main(String[] args){
        LRUBaseLinkedList<String> list = new LRUBaseLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            list.add(scanner.next());
            list.printAll();
        }
    }
}
