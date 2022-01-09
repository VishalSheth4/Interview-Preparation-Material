/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndofWord;
        
        TrieNode(){
            isEndofWord = false;
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }
    static TrieNode root;
    static void insert(String key){
        int level;
        int length = key.length();
        int index;
        
        TrieNode pCrawl = root;

        for( level=0;level<length;level++){
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] ==null){
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndofWord = true;
    }
    public static boolean search(String s){
        int level;
        int length = s.length();
        int index;
        TrieNode pCrawl = root;
        for(level=0;level<length;level++){
            index = s.charAt(i)-'a';
            if(pCrawl.children[index]==null){
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl.isEndofWord);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String keys[] = {"the", "a", "there", "answer", "any","by", "bye", "their"};
		root = new TrieNode();
		for(int i=0;i<keys.length;i++){
		    insert(keys[i]);
		}
		if(search("the") == true)
            System.out.println("the --- true");
	}
}
