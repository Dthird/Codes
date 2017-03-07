package util;

import java.util.LinkedList;

/**
 * Created by jason on 3/7/17.
 */
public class MTrie {
    private TrieNode root;
    public MTrie(){
        root = new TrieNode(' ');
    }

    public void insert(String s){
        if (search(s)){
            return;
        }
        TrieNode p = root;
        for (char c: s.toCharArray()) {
            if (p.subNode(c) == null){
                p.childList.add(new TrieNode(c));
            }
            p = p.subNode(c);
            p.count++;
        }
        p.isEnd = true;
    }

    public void delete(String s){
        if(search(s) == false){
            return;
        }

        TrieNode p = root;
        for(char c : s.toCharArray()) {
            TrieNode child = p.subNode(c);
            if(child.count == 1) {
                p.childList.remove(child);
                return;
            } else {
                child.count--;
                p = child;
            }
        }
        p.isEnd = false;
    }

    public boolean search(String s){
        TrieNode p = root;
        for (char c : s.toCharArray()){
            if (p.subNode(c) == null){
                return false;
            } else{
                p = p.subNode(c);
            }
        }

        return p.isEnd ? true : false;
    }

    public static void main(String[] args){
        MTrie trie = new MTrie();
        trie.insert("ball");
        trie.insert("balls");
        trie.insert("sense");

        // testing deletion
        System.out.println(trie.search("balls"));
        System.out.println(trie.search("ba"));
        trie.delete("balls");
        System.out.println(trie.search("balls"));
        System.out.println(trie.search("ball"));
    }


}

class TrieNode{
    protected char content; // the character in the node
    protected boolean isEnd; // whether the end of the words
    protected int count;  // the number of words sharing this character
    protected LinkedList<TrieNode> childList; // the child list

    public TrieNode(char c){
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }

    public TrieNode subNode(char c){
        if(childList != null){
            for(TrieNode eachChild : childList){
                if(eachChild.content == c){
                    return eachChild;
                }
            }
        }
        return null;
    }
}
