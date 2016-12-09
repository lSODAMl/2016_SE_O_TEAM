//package IR;

public class HorizontalBar extends Node{

    public static boolean IsHorizontal(String str){

        str = str.replaceAll(" ","");
        int count = 0;
        boolean check = true;
        char temp = 0;
        for(int j=0;j<str.length();j++){
        	if(j==0){
        		if(str.charAt(j)=='*'){
        			count++;
        			temp = '*';
        		}else if(str.charAt(j) == '-'){
        			count++;
        			temp = '-';
        		}else if(str.charAt(j) == '='){
        			count++;
        			temp = '=';
        		}else{
        			check = false;
        			break;
        		}
        	}else{
        		if(!(str.charAt(j) == temp)){
        			check = false;
        			break;
        		}else{
        			count++;
        		}
        	}
        	
        }
        
        if(count < 3){
        	check = false;
        }
        
        System.out.println(count);
        System.out.println("check"+check);
       
        return check;


    }

}