package com.example.datastructure.queue.linkedqueue;

import java.util.Stack;

/**
 * 文件名：SingleLinkedListDemo
 * 作 者：Miles zhu
 * 时 间：2019/12/15 12:39
 * -------------------------
 * 功能和描述：单向链表
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "小卢", "玉麒麟~~");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode heroNode5 = new HeroNode(5, "武松", "打虎英雄");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode5);


        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
        singleLinkedList2.addByOrder(heroNode2);
        singleLinkedList2.addByOrder(heroNode4);

        SingleLinkedList.mergeNodeOrder(singleLinkedList.getHead(), singleLinkedList2.getHead());


//        SingleLinkedList.reverseNode(singleLinkedList.getHead());
        //  singleLinkedList.list();

        // SingleLinkedList.printNodeDesc(singleLinkedList.getHead());


//        int nodeCount = singleLinkedList.getNodeCount(singleLinkedList.getHead());
//        System.out.println(nodeCount);
//        singleLinkedList.update(heroNode2);
//
//        singleLinkedList.del(heroNode2);
//        singleLinkedList.del(heroNode4);
//        singleLinkedList.del(heroNode1);
//        nodeCount = singleLinkedList.getNodeCount(singleLinkedList.getHead());
//        System.out.println(nodeCount);
//        singleLinkedList.del(heroNode3);
////        singleLinkedList.del(heroNode2);
//        singleLinkedList.list();
    }
}

class SingleLinkedList {
    //先初始化一个头结点
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点
    public void add(HeroNode heroNode) {
        //首先保存头结点
        HeroNode tmp = this.head;

        //遍历链表
        //当找到原始链表的最后一个节点的时候，需要将该节点的next指向新添加节点
        while (true) {
            //说明找了链表的最后的一个节点
            if (null == tmp.next) {
                break;
            }

            //如果不是最后有一个节点，那么将下一个节点赋值给tmp
            tmp = tmp.next;
        }
        //当退出while循环的时候，说明已经找到了最后的一个节点
        // 将最后一个节点的next指向 新添加的节点
        tmp.next = heroNode;
    }

    //第二种添加方式，根据排名添加节点
    //不能有重复
    public void addByOrder(HeroNode heroNode) {
        HeroNode tmp = head;
        boolean flag = false;
        while (true) {
            if (null == tmp.next) {
                break;
            }
            if (tmp.next.no > heroNode.no) {
                break;
            } else if (tmp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.println("%d,编号已经存在" + heroNode.no + "，不能添加！");
        } else {
            heroNode.next = tmp.next;
            tmp.next = heroNode;
        }

    }

    public void update(HeroNode newHeroNode) {
        HeroNode tmp = head;
        boolean flag = false;
        while (true) {
            if (null == tmp.next) {
                System.out.println("链表为空~");
                break;
            }
            if (tmp.next.no == newHeroNode.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.next.name = newHeroNode.name;
            tmp.next.nickName = newHeroNode.nickName;
        } else {
            System.out.println("没有找到该节点~");
        }
    }

    //删除节点
    public void del(HeroNode heroNode) {
        HeroNode tmp = head;
        boolean flag = false;
        while (true) {
            if (null == tmp.next) {
                System.out.println("链表为空~");
                break;
            }
            if (tmp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.next = tmp.next.next;
        } else {
            System.out.println("不存在改节点");
        }
    }


    //遍历链表
    public void list() {
        if (null == head.next) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode tmp = head.next;
        while (true) {
            if (null == tmp) {
                break;
            }
            //输出节点信息
            System.out.println(tmp);
            //继续遍历下一个
            tmp = tmp.next;
        }
    }

    ///////////////////////////////////面试题///////////////////////////////////
    //1、求单链表中有效节点的个数（如果有头节点，不计算头节点）
    public int getNodeCount(HeroNode head) {

        if (null == head.next) {
            System.out.println("链表为空");
            throw new RuntimeException("链表为空~");
        }
        int count = 0;
        HeroNode tmp = head.next;
        while (null != tmp) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }


    //2、将单链表进行反转
    public static void reverseNode(HeroNode head) {
        if (null == head || null == head.next) {
            return;
        }
        //定义一个辅助的变量，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        //指向 当前节点cur的下一个节点
        HeroNode next = null;

        HeroNode reverseHead = new HeroNode(0, "", "");

        //遍历原来的链表
        //每遍历一个节点将其放在reverseHead的最前端
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;

    }

    //从尾到头打印单链表(可以利用栈的特性，先进后出)
    public static void printNodeDesc(HeroNode head) {
        if (null == head || null == head.next) {
            return;
        }

        Stack<HeroNode> heroNodeStack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            heroNodeStack.push(cur);
            cur = cur.next;
        }

        while (heroNodeStack.size() > 0) {
            System.out.println(heroNodeStack.pop());
        }
    }

    //练习：合并两个有序的单链表，合并之后还是有序的

    public static HeroNode mergeNodeOrder(HeroNode firstNodeHead, HeroNode secondNodeHead) {
        if (null == firstNodeHead || null == secondNodeHead) {
            return firstNodeHead == null ? secondNodeHead : firstNodeHead;
        } else {
            HeroNode firstCur = firstNodeHead.next;
            HeroNode secondCur = secondNodeHead.next;

            HeroNode head = new HeroNode(0, "", "");
            HeroNode headCur = head;

            while (true) {

                if (null != firstCur && null != secondCur) {
                    if (firstCur.no > secondCur.no) {

                        secondCur.next = firstCur;
                        headCur.next = secondCur;

                    } else {

                        firstCur.next = secondCur;
                        headCur.next = firstCur;

                    }
                    firstCur = firstCur.next;
                    secondCur = secondCur.next;
                    head.next = headCur;
                } else if (null != firstCur && null == secondCur) {
                    headCur.next = firstCur;
                    firstCur = firstCur.next;
                    head.next = headCur;
                } else if (null == firstCur && null != secondCur) {
                    headCur.next = secondCur;
                    secondCur = secondCur.next;
                    head.next = headCur;
                } else {
                    break;
                }

            }

            HeroNode tmp = head.next;
            while (true) {

                //输出节点信息
                System.out.println(tmp);
                //继续遍历下一个
                tmp = tmp.next;
            }
        }


    }

}

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
                "}";
    }
}
