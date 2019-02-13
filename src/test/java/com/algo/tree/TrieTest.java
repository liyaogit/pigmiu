package com.algo.tree;

import org.junit.Test;

/**
 * @Auther: yli
 * @Date: 2019/1/9 16:23
 * @Description:
 */
public class TrieTest {
    @Test
    public void testTrieInit(){
        String[][] words = {{"no","没有"}, {"hero","英雄"}, {"in","在"}, {"her","她的"},{"sky","天空"}};
        Trie trie = new Trie();
        Trie.TreeNode node = trie.init(words);
        System.out.println("树的深度优先遍历-----");
        trie.dfsByStack(node);
        System.out.println("树的广度优先遍历-----");
        trie.bfsByQueue(node);

        System.out.println("树的深度优先搜索-----");
        trie.search(node, "hero");
        trie.search(node, "her");
        trie.search(node, "he");
        trie.search(node, "hard");
        trie.search(node, "nose");
    }
}
