package com.sy.singleList;

/**
 * @ClassName HeroNode
 * @Description TODO a node in single linked list should include some information and a next node
 * @Author Shuyun
 **/
public class HeroNode {
    private String name;
    private HeroNode next;

    public HeroNode(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
}
