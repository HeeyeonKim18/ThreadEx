package org.example.skiplist;

public class Main {
    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(4);
        skipList.insert(7);
        skipList.insert(15);
        skipList.insert(28);
        skipList.insert(40);
        skipList.insert(53);
        skipList.delete(4);
        System.out.println(skipList.search(15));
        System.out.println(skipList.search(40));
    }
}
