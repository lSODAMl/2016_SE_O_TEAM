package IR;

public class HorizontalBar extends Node{

    public static boolean IsHorizontal(String str){
    	// alphabet 있는지 없는 지 학인
        str = str.replaceAll(" ","");
        System.out.println(str);
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
        			System.out.println("1");
        			check = false;
        			break;
        		}
        	}else{
        		if(!(str.charAt(j) == temp)){
        			System.out.println(j+"here");
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