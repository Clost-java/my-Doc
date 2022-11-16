package com.clost.LinkList;

/**
 * @author clost
 * @date 2022/9/5 22:36
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        System.out.println("双向链表测试");
        //创建节点
        HeroNode1 hero1 = new HeroNode1(1, "宋江", "及时雨");
        HeroNode1 hero2 = new HeroNode1(2, "卢俊义", "玉麒麟");
        HeroNode1 hero3 = new HeroNode1(3, "吴用", "智多星");
        HeroNode1 hero4 = new HeroNode1(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改
        HeroNode1 newHeroNode = new HeroNode1(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表是");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.delete(4);
        System.out.println("删除后的链表");
        doubleLinkedList.list();
    }

}


class DoubleLinkedList {
    private HeroNode1 head = new HeroNode1(0, "", "");

    //添加
    public void add(HeroNode1 heroNode1) {
        HeroNode1 temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode1;
        heroNode1.pre = temp;
    }

    //修改
    public void update(HeroNode1 heroNode1) {
        HeroNode1 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode1.no) {
                flag = true;
                break;
            }

            temp = temp.next;

        }
        if (flag) {
            temp.name = heroNode1.name;
            temp.nickName = heroNode1.nickName;
        } else {
            System.out.println("没有找到此结点");
        }

    }


    //删除节点
    public void delete(int no) {
        HeroNode1 temp = head.next;

        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;

        while (temp != null) {
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.println("没有找到此节点");
        }

    }

    //遍历链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode1 temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public HeroNode1 getHead() {
        return head;
    }


}


class HeroNode1 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode1 next;
    public HeroNode1 pre;

    public HeroNode1(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}