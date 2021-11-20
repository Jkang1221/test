package com.leetCode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class sameTree100 {
    public static void main(String[] args) throws IOException {

    }


}

class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }else if(p.val!=q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
    }
}