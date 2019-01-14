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
        TreeNode node = trie.init(words);
        trie.dfsByStack(node);
        trie.search(node, "hero");
        trie.search(node, "her");
        trie.search(node, "he");
        trie.search(node, "hard");
        trie.search(node, "nose");
    }
}
