package com.sy.singleList;

/**
 * @ClassName SingleRankList
 * @Description TODO A hero rank list with single linked list, should include a head node and the describe of size of list.
 * @Author Shuyun
 **/
public class SingleRankList {
    private HeroNode head;//头节点
    private int size;//链表长度

    /**
     * 在构造方法中初始化头节点和链表长度
     */
    public SingleRankList(){
        System.out.println("==========================武林群英擂台赛开始啦！==========================");
        this.head=new HeroNode("");
        this.size=0;
    }

    public int getSize(){
        return size;
    }

//---------------------------------------------------------插入相关-----------------------------------------------------

    /**
     * 争当擂主（在链表头部插入节点：1.链表为空，头节点的next指向插入节点；2.链表不为空，插入节点的next指向第一个节点，头节点的next指
     * 向插入节点;3.链表长度+1）
     * @param name
     */
    public void beFirst(String name){
        HeroNode addNode=new HeroNode(name);
        if(head.getNext()==null){
            head.setNext(addNode);
        }else{
            HeroNode firstNode=head.getNext();
            addNode.setNext(firstNode);
            head.setNext(addNode);
        }
        this.size++;
        System.out.println("忽而惊雷平地起，电光火石间，再回头，胜负已分，尘埃落定");
    }

    /**
     * 挑战排位（在链表任意位置插入节点：1.遍历列表找到插入位置；2.插入位置前的节点的next指向插入节点；3.插入节点的next指向插入位置后
     * 的节点;4.链表长度+1）
     * @param num 链表位置
     */
    public void challenge(String name,int num){
        if(num>size)
            System.out.println("输入错误，目前只有"+size+"人来打擂");
        else {
            HeroNode addnode = new HeroNode(name);
            int i = 1;
            HeroNode foreNode = head;
            HeroNode originalNode = head.getNext();
            while (i < num) {
                foreNode = foreNode.getNext();
                originalNode = originalNode.getNext();
                i++;
            }
            foreNode.setNext(addnode);
            addnode.setNext(originalNode);
            size++;
            System.out.println(name + "已成功取代第" + num + "名的位置");
        }
    }


    /**
     * 默默吃瓜（在链表尾部插入节点：1.遍历链表找到最后一个节点；2.最后一个节点的next指向插入节点;3.链表长度+1）
     * @param name
     */
    public void beLast(String name){
        HeroNode addNode=new HeroNode(name);
        HeroNode lastNode=head;
        int i=1;
        while (i<size){
            lastNode=lastNode.getNext();
            i++;
        }
        lastNode.setNext(addNode);
        size++;
        System.out.println(name+"已位于链表尾部，默默吃瓜");
    }

    //---------------------------------------------------------删除相关--------------------------------------------------

    /**
     * 退赛(删除节点：1.链表判空；2.链表不为空时，找到删除节点的位置；3.删除节点在最后时，删除节点前的节点的next指向null;4.删除节点在
     * 其他位置时，删除节点前的节点的next指向删除节点后的节点，删除节点的next指向null；5.删除链表长度-1)
     * @param name
     */
    public void exist(String name){
        if(size==0)
            System.out.println("还没有英雄来打擂哦，快来试一试吧~");
        else{
            int i=1;
            HeroNode foreNode=head;
            HeroNode delNode=head.getNext();
            while (i<size){
                if(name.equals(delNode.getName()))
                    break;
                delNode=delNode.getNext();
                foreNode=foreNode.getNext();
                i++;
            }
            foreNode.setNext(delNode.getNext());
            if(delNode.getNext()!=null)
                delNode.setNext(null);
            size--;
           System.out.println(name+"已经退赛");
        }

    }

    //---------------------------------------------------------查询相关--------------------------------------------------

    /**
     * 查看擂主（查询第一个节点：1.链表判空；2.返回头节点的next指向节点）
     */
    public void checkFirst() {
        if(this.head.getNext()!=null)
            System.out.println("当前擂主是："+head.getNext().getName());
        else
            System.out.println("还没有英雄来打擂哦，快来试一试吧~");
    }


    /**
     * 查看排名第n位的英雄（查询链表中指定位置的节点：1.链表判空；2.从头节点开始遍历到制定位置，返回）
     * @param rank
     * @return
     */
    public void getHero(int rank){
        if(rank>size)
            System.out.println("查询失败");
        else {
            int no = 1;
            HeroNode temp = this.head;
            while (rank<no) {
                temp = temp.getNext();
                no++;
            }
            System.out.println("排名第" + rank + "位的英雄是：" + temp.getName());
        }
    }

    /**
     * 查看榜单(遍历链表)
     */
    public void showRank(){
        int i=1;
        HeroNode heroNode=this.head;
        while(heroNode.getNext()!=null) {
            System.out.println("No."+i+": "+heroNode.getNext().getName());
            i++;
            heroNode=heroNode.getNext();
        }
    }

    //---------------------------------------------------------修改相关--------------------------------------------------

    /**
     * 换马甲（修改节点信息）
     */
    public void updateName(String name,String newName){
        int i=1;
        HeroNode heroNode=this.head;
        boolean flag=false;
        while(heroNode.getNext()!=null){
            heroNode=heroNode.getNext();
            if(heroNode.getName().equals(name)) {
                heroNode.setName(newName);
                flag=true;
                System.out.println("英雄" + name + "已改名为：" + newName);
                break;
            }
            i++;
        }
        if(!flag)
            System.out.println("不在榜上哦");
    }
}
