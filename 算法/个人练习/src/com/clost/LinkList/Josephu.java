package com.clost.LinkList;

/**
 * @author clost
 * @date 2022/9/8 8:17
 */
public class Josephu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
//        circleSingleLinkedList.list();
        circleSingleLinkedList.countBoy(1, 2, 25);

    }


}


class CircleSingleLinkedList {
    private Boy first = new Boy(-1);

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("输入有误");
        }

        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {

            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
            }
            curBoy = boy;
        }

    }

    public void list() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        Boy curBoy = first;
        while (true) {
            System.out.println(curBoy);
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }


    public void countBoy(int startNo, int countNum, int nums) {

        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有误");
            return;
        }
        Boy helper = first;


        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        for (int i = 1; i < startNo; i++) {
            first = first.getNext();
            helper = helper.getNext();

        }



        while (true) {


            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first);
            if (first.getNext() == first) {
                break;
            }


            first = first.getNext();
            helper.setNext(first);


        }



    }
}


class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
