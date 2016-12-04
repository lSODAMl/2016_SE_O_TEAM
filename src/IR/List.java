//package IR;

public class List extends Node{
    public int ul = 0;
    public int ol = 0;
    public int li = 0;
    static private int idx = 0;

    // level : the number of indent
    // return 1 - new list is created
    // return 0 - is in the current list status
    // return -1 : it is not list node

    public static boolean IsList(String str) {
        if(str.length() == 0)
            return false;
        char[] arr = str.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] == ' ') {
                count++;
            } else {
                break;
            }
        }

        str = str.substring(count);
        // unordered
        if (str.matches("\\* .*") || str.matches("\\+ .*") || str.matches("- .*")) {
            return true;
        }
        // ordered
        else if (Character.isDigit(arr[count])) {
            str = str.substring(1);
            if (str.matches("\\. .*")) {
                return true;
            }
            else
                return false;
        }
        // not list format
        else
            return false;
    }

    public static int WhatIsLevel(String str,int level){
        char[] arr = str.toCharArray();
        int i = 0, flag = 0;
        for(i = 0;i < str.length(); i++){
            if(arr[i] == ' '){
            }
            else{
                break;
            }
        }

        idx = i;

        // new nested list
        if(i > (level - 1)*2){
            flag = 1;
        }

        else if(i < (level -1)*2){
            flag = i - ((level -1) * 2);
        }

        else
            flag = 0;

        return flag;
    }

    public static int WhatIsType(String str){
        // unordered
        if (str.matches("\\* .*") || str.matches("\\+ .*") || str.matches("- .*")) {
            return 1;
        }

        // ordered
        else
            return 2;
    }

    public static int getIdx(){
        return idx;
    }

    public static void SetIdx(int index){
        idx = index;
    }

    public static boolean IsEndList(String str){
        if(str.length() == 0)
            return true;
        else
            return false;
    }
}
