package com.algo.tree;

import org.apache.commons.lang.StringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: yli
 * @Date: 2019/1/9 14:51
 * @Description:
 */
public class Trie {

    public TreeNode init(String[][] words){
        TreeNode root = new TreeNode('&', "", "" );
        for (String[] word : words){
            String singleWord = word[0];
            TreeNode found = root;
            for (int i = 0; i < singleWord.length(); i ++){
                char c = singleWord.charAt(i);
                if (found.sons.containsKey(c)){
                    found = found.sons.get(c);
                }else {
                    TreeNode son = new TreeNode(c, found.prefix+c, "");
                    found.sons.put(c, son);
                    found = son;
                }
                //最后一个字符结点写上单词解释
                if (i == singleWord.length() - 1){
                    found.explanation = word[1];
                }
            }
        }
        return root;
    }

    public void dfsByStack(TreeNode root){
        //递归中间变量消耗内存,用栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);  //压入根结点
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.sons.size()==0){
                //已经是叶子结点了,输出
                System.out.println(node.prefix + node.explanation);
            }else {
                if (!StringUtils.isEmpty(node.explanation)){
                    System.out.println(node.prefix + node.explanation);
                }
                //非叶子节点,遍历它的每个子结点
                Iterator<Map.Entry<Character, TreeNode>> iterator= node.sons.entrySet().iterator();
                //这里的叶子结点是倒序,可以利用临时栈调整顺序
                while (iterator.hasNext()){
                    stack.push(iterator.next().getValue());
                }
            }
        }
    }

    public void search(TreeNode root, String word){
        TreeNode found = root;
        for (int i = 0; i < word.length(); i ++){
            if (!found.sons.containsKey(word.charAt(i))){
                System.out.println(word + "字典遍历中,没有这个单词");
                break;
            }
            found = found.sons.get(word.charAt(i));
            if (i == word.length() - 1){
                String explanation = StringUtils.isEmpty(found.explanation)? "单词遍历结束,无此单词" : found.explanation;
                System.out.println(word + explanation);
            }else if (found.sons.size() == 0){
                System.out.println(word + "字典遍历结束,无此单词");
                break;
            }
        }

    }
}
