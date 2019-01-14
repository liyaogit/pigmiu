package com.algo.tree;

import java.util.HashMap;

/**
 * @Auther: yli
 * @Date: 2019/1/9 10:18
 * @Description:前缀树/字典树的结点
 */
public class TreeNode {

    public char label; //结点的名称,前缀树里是单个字母
    public HashMap<Character, TreeNode> sons = null;   //使用哈希存放子节点,为了方便确认是否已经添加过某个字母对应的结点
    public String prefix;         //从根到当前的前缀
    public String explanation;   //词条的解释

    //初始化结点
    public TreeNode(char label, String prefix, String explanation) {
        this.label = label;
        this.prefix = prefix;
        this.explanation = explanation;
        this.sons = new HashMap<>();
    }


}
