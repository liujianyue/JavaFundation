package com.example.dataStructure.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.example.algorithm.CommonAlgorithm.TreeNode;

public class TreeOrder {

	/*
	 *定义树节点
	 */
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
	
	/*
	 *非递归先序遍历二叉树
	 */
	private void PreOrderByLoop(TreeNode Head){
		if(Head == null) return;
		Stack<TreeNode> mStack = new Stack<TreeOrder.TreeNode>();
		TreeNode mTN = Head;
		while(!mStack.isEmpty() || mTN != null){
			if(mTN != null){
				System.out.println(mTN.val);
				mStack.push(mTN.right);
				mTN = mTN.left;
			}else{
				mTN = mStack.pop();
				mTN = mTN.right;
			}
		}
	}
	
	/*
	 * 非递归中序遍历
	 */
	
	private void InOrderByLoop(TreeNode Head){
		if(Head == null) return;
		Stack<TreeNode> mStack = new Stack<TreeOrder.TreeNode>();
		TreeNode mTN = Head;
		while(!mStack.isEmpty() || mTN != null){
			if(mTN != null){
				mStack.push(mTN);
				mTN = mTN.left;
			}else{
				mTN = mStack.pop();
				System.out.println(mTN.val);
				mTN = mTN.right;
			}
		}
	}
	
	
	/*
	 * 非递归后序遍历二叉树
	 */
	
	private void postOrderByLoop(TreeNode Head){
		if(Head == null) return;
		Stack<TreeNode> mStack = new Stack<TreeOrder.TreeNode>();
		TreeNode mTN = Head;
		//需要一个HashMap记录当前几点的右子树是否遍历过
		Map<TreeNode, Boolean> hasTraversedRT = new HashMap<TreeOrder.TreeNode, Boolean>();
		while(!mStack.isEmpty() || mTN != null){
			if(mTN != null){//if语句
				hasTraversedRT.put(mTN, false);
				mStack.push(mTN);
				mTN = mTN.left;//直达树的最左边节点
			}else{//else语句
				mTN = mStack.pop();
				if(hasTraversedRT.get(mTN)){//右子树已经遍历过
					System.out.println(mTN.val);
					mTN = null;//需要走else语句，否则重新走if语句会再次遍历左子树
				}else{//右子树没有遍历过
					hasTraversedRT.put(mTN, true);//标记右子树已遍历过
					mStack.push(mTN);//重新入栈
					mTN = mTN.right;//遍历右子树
				}
			}
		}
	}
	
	/*
	 * 求二叉树的深度
	 */
	public int GetTreeDepth(TreeNode mHead){
		if(mHead == null) return 0;
		int leftDepth = GetTreeDepth(mHead.left);
		int rightDepth = GetTreeDepth(mHead.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	
	/*
	 * 输出二叉树的叶子个数
	 */
	public int getLeafCount(TreeNode mHead){
		if(mHead == null) return 0;
		if(mHead.left == null && mHead.right == null) return 1;
		return getLeafCount(mHead.left) + getLeafCount(mHead.right);
	}
	
	
	/*
	 * 输出二叉树的节点个数
	 */
	public int getTreeSize(TreeNode mHead){
		if(mHead == null) return 0;
		return getTreeSize(mHead.left) + getTreeSize(mHead.right) + 1;
	}
	
	/*
	 * 输出二叉树的层数,相当于深度
	 */
	public int getTreeHeight(TreeNode mHead){
		return GetTreeDepth(mHead);
	}
	
	/*
	 * 二叉树第K层的结点的个数
	 * 相当于求左右子树的第K - 1层的结点的个数之和
	 */
	public int getCountOfKLevel(TreeNode mHead,int k){
		if(mHead == null || k <= 0) return 0;
		if(k == 1) return 1;
		return getCountOfKLevel(mHead.left, k - 1) + getCountOfKLevel(mHead.right, k - 1);
	}
	
	
	/*
	 * 中序线索化二叉树
	 */
	
	
}
