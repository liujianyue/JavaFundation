package com.example.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public class CommonAlgorithm {
	private static final String TAG = "JianzhiOfferAlgorithm";
	/**
	 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * @param target
	 * @param array
	 * @return
	 */
    public boolean Find(int target, int [][] array) {
    	if(array == null || array.length == 0) return false;
    	int cows = array.length, cols = array[0].length, i = cows - 1, j = 0;
    	while(i >= 0 && j < cols){
    		if(target > array[i][j]){
    			j++;
    		}else if(target < array[i][j]){
    			i--;
    		}else{
    			return true;
    		}
    	}
		return false;
    }
    
    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if(str==null){
            return null;
        }
       StringBuilder newStr = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
    
    public String replaceSpace1(StringBuffer str) {
        if(str==null){
            return null;
        }
        return str.toString().replaceAll("\\s", "%20");
    }
    
    public String replaceSpace3(StringBuffer str) {
        if(str==null){
            return null;
        }
        return str.toString().replaceAll("\\s", "%20");
    }
    
    /**
     * 输入一个链表，从尾到头打印链表每个节点的值
     */
     private class ListNode{
    	int val;
    	ListNode next;
    	public ListNode(int value){
    		this.val = value;
    	} 
    }
     
     private ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	 if(listNode == null)
    		 return null;
    	 Stack<ListNode> mStack = new Stack<>();
    	 while(listNode != null){
    		 mStack.push(listNode);
    		 listNode = listNode.next;
    	 }
    	 ArrayList<Integer> mArrayList = new ArrayList<>();
    	 while(!mStack.isEmpty()){
    		 mArrayList.add(Integer.valueOf(mStack.pop().val)) ;
    	 }
         return mArrayList;
     }  
     
     /**
      * recursion
      * @param listNode
      * @return
      */
     
     ArrayList<Integer> mArrayList = new ArrayList<>();
     private ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
    	 if(listNode != null){
    		 if(listNode.next != null){
    			printListFromTailToHead2(listNode.next);
    		 
    		 }
    		 mArrayList.add(Integer.valueOf(listNode.val)) ;
    	 }
         return mArrayList;
     }  
     
     /**
      * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
      * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
      * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
      * 则重建二叉树并返回。
      * @author liujianyue
      *
      */
     public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
     
     Map<Integer, Integer> mHashMap = new HashMap<>();
     public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	 if(pre == null || in == null ) return null;
    	 for(int i = 0;i < in.length; ++i){
    		 mHashMap.put(in[i], i);
    	 }
		return FindHead(pre, 0 , in, 0 ,pre.length);
     }
     
     private TreeNode FindHead(int [] pre, int preStart, int [] in,int inStart,int length){
    	 System.out.println(preStart);
    	 if(length <= 0) return null;
    	 TreeNode mHead = new TreeNode(pre[preStart]);
    	 int headOfIn = mHashMap.get(pre[preStart]);
    	 mHead.left = FindHead(pre, preStart + 1 , in, inStart ,headOfIn - inStart);
    	 mHead.right = FindHead(pre, preStart + 1 + headOfIn - inStart , in, headOfIn + 1 ,length + inStart - 1 - headOfIn);
    	 return mHead;
     }
     
     
     /**
      * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
      */
     class StackQueue{
    	/*Stack<E> stack1 = new Stack<>();
	    Stack<E> stack2 = new Stack<>();
	    
	    @SuppressWarnings("hiding")
		public <E> void push(E node) {
	    	stack1.push((E) node);
	    }
	    
	    public <E> void pop() {
	    	
	    return ;
	    }*/
    	Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();
	    
	    public void push(int node) {
	    	stack1.push(node);
	    }
	    
	    public int pop() {
		    if(stack2.size() <= 0){
		    	while(!stack1.isEmpty()){
		    		stack2.push(stack1.pop());
		    	}
		    }
		    return stack2.pop();
	    }
     }
     
     
     /**
      * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
      * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
      * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，
      * 若数组大小为0，请返回0。
      * @param array
      * @return
      */
     public int minNumberInRotateArray(int [] array) {
    	 if(array == null || array.length <= 0) return 0;
    	 int startIndex = 0 ,endIndex = array.length - 1;
    	 int middleIndex = startIndex;
    	 
		 while(array[startIndex] >= array[endIndex]){
			 System.out.println("startIndex" + startIndex 
					 + ",endIndex" + endIndex 
					 + ",middleIndex" + middleIndex);
			 if(endIndex - startIndex == 1){
				 middleIndex = endIndex;
				 break;
			 }

			 middleIndex = (startIndex + endIndex) >>>1;
    	 	System.out.println("array[startIndex" + array[startIndex] 
				 + ",array[endIndex]" + array[endIndex] 
				 + ",array[middleIndex]" + array[middleIndex]);
	    	 if(array[startIndex] == array[endIndex] && 
	    		array[startIndex] == array[middleIndex]){
	    		 //{0,1,1,1,1} ==> {1,1,1,0,1},{1,0,1,1,1} 顺序查找
	    		 middleIndex = startIndex;
	    		 for(int i = startIndex + 1;i <= endIndex; ++i){
	    			 if(array[i] < array[middleIndex]) middleIndex = i;
	    		 }
	    		 break;
	    	 }
	    	 
	    	 if(array[startIndex] <= array[middleIndex]){
	    		 startIndex =  middleIndex;
	    	 }else if(array[middleIndex] <= array[endIndex]){
	    		 endIndex = middleIndex;
	    	 }
		 }
    	 return array[middleIndex];
     }
    
     /**
      * 斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
      * @param n n<=39
      * @return
      */
     public int Fibonacci(int n) {
    	 if(n <= 0) return 0;
         if(n == 1) return n;
         //return Fibonacci(n - 1) + Fibonacci(n - 2);
         int N1 = 1,N2 = 0,sum = 0;
         for(int i = 2;i <= n;++i){
        	 sum = N1 + N2;
        	 N2 = N1;
        	 N1 = sum;
         }
         return sum;
     }
     
     /**
      * 一只青蛙一次可以跳上1级台阶，也可以跳上2 级……它也可以跳上n 级，
      * 此时该青蛙跳上一个n级的台阶总共有多少种跳法？
      * f(n) = f(n - 1) + f(n - 2) + f(n - 3) +...+ f(0);
      * f(n - 1) = f(n - 2) + f(n - 3) + f(n - 4) +...+ f(0);
      * 上下相减得：f(n) = 2*f(n - 1);
      */
     public int JumpFloor(int n){
    	 if(n <= 2) return n;
    	 int sum = 2;
    	 for(int i = 3;i <= n;++i){
    		 sum *= 2;
    	 }
    	 return sum;
     }
     
     
     /**
      * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
      * @param n
      * @return
      */
     public int NumberOf1(int n) {
    	 /*int count = 0;
    	 while(n != 0){
    		 ++count;
    		 n = n & (n - 1);
    	 }
    	 return count;*/
    	  int count = 0;
    	  int flag = 1;
    	  while(flag != 0){
    		  if((n & flag) != 0){
    			  ++count;
    		  }
    		  flag <<= 1;
    	  }
    	  return count;
     }
     
     
     /**
      * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
      * @param base
      * @param exponent
      * @return
      */
     public double Power(double base, int exponent) {
         //return Math.pow(base, exponent);
         
         if(equalsZero(base) && exponent <= 0){
        	 throw new IllegalArgumentException("illegal argment state,please input valid argment.");
         }
         
         int absExpoent = Math.abs(exponent);
         double result = PowerWithUnsignedExponent(base,absExpoent);
         if(exponent < 0)
         result = 1.0 / result;
         return result;
     }
     
     private double PowerWithUnsignedExponent(double base, int exponent){
    	 if(exponent == 0) return 1;
    	 if(exponent == 1) return base;
    	 double result = PowerWithUnsignedExponent(base, exponent>>1);
    	 result *= result;
    	 if((exponent & 0x1) == 1)
    		 result *= base;
    	 return result;
     }
     
     private boolean equalsZero(double base){
    	 if(Math.abs(base - 0.0) < 0.0000001){
    		 return true;
    	 }else{
    		 return false;
    	 }
     }
     
     
     /**
      * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
      * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
      * @param array
      */
     
     interface Judger{
    	 public boolean meetConditions(int even);
     }
     
     class EvenJudger implements Judger{
		@Override
		public boolean meetConditions(int even) {
			// TODO Auto-generated method stub
			return (even & 0x1) == 1;
		}	 
     }
     
     
     
     /**
      * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
      * 使得所有的奇数位于数组的前半部分，
      * 所有的偶数位于位于数组的后半部分，
      * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
      * 
      * 如是不用考虑调整后的顺序,则可使用两个指针分指向数组的首末两端,一个向后一个向前遍历,进行奇偶交换
      * 
      * 当前问题两种思路:
      * 1,时间复杂度O(N) 参考冒泡排序 本次采用冒泡排序
      * 2,时间复杂度和空间复杂度都是O(N)  先计算原数组中奇数的格数,另开辟一个数组,遍历原始数组,将奇数偶数分别在新数组中合适位置安放
      * @param array
      * @param judger
      */
     public void reOrderArray(int [] array) {
         if(array == null || array.length < 2) return; 
         
         boolean swap = true;
         for(int i =0;i < array.length && swap;++i){
        	 swap = false;
        	 for(int j = array.length - 1;j > i;--j){
        		 if((array[j] & 1) == 1 && (array[j - 1] & 1) == 0){
        			 swap(array, j, j-1);
        			 swap = true;
        		 }
        	 }
         }
     }
     
     
     
     
     /**
      * 输入一个链表，输出该链表中倒数第k个结点。
      * @param head
      * @param k
      * @return
      */
     public ListNode FindKthToTail(ListNode head,int k) {
    	 if(k <= 0 || head == null){
    		 return null;
    	 }
    	 
    	 ListNode LN1 = head ,LN2;
    	 for(int i = 0;i < k - 1; ++i){
    		 if(LN1.next != null){
    			 LN1 = LN1.next;
    		 }else{
    			 return null;
    		 }
    	 }
    	 
    	 LN2 = head;
    	 while(LN1.next != null){
    		 LN1 = LN1.next;
    		 LN2 = LN2.next;
    	 }
    	 return LN2;
     }
     
     
     /**
      * 输入一个链表，反转链表后，输出链表的所有元素。
      * @param head
      * @return
      */
     public ListNode ReverseList(ListNode head) {
    	 if(head == null || head.next ==null) return head;
    	 
    	 ListNode PHead = head,PPri = null,PNode = head;
    	 while(PNode != null){
    		 ListNode PNext = PNode.next;
    		 if(PNext == null) PHead = PNode;
    		 PNode.next = PPri;
    		 PPri = PNode;
    		 PNode = PNext;
    	 }
    	 return PHead;
     }
     
     ListNode PHead;
     public ListNode ReverseList2(ListNode head) {
    	 if(head == null || head.next ==null){
    		 PHead = head;
    		 return head;
    	 }
    	 
    	 ListNode PPri = null,PNode = head;
    	 PNode = ReverseList2(PNode.next);
    	 if(PNode != null){
    		 PNode.next = PPri;
    		 PPri = PNode;
    	 }else{
    		 return PHead;
    	 }
    	     	 
    	 return PNode;
     }
     
     
     /**
      * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
      * @param list1
      * @param list2
      * @return
      */
     public ListNode Merge(ListNode list1,ListNode list2) {
         if(list1 == null) return list2;
         if(list2 == null) return list1;
         
         ListNode LN1 = list1;
         ListNode LN2 = list2;
         if(LN1.val < LN2.val){
        	 LN1.next = Merge(LN1.next,LN2);
        	 return LN1;
         }else{
        	 LN2.next = Merge(LN1,LN2.next);
        	 return LN2;
         }
     }
     

     /**
      * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
      * 两个递归 前者找到数值对应的跟节点，后者判断以该节点为根的树是否数值能一一对应
      * @param root1
      * @param root2
      * @return
      */
     public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	if(root1 == null || root2 == null) return false;//任何一棵树为空都认为不是包含关系
    	//如果当前两个顶点val相等，则比较以该节点为根的树是否数值能一一对应
    	if((root1.val == root2.val) && IsTree2InTree1(root1,root2)) return true;
    	//否则遍历root1的左右子树
    	return (HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2));  
     }
     
     private boolean IsTree2InTree1(TreeNode root1,TreeNode root2){
    	 if(root2 == null) return true;//目的是递归判断左右子树的数值是否相等，此时子树为空不要紧
    	 if(root1 == null) return false;//root2不为空时，root1为空则肯定不是包含关系
    	 if(root1.val != root2.val) return false;
    	 //判断左右子树数值是否一一对应
    	 return IsTree2InTree1(root1.left,root2.left) && IsTree2InTree1(root1.right,root2.right);
     }
     
     
     /**
      * 操作给定的二叉树，将其变换为源二叉树的镜像。
      * 二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
      * @param root
      */
     public void Mirror(TreeNode root) {
         if(root == null) return;
         Mirror(root.left);
         Mirror(root.right);
         TreeNode temp = root.left;
         root.left = root.right;
         root.right = temp;
     }
     
     /**
      * 非递归镜像
      * @param root
      */
     public void MirrorByNOReverse(TreeNode root) {
         if(root == null) return;
         Stack<TreeNode> mStack = new Stack<>();
         TreeNode TN = root;
         while(TN != null){
        	 TreeNode temp = TN.left;
        	 TN.left = TN.right;
             TN.right = temp;
             
             if(TN.right != null)
            	 mStack.push(TN.right);
             if(TN.left != null){
            	 TN = TN.left;
             }else{
            	 if(!mStack.isEmpty()){
            		 TN = mStack.pop();
            	 }else{
            		 break;
            	 }
             }
         }
     }
     
     
     
     /**
      * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
      * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
      * @param matrix
      * @return
      */
     public ArrayList<Integer> printMatrix(int [][] matrix) {
         if(matrix == null || (matrix.length == 0 && matrix[0].length == 0))
        	 return null;
         
         int start = 0,cols = matrix[0].length,raws = matrix.length;
         ArrayList<Integer> list = new ArrayList<>();
         while(cols > start<<1 && raws > start<<1){
        	 AddNodeToList(list,matrix,start);
             ++start;
         }
         return list;
     }
     
     private void AddNodeToList(ArrayList<Integer> list, int [][] matrix, int start){
    	 int cols = matrix[0].length,raws = matrix.length;
    	 int endX = cols - start -1;
    	 int endY = raws - 1 -start;
    	 //从左到右
    	 for(int i = start; i <= endX; ++i){
    		 list.add(matrix[start][i]);
    	 }
         //从上到下
    	 if(start < endY){//保证剩余的回形数组高度至少为2
	    	 for(int i = start + 1; i <= endY; ++i){
	    		 list.add(matrix[i][endX]);
	    	 }
    	 }
         //从右到左
    	 if(start < endX && start < endY){//保证剩余的回形数组宽度至少为2，高度至少为2
	    	 for(int i = endX - 1; i >= start; --i){
	    		 list.add(matrix[endY][i]);
	    	 }
    	 }
    	 //从下到上
    	 if(start < endX && start + 1 < endY){//保证剩余的回形数组宽度至少为2,高度至少为3
	    	 for(int i = endY - 1; i >= start + 1; --i){
	    		 list.add(matrix[i][start]);
	    	 }
    	 }
     }
     
     
     
     public class MinStack {
    	Stack<Integer> dataStack = new Stack<>();
    	Stack<Integer> minStack = new Stack<>();
    	
    	public void push(int node) {
	        dataStack.push(node);
	        if(minStack.isEmpty() || minStack.peek() > node){
	        	minStack.push(node);
	        }else {
	        	minStack.push(minStack.peek());
	        }
	    }
	    
	    public void pop() {
	        if(dataStack.isEmpty() || minStack.isEmpty()){
	        	throw new EmptyStackException();
	        }
	        minStack.pop();
	        dataStack.pop();
	    }
	    
	    public int top() {
	    	if(dataStack.isEmpty()){
	        	throw new EmptyStackException();
	        }
	    	return dataStack.peek();
	    }
	    
	    public int min() {
	    	if(minStack.isEmpty()){
	        	throw new EmptyStackException();
	        }
	        return minStack.peek();
	    }
	}
     
     
     /**
      * 输入两个整数序列，第一个序列表示栈的压入顺序
      * ，请判断第二个序列是否为该栈的弹出顺序。
      * 假设压入栈的所有数字均不相等。
      * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列
      * ，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
      * （注意：这两个序列的长度是相等的）
      * @param pushA
      * @param popA
      * @return
      */
     public boolean IsPopOrder(int [] pushA,int [] popA) {
         if(pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) return false;
         
         Stack<Integer> mStack = new Stack<>();
         int index = 0;
         for(int i = 0;i<popA.length;++i){
        	 int temp = popA[i];
    		 if(!mStack.isEmpty() && mStack.peek() == temp){//访问栈顶元素，是否和当前元素对应，如果对应继续
    			 mStack.pop();
    			 continue;
    		 } else{//如果栈中找不到该元素，说明很可能还没有入栈，找到该元素入栈
    			 for( ; index < pushA.length; ++index){
    				 if(pushA[index] != temp){
    					 mStack.push(pushA[index]);
    				 }else{
    					 ++index;
    					 break;//找到了
    				 }
    			 }
    		 }
         }
         if(index == pushA.length && mStack.isEmpty()) //遍历结束，且栈为空说明成功匹配
        	 return true;
         return false;
     }
     
     
     
     /**
      * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
      * @param root
      * @return
      */
     public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	 ArrayList<Integer> mList = new ArrayList<>();
    	 if(root == null) return mList;
    	 ArrayDeque<TreeNode> mArrayDeque = new ArrayDeque<>(); //使用队列FIFO的特性
    	 mArrayDeque.offer(root);
    	 while(!mArrayDeque.isEmpty()){
    		 TreeNode TN = mArrayDeque.pop();
    		 mList.add(TN.val);
    		 if(TN.left != null) mArrayDeque.offer(TN.left);
    		 if(TN.right != null) mArrayDeque.offer(TN.right);
    	 }
		return mList;
     }
     
     
     
     /**
      * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
      * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
      * @param sequence
      * @return
      */
     
     public boolean VerifySquenceOfBST(int [] sequence) {
         if(sequence == null || sequence.length == 0) return false;
         
         return VerifySquenceOfBSTImpl(sequence,0,sequence.length - 1);
     }
     
     
     public boolean VerifySquenceOfBSTImpl(int [] sequence,int start,int end) {
    	 System.out.println("start:" + start);
    	 System.out.println("start:" + end);
         int root = sequence[end];
         int splitIndex = start;
         for(;splitIndex < end;++splitIndex){
        	 if(sequence[splitIndex] > root) 
        		 break;
         }
         int testIndex = splitIndex;
         for(;testIndex < end;++testIndex){
        	 if(sequence[testIndex] < root)
        		 return false;
         }
         
         boolean leftIsBST = true,rightIsBST = true;
         if(start < splitIndex - 1)
        	 leftIsBST = VerifySquenceOfBSTImpl(sequence, start, splitIndex - 1);
         
         System.out.println("leftIsBST:" + leftIsBST);
         if(!leftIsBST) 
        	 return false;
         if(splitIndex < end - 1)
        	 rightIsBST = VerifySquenceOfBSTImpl(sequence, splitIndex, end - 1);
         
         System.out.println("rightIsBST:" + rightIsBST);
         return rightIsBST;
     }
     
     
     
     /**
      * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
      * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
      * @param root
      * @param target
      * @return
      */
     public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	 ArrayList<ArrayList<Integer>> mlists = new ArrayList<>();
    	 ArrayList<Integer> mlist = new ArrayList<>();
         if(root == null) return mlists;
         TreeNode TN = root;
         FindPathWithSum(mlists, mlist, TN, 0, target);
         return mlists;
     }
     
     public void FindPathWithSum(ArrayList<ArrayList<Integer>> mlists,
												    		 ArrayList<Integer> mlist,
												    		 TreeNode root,
												    		 int currentSum,
												    		 int target) {
         TreeNode TN = root;
         //超出总和，退出
         if(target < (TN.val + currentSum)) return;
         //是否是叶子节点
         boolean isLeaf = (TN.left == null) && (TN.right == null);
         
         //找到路径，添加进去，
         if(isLeaf && target == (TN.val + currentSum)){
        	 @SuppressWarnings("unchecked")
			ArrayList<Integer> mCopyList = (ArrayList<Integer>)mlist.clone();//new ArrayList<>(Arrays.asList(new Integer[mlist.size()]));
        	 //Collections.copy(mCopyList, mlist);
        	 mCopyList.add(TN.val);
        	 mlists.add(mCopyList);
         }
         
         //首先添加进路径中，后续弹出
         mlist.add(TN.val);
         
         //不是叶子节点，且仍未达到总和
         if(!isLeaf && target > (TN.val + currentSum)){
        	 
        	 if(TN.left != null) FindPathWithSum(mlists, mlist, TN.left, currentSum + TN.val, target);
        	 if(TN.right != null) FindPathWithSum(mlists, mlist, TN.right, currentSum + TN.val, target);
         }
         
         mlist.remove(mlist.size() - 1);
     }
     
     
     /**
      * 找到二叉树中节点值和最大的路径
      * @param root
      * @param target
      * @return
      */
     public ArrayList<ArrayList<Integer>> FindPathLongPath(TreeNode root,int target) {
    	 ArrayList<ArrayList<Integer>> mlists = new ArrayList<>();
    	 ArrayList<Integer> mlist = new ArrayList<>();
         if(root == null) return mlists;
         TreeNode TN = root;
         FindPathLongPathWithSum(mlists, mlist, TN, 0, target);
         return mlists;
     }

	private void FindPathLongPathWithSum(ArrayList<ArrayList<Integer>> mlists,
												    		 ArrayList<Integer> mlist,
												    		 TreeNode root,
												    		 int currentSum,
												    		 int target) {
		// TODO Auto-generated method stub
		
	}
     
     
	
	/**
	 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
	 * 返回结果为复制后复杂链表的head。
	 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
	 * @param pHead
	 * @return
	 */
	
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	public RandomListNode Clone(RandomListNode pHead)
    {
		if(pHead == null) return null;
		RandomListNode oldP = pHead;
		//构建新链表使得 A->B->C 变成A->A'->B->B'->C->C'
		while(oldP != null){
			RandomListNode mRLN = new RandomListNode(oldP.label);
			mRLN.next = oldP.next;
			oldP.next = mRLN;
			oldP = mRLN.next;
			if(oldP == pHead) break;//循环链表
		}
		
		oldP = pHead;
		RandomListNode mRLN;
		//为A'找到合适的指向
		while(oldP != null){
			mRLN = oldP.next;
			if(oldP.random != null){
				mRLN.random = oldP.random.next;
			}
			oldP = mRLN.next;
			if(oldP == pHead) break;//循环链表
		}
		
		RandomListNode newHead = pHead.next;
		oldP = pHead;
		mRLN = newHead;
		//拆分链表：原链表 + 新链表
		while(oldP != null){
			oldP.next = mRLN.next;
			oldP = mRLN.next;
			if(oldP != null){
				mRLN.next = oldP.next;
				mRLN = oldP.next;
			}
			if(oldP == pHead) break;//循环链表
		}
		return newHead;     
    }
     
	
	
	/**
	 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
	 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
	 * @param pRootOfTree
	 * @return
	 */
	TreeNode head = null,LinkHead = null;
	public TreeNode Convert(TreeNode pRootOfTree) {
		ConvertSubTree(pRootOfTree);
		return LinkHead;
        
    }

	private void ConvertSubTree(TreeNode pRootOfTree) {
		if(pRootOfTree == null) return;
		ConvertSubTree(pRootOfTree.left);
		if(LinkHead == null){
			LinkHead = head = pRootOfTree;
		}else{
			head.right = pRootOfTree;
			pRootOfTree.left = head;
			head = pRootOfTree;
		}
		ConvertSubTree(pRootOfTree.right);
	}
	
	
	
	
	/**
	 * 
	输入一个字符串,按字典序打印出该字符串中字符的所有排列。
	例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
	输入描述:
	
	输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
	 * @param str
	 * @return
	 */
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> mList = new ArrayList<>();
	    if(str == null || str.length() <= 0){
		    return mList;
	    }
		PermutationforSub(mList,str,0);
		Collections.sort(mList);
		return mList;
    }
	
	private void PermutationforSub(ArrayList<String> mlist,String str,int index) {
		if(index == str.length()){
			mlist.add(str);
			System.out.println("str:" + str);
			return;
		}
		
		for(int i = index;i < str.length();++i){
			StringBuilder sb = new StringBuilder(str);
			/*System.out.println("sb.charAt(index):" + sb.charAt(index));
			System.out.println("sb.charAt(i):" + sb.charAt(i));
			System.out.println("index:" + index);
			System.out.println("i:" + i);*/
			//当是相同字符时，则会产生相同排序，舍弃该子串
			if(sb.charAt(index) == sb.charAt(i) && index != i){
				continue;
			}
			swap(sb,index,i);
			PermutationforSub(mlist,sb.toString(),index + 1);
		}
	}

	private void swap(StringBuilder sb, int index, int i) {
		char temp = sb.charAt(index);
		char temp2 = sb.charAt(i);
		sb.replace(index, index + 1, String.valueOf(temp2));
		sb.replace(i, i + 1, String.valueOf(temp));
	}
	
	
	/**
	 * 八皇后问题
	 */
	int board,n,ans = 0;
	public void Queen(int col,int ld,int rd){
		if(col == board){
			ans++;
			return;
		}
		
		int pos = board & (~(col | ld | rd));
		while(pos > 0){
			int p = pos & (-pos);
			pos = pos - p;
			Queen(col | p, (ld | p)<<1, (rd | p) >>1);
		}
	}
	
	int Queen(int n){
	    board = (1 << n) - 1;
	    Queen(0,0,0);
	    return ans;
	}
	
	

	
	public int Partition(int[] sort,int start ,int end){
		if(start == end) return start;
		int small = start - 1;
		for(int index = start;index < end;++index){
			if(sort[index] < sort[end]){
				small ++;
				System.out.println("small:" + small);
				if(small != index){
					swap(sort,small,index);
				}
			}
		}
		small ++;
		System.out.println("small--:" + small);
		swap(sort,small,end);
		for(int i = 0;i <= end; ++i){
			System.out.println("sort[i]:" + sort[i]);
			System.out.println("-----------");
		}
		
		return small;
	}
	
	private void swap(int[] sort,int start ,int end){
		if(start == end) return;
		sort[start] = sort[start] ^ sort[end];
		sort[end] = sort[start] ^ sort[end];
		sort[start] = sort[start] ^ sort[end];
	}
	
	public void quickSort(int[] sort,int start ,int end){
		if(sort == null || sort.length < 1 || start < 0 || end > sort.length) 
			throw new IllegalArgumentException();
		
		if(start == end) return;
		int index = Partition(sort, start, end);
		if(index > start) Partition(sort, start, index - 1);
		if(index < end) Partition(sort, index + 1, end);
	}
	
	/**
	 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
	 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
	 * 
	 * 如果存在这个数，该数组中间的那个数也是这个数，所以可以先找中位数，需要改变数组结构
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int [] sort) {
		if(sort == null || sort.length < 1) 
			return 0;
		
		int start = 0,end = sort.length - 1,middle = end>>1;
		//找到中位数
		int index = Partition(sort, start, end);
		while(middle != index){
			if(index < middle){
				start = index + 1;
				index = Partition(sort, start, end);
			}
			if(index > middle){
				end = index - 1;
				index  = Partition(sort, start, end);
			}
		}
		//检验该数的格数是否大于数组长度的一般
		int middleSum = sort[middle];
		int times = 0;
		for(int i = 0;i < sort.length;++i){
			if(sort[i] == middleSum) ++ times;
		}
		if(times > sort.length >> 1){
			return middleSum;
		}
		return 0;
    }
	
	/**
	 * 不改变数组结构
	 * @param sort
	 * @return
	 */
	public int MoreThanHalfNum_Solution2(int [] sort) {
		if(sort == null || sort.length < 1) 
			return 0;
		
		int times = 1,num = sort[0];
		for(int i = 1;i < sort.length;++i){
			if(times == 0){
				num = sort[i];
				times = 1;
			}else if(sort[i] == num){
				times ++;
			}else{
				times --;
			}
		}
		
		times = 0;
		for(int i = 0;i < sort.length;++i){
			if(sort[i] == num) ++ times;
		}
		if(times*2 > sort.length){
			return num;
		}
		return 0;
	}
	
	
	
	
	
	/**
	 * 输入n个整数，找出其中最小的K个数。
	 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
	 * 类似于找数组的中位数，只不过换成找第K大的数
	 * 
	 * 这种方法适用于N比较小（数据量小，内部查找），允许将数组加载到内存
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> mList = new ArrayList<>();
        if(input == null || input.length == 0 || k > input.length || k < 1) return mList;
        
        int start = 0,end = input.length - 1;
        int index = Partition(input, start, end);
        for(int i = 0;i <= end; ++i){
        	System.out.println("input[i]:" + input[i]);
        }
        System.out.println("index------:" + index);
        while(index != k - 1){
        	if(index > k -1){
        		end = index - 1;
        		index = Partition(input, start, end);
        		System.out.println("index------:" + index);
        	}
        	if(index < k -1){
        		start = index  + 1;
        		index = Partition(input, start, end);
        		System.out.println("index------:" + index);
        	}
        }
        
        for(int i = 0;i <= index; ++i){
        	System.out.println("input[i]:" + input[i]);
        	mList.add(input[i]);
        }
		return mList;
    }
	
	
	/**
	 * 输入n个整数，找出其中最小的K个数。
	 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
	 * 
	 * 这种方法适用于N比较大（海量数据，外部查找），K比较小，需要加载K大小长度的数组到内存
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
		ArrayList<Integer> mList = new ArrayList<>();
        if(input == null || input.length == 0 || k > input.length || k < 1) return mList;
        
        for(int i = 0; i < k; ++i){
        	mList.add(input[i]);
        }
        for(int i = k;i < input.length;++i){
        	Collections.sort(mList);
        	int temp = input[i];
        	int lastIndex = mList.size() - 1;
        	if(temp < mList.get(lastIndex)){
        		mList.set(lastIndex, new Integer(temp));
        	}
        }
        System.out.println("mList:" + mList);
        return mList;
	}
	private void testList(){
		Integer sb = 7;
		ArrayList<Integer> list1 = new ArrayList<>();
		Integer[] sbs = new Integer[3];
		//sb = new Integer("test2");
		sbs[0] = sb;
		list1.add(sb);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.addAll(list1);
		System.out.println("list1:" + list1.get(0));
		System.out.println("list2:" + list2.get(0));
		System.out.println("sbs[0]:" + sbs[0]);
		sb.intValue();
		System.out.println("list1:" + list1.get(0));
		System.out.println("list2:" + list2.get(0));
		System.out.println("sbs[0]:" + sbs[0]);
	}
	
	
	
	
	
	
	/**
	 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
	 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
	 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
	 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
	 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
	 * 你会不会被他忽悠住？(子向量的长度至少是1)
	 * 
	 * 或者说求一个数组中连续数字的最大和
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) return -1;
        
        int sum = array[0],curSum = sum;
        //当前cursum如果是负,
        for(int i = 1;i < array.length;++i){
        	int temp = array[i];
        	//如果当前cursum小于0,表示不想让它再小了
        	if(curSum <= 0){
        		curSum = temp;
        	//可以尝试加上这个值试试,有这个资本,有没有比之前的值还大
        	}else{
        		curSum += temp;
        	}
        	if(curSum > sum)
        		sum = curSum;
        }
        return sum;
    }
	
	
	
	/**
	 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
	 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
	 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
	 * @param n
	 * @return
	 */
	public int NumberOf1Between1AndN_Solution(int n) {
		return n;
	    
    }
	
	
	
	
	
	/**
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
	 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
	 * 
	 * 时间复杂度为排序的复杂度:O(nlogn)
	 * @param input
	 * @return
	 */
	public String PrintMinNumber(int [] input) {
		if(input == null) return null;
		if(input.length < 1) return "";
		ArrayList<Integer> mList = new ArrayList<>();
		for(int i = 0;i < input.length;++i){
			mList.add(input[i]);
		}
		
		Collections.sort(mList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String str1 = o1 + "" + o2;
				String str2 = o2 + "" + o1;
				return str1.compareTo(str2);
			}
			
		});
		String Number = "";
		for(Integer i:mList){
			Number += i;
		}
		return Number;
    }
	
	
	
	
	
	/**
	 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
	 * 例如6、8都是丑数，但14不是，因为它包含因子7。 
	 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
	 * @param index
	 * @return
	 */
	public int GetUglyNumber_Solution(int index) {
		if(index < 1) return 0;
		int[] UNs = new int[index];
		UNs[0] = 1;//第一个丑数已知是1,并且是循环的起点
		int indexUN = 1;//从第二个位置开始循环比较查找
		//分别记录乘以2后正好大于最大值的数,乘以3后正好大于最大值的数,乘以5后正好大于最大值的数
		int curMinT2 = 0,CurMinT3 = 0,curMinT5 = 0;
		while(indexUN < index){
			System.out.println("indexUN:" + indexUN);
			UNs[indexUN] = 	Math.min(UNs[curMinT2] * 2, Math.min(UNs[CurMinT3] * 3, UNs[curMinT5] * 5));
			System.out.println("UNs[indexUN]:" + UNs[indexUN]);
			while(UNs[curMinT2] * 2 <= UNs[indexUN])
				curMinT2++;
			while(UNs[CurMinT3] * 3 <= UNs[indexUN])
				CurMinT3++;
			while(UNs[curMinT5] * 5 <= UNs[indexUN])
				curMinT5++;
			System.out.println("curMinT2:" + curMinT2);
			System.out.println("CurMinT3:" + CurMinT3);
			System.out.println("curMinT5:" + curMinT5);
			indexUN++;
		}
		System.out.println("UNs[indexUN - 1]:" + UNs[indexUN - 1]);
        return UNs[indexUN - 1];
    }
	
	
	
	/**
	 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
	 * @param str
	 * @return
	 */
	public int FirstNotRepeatingChar(String str) {
		if(str == null || str.length() == 0) return - 1;
		int[] Times = new int[256];
		for(int i = 0;i < str.length();++i){
			char temp = str.charAt(i);
			int index = temp;
			System.out.println("index:" + index);
			System.out.println("temp:" + temp);
			Times[index]++;
		}
		
		for(int i = 0;i < str.length();++i){
			char temp = str.charAt(i);
			int index = temp;
			if(Times[index] == 1){
				System.out.println("index:::" + index);
				System.out.println("temp:::" + temp);
				return i;
			}
		}
        return -1;
    }
	
	
	
	
	/**
	 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
	 * 输入一个数组,求出这个数组中的逆序对的总数P。
	 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
	 * 
	 * 如果两个两个数是逆序对,那只要两个数的相对位置不变则还仍是逆序对,所以采用分治思想,利用归并排序,
	 * 需要改变之前数组结构,且使用O(n)的额外空间
	 * @param array
	 * @return
	 */
    public int InversePairs(int [] array) {
    	if(array == null || array.length < 2) return 0;
    	int[] copy =Arrays.copyOfRange(array, 0, array.length);
    	
		return InversePairsCore(array,copy,0,array.length - 1);
    }
	
    public int InversePairsCore(int [] array,int[] copy,int start,int end) {
    	if(start == end){
    		copy[start] = array[start];
    		return 0;
    	}
    	int length = (end - start)>>1;
    	//两个数组做相互copy,因为被copy的数组的上个子序列已经有序,所以之后利用该序列比较并得出逆序对,并将其copy到
    	//另一个数组,为下次比较做准备
    	int left = InversePairsCore(copy, array, start, start + length);
    	int right = InversePairsCore(copy, array, start + length + 1, end);
    	for(int i = 0 ;i < copy.length;i++){
    		System.out.println("array[i]:::" + array[i]);
    	}
    	
    	int indexCopy = end;
    	int count = left + right;
    	int j = end;
    	int i = start + length;
    	while(j >= start + length + 1 && i >= start){
    		System.out.println("array[i]---" + array[i]);
    		System.out.println("array[j]---" + array[j]);
    		if(array[i] > array[j]){
    			copy[indexCopy--] = array[i--];
    			count += j - start - length;
    			//1000000007 是最小的十位质数。模1000000007，可以保证值永远在int的范围内
    			if(count > 1000000007) count = count%1000000007;
    			System.out.println("count---" + count);
    		}else{
    			copy[indexCopy--] = array[j--];
    		}
    	}
    	
    	for(;j >start + length;){
    		copy[indexCopy--] = array[j--];
    	}
    	
    	for(;i >= start;){
    		copy[indexCopy--] = array[i--];
    	}
    	System.out.println("count:::" + count);
    	
		return count;
    }
	
	
	
	
	/**
	 * 输入两个链表，找出它们的第一个公共结点。
	 * 
	 * 循环时注意空指针异常
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 if(pHead1 == null || pHead2 == null){
			 return null;
		 }
		  int L1 = 0,L2 = 0;
		  ListNode P1 = pHead1,P2 = pHead2;
		  while(P1 != null){
			  L1++;
			  P1 = P1.next;
		  }
		  while(P2 != null){
			  L2++;
			  P2 = P2.next;
		  }
		  P1 = pHead1;
		  P2 = pHead2;
		  //P1指向长链表
		  if(L1 < L2){
			  P1 = pHead2;
			  P2 = pHead1;
		  }
		  //使p1提前走|L1 - L2|步
		  int length = Math.abs(L1 - L2);
		  while(length-- != 0){
			  P1 = P1.next;
		  }
		  while(P1 != null && P2 != null && P1 != P2){
			  P1 = P1.next;
			  P2 = P2.next;
		  }
		  //不管有没有公共节点,如果有此时p1 p2肯定指向统一节点,如果没有,则遍历到链表尾部,且指向NULL
		  return P1;
    }
	
	
	
	/**
	 * 统计一个数字在排序数组中出现的次数。
	 * 
	 * 使用二分查找法找到第一个K和最后一个K
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK(int [] array , int k) {
	      if(array == null || array.length ==0) return 0;
	      int first = GetFirstK(array, k, 0, array.length - 1);
	      if(first == -1) return 0;
	      int last = GetLastK(array, k, first, array.length - 1);
	      if(last != -1)
	    	  return last - first + 1;
	      return 0;
		
    }
	
	private int GetFirstK(int [] array , int k ,int start ,int end){
		if(start > end) return -1;
		int middleIndex = (start + end)>>>1;
		int temp = array[middleIndex];
		if(temp == k){
			if((middleIndex == 0) ||(middleIndex > 0 && array[middleIndex - 1] != temp)){
				return middleIndex;
			}else{
				end = middleIndex - 1;
			}
		}else if(temp > k){
			end = middleIndex - 1;
		}else{
			start = middleIndex + 1;
		}
		return GetFirstK(array, k, start, end);
	}
	
	
	private int GetLastK(int [] array , int k ,int start ,int end){
		System.out.println("start---" + start);
		System.out.println("end---" + end);
		if(start >= end) return -1;
		int middleIndex = start + (end - start)/2;
		int temp = array[middleIndex];
		if(temp == k){
			if((middleIndex == array.length - 1) || array[middleIndex + 1] > temp){
				return middleIndex;
			}else{
				start = middleIndex + 1;
			}
		 }else if(temp > k){
			 end = middleIndex - 1;
		 }else{
			 start = middleIndex + 1;
		 }
		return GetLastK(array, k, start, end);
	}
	
	
	/**
	 * 输入一棵二叉树，求该树的深度。
	 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
	 * 最长路径的长度为树的深度。
	 * @param root
	 * @return
	 */
	 public int TreeDepth(TreeNode root) {
	     if(root == null) return 0;
	     int leftDepth = TreeDepth(root.left);
	     int rightDepth = TreeDepth(root.right);
	     return (leftDepth > rightDepth)?(leftDepth + 1):(rightDepth + 1);
	 }
	
	 
	 
	 /**
	  * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
	  * 后续遍历二叉树,一旦有一个节点不是平衡树,则一次返回-1,最终这颗树就不是平衡二叉树,
	  * 这样每个节点之遍历一次,遍历同时计算子树degree
	  * @param root
	  * @return
	  */
	 public boolean IsBalanced_Solution(TreeNode root) {
		 return getBalancedTreeDegree(root) != -1;
	 }
	 
	 public int getBalancedTreeDegree(TreeNode root) {
		 if(root == null){ 
			 return 0;
		 }
		 int leftDegree = getBalancedTreeDegree(root.left);
		 int rightDegree =  getBalancedTreeDegree(root.right);
		 if(leftDegree != -1 && rightDegree != -1 && Math.abs(leftDegree - rightDegree) <= 1){
			 return leftDegree > rightDegree?leftDegree + 1:rightDegree + 1;
		 }
		 return -1;
	 }
	 
	 
	 
	 /**
	  * 输入一棵二叉树，判断该二叉树是否是完全二叉树。
	  * @param root
	  * @return
	  */
	 public boolean IsComplated_Solution(TreeNode root) {
		return false;
	        
	 }
	 
	 
	 
	 /**
	  * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
	  * @param array
	  * @param num1
	  * @param num2
	  * num1,num2分别为长度为1的数组。传出参数,将num1[0],num2[0]设置为返回结果
	  */
	 public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	      if(array == null || array.length == 0 || num1 == null || num2 == null) return;
	      int XORSum = 0;
	      //先计算数组的异或和
	      for(int i =0;i < array.length; ++i){
	    	  XORSum ^= array[i];
	      }
	      int first1INdex = 0;
	      //找到xorsum最右边的第一个1的位置
	      while((XORSum & 1) == 0){
	    	  XORSum = XORSum >> 1;
	    	  first1INdex ++;
	      }
	      
	      //逐个判断数组中每个元素第first1INdex位是否为1,相当于分为两组数据
	      //将是1的素有元素异或,不是1的元素也异或,最终得到的是两个只有一次的元素
	      for(int i =0;i < array.length; ++i){
	    	  if(isIndexBit1(array[i], first1INdex)){
	    		  num1[0] ^=array[i];
	    	  }else{
	    		  num2[0] ^=array[i];
	    	  }
	      }
	 }
	 
	 /**
	  * num的第index位是否为1
	  * @param num
	  * @param index
	  * @return
	  */
	 private boolean isIndexBit1(int num,int index){
		 num = num >> index;
	     return (num & 1) == 1;
	 }
	 
	 
	 
	 /**
	  * 
		小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
		但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
		没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
		现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
	  * @param sum
	  * @return
	  */
	 public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		 ArrayList<ArrayList<Integer>> mLists = new ArrayList<>();
	       if(sum < 3) return mLists;
	       int index = (sum + 1)/2;
	       int small = 1,big = 2;
	       int sums = 3;
	       while((small < big) && (small <= index)){
	    	   if(sums == sum){
	    		   ArrayList<Integer> mList = new ArrayList<>();
	    		   for(int i = small;i <= big;++i){
	    			   mList.add(i);
	    		   }
	    		   mLists.add(mList);
	    		   big++;
	    		   sums += big;
	    	   }else if(sums < sum){
	    		   big++;
	    		   sums += big;
	    	   }else{
	    		   sums -= small;
	    		   small++;
	    	   }
	       }
	       return mLists;
	 }
	 
	 
	 /**
	  * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
	  * 是的他们的和正好是S，如果有多对数字的和等于S，
	  * 输出两个数的乘积最小的。
	  * @param array
	  * @param sum
	  * 对应每个测试案例，输出两个数，小的先输出。
	  * @return
	  */
	 public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		 ArrayList<Integer> mList = new ArrayList<>();
	      if(array == null || array.length == 0) return mList;
	      int start = 0,end = array.length - 1;
	      int curSum = 0;
	      while(start < end){
	    	  curSum = array[start] + array[end];
	    	  if(curSum == sum){
	    		  mList.add(array[start]);
	    		  mList.add(array[end]);
	    		  return mList;
	    	  }else if(curSum < sum){
	    		  start++;
	    	  }else{
	    		  end--;
	    	  }
	      }
	      return mList;
	 }
	 
	 
	 
	 
	 /**
	  * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
	  * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
	  * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
	  * 要求输出循环左移3位后的结果，
	  * 即“XYZdefabc”。是不是很简单？OK，搞定它！
	  * 
	  * 先反转主串,在根据位移来个来将字串分两部分反转
	  * @param str
	  * @param n
	  * @return
	  */
	public String LeftRotateString(String str,int n) {
	    if(str == null || str.length() < 2 || n <= 0) return str; 
	    
	    char[] Chars = str.toCharArray();
	    int length = Chars.length - 1;
	    reverseArray(Chars, 0, length);
	    int index = n%(length + 1);
	    reverseArray(Chars, 0, length - index);
	    reverseArray(Chars, length - index + 1, length);
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0;i <= length;++i){
	    	sb.append(Chars[i]);
	    }
	    return sb.toString();
	}
	
	private void reverseArray(char [] chars,int start,int end){
		while(start < end){
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}
	
	
	/**
	 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
	 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
	 * 有一天他向Fish借来翻看，但却读不懂它的意思。
	 * 例如，“student. a am I”。后来才意识到，
	 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
	 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
	 * @param str
	 * @return
	 */
	public String ReverseSentence(String str) {
		if(str == null){ return null;}
        if(str.trim().equals("")){
            return str;
        }
        
        String[] strs = str.split("\\s+");
        StringBuilder sbs = new StringBuilder();
        for(int i = strs.length - 1;i > -1;--i){
        	sbs = sbs.append(strs[i]);
        	if(i != 0)  sbs.append(" ");
        }
        return sbs.toString();
    }
	
	
	/**
	 * 骰子和概率问题
	 * @param number 骰子的个数
	 * @return 各个和的概率
	 */
	//骰子的面数,默认是六个面,从1到6
	private static final int MAX_DICE_VALUE = 6;
	public double[] GetDiceProbability(int number){
		double[] Probability = null;
		if(number < 1) return Probability;
		
		int[][] pProbabilities = new int[2][MAX_DICE_VALUE * number];
		
		int flag = 0;
		//初始化为1
		for(int i = 1;i <= MAX_DICE_VALUE;++i)
			pProbabilities[flag][i] = 1;
		
		for(int k = 2;k <= number;++k){
			for(int i = 0;i < k;++i)
				pProbabilities[1 - flag][i] = 0;
			for(int i = k;i <= MAX_DICE_VALUE*k;++i){
				pProbabilities[1 - flag][i] = 0; 
				for(int j = 1;j <= i && j <= MAX_DICE_VALUE;++j){
					pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
				}
			}
			flag = 1 - flag;
		}
		double total = Math.pow(MAX_DICE_VALUE, number);
		Probability = new double[MAX_DICE_VALUE * number];
		for(int i = 1;i < Probability.length;++i){
			Probability[i] = (double)pProbabilities[flag][i]/total;
		}
		return Probability;
	}
	
	
	/**
	 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,
	 * 2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
	 * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,
	 * 他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”
	 * 不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,
	 * J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
	 * “So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,
	 * 然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
	 * @param numbers
	 * @return
	 */
	public boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length < 1) return false;
		
		ArrayList<Integer> mList = new ArrayList<>();
		for(int i = 0;i < numbers.length;++i){
			System.out.println("---" + numbers[i] + "---:" + numbers[i]);
			mList.add(numbers[i]);
		}
		
		Collections.sort(mList);
		
		Iterator<Integer> i = mList.iterator();
		int zeroNums = 0;
		int firstNum= -1,secondNums = -1;
		while(i.hasNext()){
			Integer temp = i.next();
			System.out.println("---" + temp + "---:" + temp);
			if(temp == 0){
				zeroNums++;
			}else {
				if((firstNum != -1)){
					secondNums = temp;
					if((secondNums - firstNum - 1) <= zeroNums && (secondNums - firstNum) > 0){
						zeroNums-=(secondNums - firstNum - 1);
						firstNum = secondNums;
					}else{
						return false;
					}
				}else{
					firstNum = temp;
				}
			}
		}
		return true;
    }
	
	
	public boolean isContinuous2(int [] numbers) {
		if(numbers == null || numbers.length < 1) return false;
		
		int[] nums = new int[14];
		for(int i = 0;i < numbers.length;++i){
			//System.out.println("---" + numbers[i] + "---:" + numbers[i]);
			if(nums[numbers[i]] > 0 && numbers[i] != 0){
				return false;
			}
			nums[numbers[i]]++;
		}
		
		int zeroNums = nums[0];
		int firstNum= -1,secondNums = -1;
		//System.out.println("---" + zeroNums + "---:" + zeroNums);
		for(int i = 1;i < nums.length;++i){
			int temp = i;
			//System.out.println("---" + temp + "---:" + nums[i]);
			if(nums[i] == 0) continue;
			if((firstNum != -1)){
				System.out.println("---firstNum---:" + firstNum);
				System.out.println("---secondNums---:" + secondNums);
				secondNums = temp;
				if((secondNums - firstNum - 1) <= zeroNums && (secondNums - firstNum) > 0){
					zeroNums-=(secondNums - firstNum - 1);
					firstNum = secondNums;
				}else{
					return false;
				}
			}else{
				firstNum = temp;
			}
		}
		return true;
    }
	
	
	/**
	 * 随机指定一个数m,让编号为0的小朋友开始报数。
	 * 每次喊到m-1的那个小朋友要出列唱首歌,
	 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
	 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
	 * 直到剩下最后一个小朋友,可以不用表演,
	 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,
	 * 哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
	 * 
	 * f(n,m) = (f(n - 1,m) + m) % n
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1)
        	return -1;
        
        int last = 0;
        for(int i = 2;i <= n;++i){
        	last= (last + m) % i;
        }
        return last;
    }
	
	
	/**
	 * 
	求1+2+3+...+n，要求不能使用乘除法、
	for、while、if、else、switch、case
	等关键字及条件判断语句（A?B:C）。
	
	可运用逻辑与的短路特性
	 * @param n
	 * @return
	 */
	public int Sum_Solution(int n) {
		int sum = n;
		boolean a = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
		return sum;
    }
	
	
	/**
	 * 写一个函数，求两个整数之和，要求在函数体内不得使用
	 * +、-、*、/四则运算符号。
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int Add(int num1,int num2) {
        int sum,carry;
        
        do{
        	//求低位的相加的运算结果,不考虑进位
        	sum = num1 ^ num2;
        	//求低位相加后是否有进位,并坐移一位,所有有进位的位都会得到运算
        	carry = (num1 & num2) <<1;
        	num1 = sum;
        	num2 = carry;
        	//将没有进位的相加的结果加上进位的结果,运算和之前一样
        }while(num2 != 0);
        return num1;
     }
	
	
	/**
	 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 
	 * 数值为0或者字符串不是一个合法的数值则返回0
	 * @param str
	 * @return
	 */
	public int StrToInt(String str) {
        if(str == null || str.length() == 0) return 0;
        
        char[] chars = str.toCharArray();
        System.out.println("chars::" + chars);
        boolean minus = false;
        int sum = 0;//默认字符串代表的是一个int类型的值
        int i = 1;
        if(chars[0] == '-'){
        	minus = true;
        }else if(chars[0] == '+'){
        	minus = false;
        }else{
        	i = 0;
        }
        for(;i < chars.length;++i){
        	char temp = chars[i];
        	System.out.println("temp::" + temp);
        	if(isValidChar(temp)){
        		sum = sum * 10 + (temp - '0') * (minus?-1:1);
        		//非法int值
        		System.out.println("sum::" + sum);
        		if(!isValidInt(sum)) return 0;
        	}else{
        		//非法字符
        		return 0;
        	}
        }
		return sum;
    }
	
	private boolean isValidChar(char c){
		if(c > '9' || c < '0') return false;
		return true;
	}
	
	private boolean isValidInt(int i){
		if(i < 0x80000000 || i > 0x7fffffff) return false;
		return true;
	}
	
	private static volatile int SUM_MAX = 0;
	
	

	/**
	 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
	 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
	 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
	 *  例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
	 * 那么对应的输出是第一个重复的数字2
	 * 
	 * 第一种方法,值相同的两个点假如为index,则先将numebrs[index] 加N,
	 * 则地次碰到这个index时,在读numebrs[index],如果大于N,则说明之前出现过
	 * 
	 * 这种方法会改变数组结构,如果要回到原来的值,则需要将大于n的值都减去n
	 * @param numbers
	 * @param length
	 * @param duplication
	 * @return
	 */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	 if(numbers== null || length <= 1) return false;
    	 for(int i = 0;i < length;++i){
    		 int temp = numbers[i];
    		 if(temp >=length){
    			 temp -= length;
    		 }
    		 if(numbers[temp] >= length){
    			 duplication[0] = temp;
    			 return true;
    		 }
    		 
    		 numbers[temp] += length; 
    	 }
		return false;
    }
	
    /**
	 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
	 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
	 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
	 *  例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
	 * 那么对应的输出是第一个重复的数字2
	 * 
	 * 第二种方法,遍历数组,在numbers[i] != i的情况下在此循环判断numbers[i] == numbers[numbers[i]],
	 * 相等就返回,不相等就继续交换两者
	 * 
	 * 这种方式会改变数组内部的值,并且是不可逆的
	 * @param numbers
	 * @param length
	 * @param duplication
	 * @return
	 */
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
    	if(numbers== null || length <= 1) return false;
    	
    	 for(int i = 0;i < length;++i){
	    	 while(numbers[i] != i){
	    		 if(numbers[i] == numbers[numbers[i]]){
	    			 duplication[0] = numbers[i];
	    			 return true;
	    		 }
	    		 int temp = numbers[i];
	    		 numbers[i] = numbers[temp];
	    		 numbers[temp] = temp;
	    		 
	    	 }
    	 }
		return false;
    }
    
    
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     * 不能使用除法
     * 
     *  B0	1	A1	A2	...	 An-2	An-1
     * 
     *  B1	A0	1	A2	...	 An-2	An-1
     * 
     *  B2	A0	A1	1	...	 An-2	An-1
     * 
     * ...	A0	A1	...	 1	 An-2	An-1
     * 
     * Bn-2	A0	A1	...	An-3   1	An-1
     * 
     * Bn-1	A0	A1	...	An-3 An-2	 1	
     * 
     * 分为上三角和下三角,所以分别先递增乘下三角,在递减乘上三角
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
    	if(A == null || A.length == 0) return A;
    	int length = A.length;
    	int[] B = new int[length];
    	B[0] = 1;
    	for(int i = 1 ;i < length;++i){
    		B[i] = B[i - 1] * A[ i - 1];
    	}
    	
    	int temp = 1;
    	for(int i = length - 2;i >= 0; --i){
    		temp *= A[i + 1];
    		B[i] *= temp;
    	}
    	return B;
    }
    
    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，
     * 第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，
     * 第一个只出现一次的字符是"l"。
     */
    private final int MAX_CHARS = 256;
    private final int MAX_TIMES = Integer.MAX_VALUE;
    int[] isAppears = new int[MAX_CHARS];
    int index = 1;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
       if(ch < 0 || ch >255) return;
	   //将出现两次以上置为-1,表示"淘汰"掉,将没有出现的置为index,index还要++,表示将只出现
       //一次的字符按出现顺序编号,若要找最早出现的字符,只需要找最小编号的字符即可
       if(isAppears[ch] == 0){
    	   isAppears[ch] = index++;
       }else{
    	   isAppears[ch] = -1;
       }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	int Times = MAX_TIMES;
    	char c = '#';
    	for(int i = 0; i < 256; ++i){
    		if(isAppears[i] > 0 && isAppears[i] < Times){
    			Times = isAppears[i];
    			c = (char)i;
    		}
    	}
    	return c;
    }
    
    //reset the global value
    private void resetCharsAndIndex(){
    	isAppears = new int[MAX_CHARS];
    	index = 1;
    }
    
    
    /**
     * 在一个排序的链表中，存在重复的结点，
     * 请删除该链表中重复的结点，重复的结点不保留，
     * 返回链表头指针。例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
    	if(pHead == null || pHead.next == null) return pHead;
    	
    	if(pHead.val == pHead.next.val){
    		ListNode node = pHead.next;
    		while(node != null && node.val == pHead.val){
    			node = node.next;
    		}
    		pHead = deleteDuplication(node);
    	} else{
    		pHead.next = deleteDuplication(pHead.next);
    	}
    	return pHead;
    }
    
    
    
    /**
     * 一个链表中包含环，请找出该链表的环的入口结点
     * 
     * 两个指针,一个每次走一步,两一个每次走两步,
     * 如果存在环形结构,则终究两个指针会指向同一个节点
     * 
     * 假设phead 到环入口的长度为x,环的长度为l,相遇点到换入口的的距离为c,则有
     * x = p*l + l - c; 
     * 即 x的长度为p倍的环长度+相遇点逆序到环入口的距离
     * 
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null || pHead.next.next == null) return null;
        ListNode p1 = pHead.next,p2 = pHead.next.next;
        while(p1 != null && p2 != null && p1 != p2){
        	p1 = p1.next;
        	if(p2.next != null){
        		p2 = p2.next.next;
        	}else{
        		return null;
        	}
        }
        
        if(!(p2 != null && p1 == p2)) return null; 
        
        p1 = pHead;
        while(p1 != p2){
        	p1 = p1.next;
        	p2 = p2.next;
        }
        return p1;
    }
    
    
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }    
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * 
     * 需要考虑最少两种情况,该节点有右子树,则下一个节点是节点的的右子树的最左子树
     * 另一种是该节点没有右子树,那就要看当前节点是其父节点的左子树或者右子树了
     * @param pNode
     * @return
     */

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) return null;
        TreeLinkNode TLN = null;
        if(pNode.right != null){
	        TLN = pNode.right;
	        while(TLN.left != null){
	        	TLN = TLN.left;
	        }
	        return TLN;
        }
        
        TLN = pNode;
        while(TLN.next != null){
        	if(TLN.next.left == TLN) return TLN.next;
        	TLN = TLN.next;
        }
		return null;
    }
    
    
    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * 
     * 三种方法:
     * 1,构造这颗树的镜像树,并将其和原树每个节点对比,可采用递归
     * 2,直接递归比较最有子树的是否相同
     * 3,采用先序,中序,后序,层序,等任何一种方式,分为从右到左,在从左到右两次遍历结果,只要输出结果相同则树对称
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        
        return isSymmetrical(pRoot.left, pRoot.right);
    }
    
    private boolean isSymmetrical(TreeNode left	,TreeNode right)
    {
    	if(left == null && right == null) return true;
    	
    	if(left != null && right != null && left.val == right.val){
    		return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    	}else{
    		return false;
    	}
    }
    
    
    
    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     * 
     * 两种方法:
     * 1,两个栈,分别逐个存储每层的数据,然后弹出保存
     * 2,使用一个双向栈,java中可以使用linkdlist,使用null间隔没一层,
     * 	 奇数层时,从头部开始遍历,并将左右孩子从尾部插入,偶数时从尾部开始遍历,并将孩子从头部插入
     * @param pRoot
     * @return
     */
    @SuppressWarnings("unchecked")
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> mLists = new ArrayList<>();
    	if(pRoot == null) return mLists;
    	
    	LinkedList<TreeNode> mlink = new LinkedList<>();
    	TreeNode TN = pRoot;
    	mlink.addFirst(null);
    	mlink.addFirst(TN);
    	boolean isRtl = true;
    	ArrayList<Integer> mList = new ArrayList<>();
    	while(!mlink.isEmpty()){
    		if(isRtl){
    			TN = mlink.removeFirst();
    			if(TN != null){
    				mList.add(TN.val);
    				if(TN.left != null) mlink.addLast(TN.left);
    				if(TN.right != null) mlink.addLast(TN.right);
    			}else{
    				isRtl = !isRtl;
    				mLists.add((ArrayList<Integer>) mList.clone());
    				if(mlink.size() == 0) break;
    				mList.clear();
    				mlink.addFirst(null);
    				System.out.println("mlink.size()::" + mlink.size());
    			}
    		}else{
    			TN = mlink.removeLast();
    			if(TN != null){
    				mList.add(TN.val);
    				if(TN.right != null) mlink.addFirst(TN.right);
    				if(TN.left != null) mlink.addFirst(TN.left);
    			}else{
    				isRtl = !isRtl;
    				mLists.add((ArrayList<Integer>) mList.clone());
    				if(mlink.size() == 0) break;
    				mList.clear();
    				mlink.addLast(null);
    				System.out.println("mlink.size()::" + mlink.size());
    			}
    		}
    		
    	}
		return mLists;
    }
    
    
    
    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * @param pRoot
     * @return
     */
    @SuppressWarnings("unchecked")
	ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> mLists = new ArrayList<>();
    	if(pRoot == null) return mLists;
    	
    	LinkedList<TreeNode> mlink = new LinkedList<>();
    	TreeNode TN = pRoot;
    	mlink.addLast(TN);
    	mlink.addLast(null);//加一个分隔符来区分层次
    	ArrayList<Integer> mList = new ArrayList<>();
    	while(!mlink.isEmpty()){
    		TN = mlink.removeFirst();
    		if(TN != null){
				mList.add(TN.val);
				if(TN.left != null) mlink.addLast(TN.left);
				if(TN.right != null) mlink.addLast(TN.right);
			}else{
				mLists.add((ArrayList<Integer>) mList.clone());
				if(mlink.size() == 0) break;//均没有子节点,则结束遍历
				mList.clear();
				mlink.addLast(null);//继续添加分隔符
			}
    	}
    	return mLists;
    }
    
    private final String DEFAULT_NODE_VALUE = "#";
    public String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return sb.append(DEFAULT_NODE_VALUE).append(",").toString();
        sb.append(root.val);
        sb.append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    
    int index2 = -1;
      TreeNode Deserialize(String str) {
    	  if(str == null || str.length() == 0) return null;
    	  return Deserialize(str.split(","));
    	  
    }
      
	  TreeNode Deserialize(String[] strs) {
		  index2 ++;
		  if(index2 >= strs.length) return null;
		  TreeNode TN= null;
		  if(!DEFAULT_NODE_VALUE.equals(strs[index2])){
	    	  TN = new TreeNode(Integer.parseInt(strs[index2]));
	    	  TN.left = Deserialize(strs);
	    	  TN.right = Deserialize(strs);
		  }
		  return TN;
	  }
      
      
	  /**
	   * 给定一颗二叉搜索树，请找出其中的第k大的结点。
	   * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
	   * @param pRoot
	   * @param k
	   * @return
	   */
	  TreeNode KthNode(TreeNode pRoot, int k){
		  if(pRoot == null || k < 1) return null;
	      return KthNode(pRoot, k, new int[1]);
	  }
      
	  TreeNode KthNode(TreeNode pRoot, int k,int [] count){
		  if(pRoot == null) return null; 
		  TreeNode temp = null;
		  if((temp = KthNode(pRoot.left, k, count)) != null) return temp;
		  count[0]++;
		  if(count[0] == k) return pRoot;
		  if((temp = KthNode(pRoot.right, k, count)) != null) return temp;
		return null;
	  }
      
      
	
	  
	  /**
	   * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
	   * 那么中位数就是所有数值排序之后位于中间的数值。
	   * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
	   * 
	   * 思想:使用两个PriorityQueue,PriorityQueue的内部内部使用对排序,相当于如下情形
	   * |\     	 /|
	   * | \   		/ |
	   * |小	)中位数 (  |大
	   * | /        \ |
	   * |/          \|
	   * @param num
	   */
	  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return 	o2 - o1;
		}
	});
	  int heapCount = 0;
	  public void Insert(Integer num)  {
		if((heapCount & 1) == 1){//当前数据个数是奇数个
			//将大頂堆的顶尖元素取出
			maxHeap.offer(num);
			Integer temp = maxHeap.poll();
			//放到小顶堆中,保证两个頂堆个数相同
			minHeap.offer(temp);
		}else{//当前数据个数是偶数个
			//将小頂堆的顶尖元素取出
			minHeap.offer(num);
			Integer temp = minHeap.poll();
			//放到大頂堆中,保证大頂堆的个数比小頂堆多1
			maxHeap.offer(temp);
		}
		heapCount ++;
    }

	  public Double GetMedian() {
    	if((heapCount & 1) == 0){//当前数据个数是偶数个
			return new Double((minHeap.peek() + maxHeap.peek())) / 2;
		}else{
			return new Double(maxHeap.peek());
		}
    }
	  
	  
	  
    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
     * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     *  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， 
     *  {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
     *  {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     *  
     *  中心思想是确保队列的头部一直是当前队列的最大元素
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
    	ArrayList<Integer> maxWindows  =  new ArrayList<>();
        if(num == null || size < 1 || num.length < size) return maxWindows;
        
        LinkedList<Integer> dequeue = new LinkedList<>();
        for(int i = 0 ;i < num.length;++i){
        	//删除尾部比num[i]小的数值
        	while(!dequeue.isEmpty() && num[dequeue.getLast()] < num[i]){
        		dequeue.removeLast();
        	}
        	//添加新元素
        	dequeue.addLast(i);
        	//如果添加后队列的长度(首尾index之差)大于窗口长度,则删除头元素
        	if(i - dequeue.getFirst() + 1 > size){
        		dequeue.removeFirst();
        	}
        	//如果此时队列尾部的元素index >= size,说明窗口开始滑动了,将头部元素加进去
        	if(i + 1 >= size)
        		maxWindows.add(num[dequeue.getFirst()]);
        }
        return maxWindows;
    }
    
    
    
    
    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，
     * 向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，
     * 则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径
     * ，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
     * 路径不能再次进入该格子。
     * 
     * 
     * 类似与找迷宫出口的问题
     * 思想:
     * 从目标字串的首字串开始找,找到后,分别在他的四周(上下左右)找下一个节字符,重复该过程,
     * 否则回溯到上一个字符的另一个方向.同时需要另开辟一个flag数组,保存当前的字符是否被经过过
     * 典型的回溯法应用,可使用递归法
     * @param matrix 源矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param i 正遍历矩阵的第(i,j)个点
     * @param j
     * @param 遍历目标串的第k个节点
     * @param str 目标串
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
    	if(matrix == null || matrix.length == 0 || 
    		(rows == 0 && cols == 0) || 
    		str == null || str.length == 0) 
    		return false;
    	int [] flag = new int[matrix.length];
    	for(int i = 0;i < rows;++i){
    		for(int j = 0;j < cols; ++j){
    			if(hasPath(matrix, rows, cols, i, j, 0, str ,flag))
    				return true;
    		}
    	}
		return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols, int i , int j, int k, char[] str,int [] flag)
    {	
    	//正在遍历矩阵的第index节点,同时标注flag,1表示经过过
    	int index = cols * i + j;
    	//i 和 j 不能越界,这个点不能经过过,且这个点的字符是想要的字符,符合这些条件可继续向当前的四周遍历
    	if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1){
    		return false;
    	}
    	//目标串的最后一个串找到了,返回
    	if(k == str.length - 1) return true;
    	flag[index] = 1;//经过过
    	if(hasPath(matrix, rows, cols, i - 1, j, k + 1, str, flag)//上
    		|| hasPath(matrix, rows, cols, i + 1, j, k + 1, str, flag)//下
    		|| hasPath(matrix, rows, cols, i, j - 1, k + 1, str, flag)//左
    		|| hasPath(matrix, rows, cols, i, j + 1, k + 1, str, flag))//右
    		return true;
    	//需要回溯到上一个节点,且表示没有经过过
    	flag[index] = 0;
		return false;
    }
    
    
    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
     * 每一次只能向左，右，上，下四个方向移动一格，
     * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols)
    {
    	if(rows == 0 && cols == 0)
    		return 0;
    	if(threshold < 0) return 0;
    	if(threshold == 0) return rows * cols - 1;
    	int[][] flag = new int[rows][ cols];
		return movingCount(threshold, rows, cols, 0, 0,flag);
        
    }
    public int movingCount(int threshold, int rows, int cols,int i,int j,int[][] flag)
    {
    	if(i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] >= 1)
    		return 0;
    	
    	//记录该点的阈值,下次不必重复计算
    	if((caculateSum(i) + caculateSum(j)) > threshold)
    	{
    		flag[i][j] = 2;
    		return 0;
    	}
    	flag[i][j] = 1;//经过了
    	return movingCount(threshold, rows, cols, i - 1, j, flag) + 
    			movingCount(threshold, rows, cols, i + 1, j, flag) + 
    			movingCount(threshold, rows, cols, i, j - 1, flag) + 
    			movingCount(threshold, rows, cols, i, j + 1, flag) + 1;
    }
    
    private int caculateSum(int a){
    	int sum = 0;
    	do{
    		sum += a%10;
    	}while((a = a/10) != 0);
		return sum;
    }
    
}
 