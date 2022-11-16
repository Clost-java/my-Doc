package com.clost.LinkList;

import java.util.Stack;

/**
 * @author clost
 * @date 2022/9/4 10:07
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建单链表
        SingleLinkListed singleLinkListed = new SingleLinkListed();

        //添加元素
        singleLinkListed.addByOrder(hero1);
        singleLinkListed.addByOrder(hero3);
        singleLinkListed.addByOrder(hero2);
        singleLinkListed.addByOrder(hero4);





        singleLinkListed.list();
        System.out.println("==================");
        singleLinkListed.reversePrint(singleLinkListed.getHead());



//        singleLinkListed.list();
//        singleLinkListed.delete(1);
//
//        System.out.println("删除后");
//        singleLinkListed.list();
    }

}


class SingleLinkListed {
    //初始化头结点
    private HeroNode head = new HeroNode(0, "", "");


    //添加
    public void add(HeroNode heroNode) {
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //按顺序添加
    public void addByOrder(HeroNode heroNode) {

        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {

                flag = true;
                break;
            }
            temp = temp.next;


        }
        if (flag) {
            System.out.println("编号已经存在,不能加入");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }


    }

    //根据newHeroNode.no来修改

    public void update(HeroNode newHeroNode) {
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到此节点");

                break;
            }
            if (temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
            }
            temp = temp.next;

        }

    }
    //删除节点
    public void delete(int no){
        HeroNode temp = head;

        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }
    }
    //显示链表，遍历
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //腾讯面试题（将一个单链表反转）
    public void reverse(HeroNode head){
    HeroNode newHead = new HeroNode(0,"","");
    HeroNode cur = head.next;
    HeroNode temp = null;

    while (cur != null){
        //存放反转前链表中当前元素的下一个结点的信息
        temp = cur.next;

        cur.next = newHead.next;
        newHead.next = cur;
        cur = temp;
    }

    head.next = newHead.next;

    }



    //百度面试题 链表逆序打印，不破坏原来链表
    public void reversePrint(HeroNode head){
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode curNode = head.next;

        while (true){
            if(curNode == null){
                break;
            }
            heroNodes.push(curNode);
            curNode = curNode.next;
        }

        while (!heroNodes.isEmpty()){
            System.out.println(heroNodes.pop());
        }
    }





    //合并两个单链表,合并后依旧有序
    public void merge(SingleLinkListed singleLinkListed1,SingleLinkListed singleLinkListed2){
        HeroNode newHead = new HeroNode(0,"","");
        HeroNode cur1 = singleLinkListed1.getHead().next;
        HeroNode cur2 = singleLinkListed2.getHead().next;
        HeroNode temp1 = null;
        HeroNode temp2 = null;


        if(singleLinkListed1.getHead().next == null && singleLinkListed2.getHead().next == null){
            System.out.println("链表为空不能合并");
            return;
        }

//        while (!(cur1 == null && cur2 == null)){
//
//            temp1 = cur1.next;
//            temp2 = cur2.next;
//            if(cur1.next.no > cur2.next.no){
//                cur1.next = newHead.next;
//                newHead.next = cur1;
//                cur2.next = cur1.next;
//                cur1.next = cur2;
//            }else {
//                cur2.next = newHead
//            }
//
//
//
//
//            if(cur1 != null){
//                cur1 = temp1;
//            }
//
//            if (cur2 != null){
//                cur2 = temp2;
//            }
//
//
//        }





    }

    public HeroNode getHead() {
        return head;
    }
}





//定义HeroNode，每个HeroNode对象就是一个节点

class HeroNode {

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }




    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}