import java.io.*;
import java.lang.*;
import java.util.*;
class ParseTree3{
	static String str;
	static int ptr;
	static int step;
	static BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
	static void print(String s){
		step++;
		System.out.println(step + "\t" + str.charAt(ptr) + "\t" + s +"\t"+"\t"+str.substring(ptr));
	}
	static void match(char s) {
		 if(str.charAt(ptr)==s){
			ptr++;
			if(str.charAt(ptr)==' '){
				ptr++;
			}
		}else{
		System.out.println("--------------------------rejected!");
		System.exit(0);
		}
	}
	static void A(){
		if(str.charAt(ptr)=='~'||str.charAt(ptr)=='('||str.charAt(ptr)=='0'||str.charAt(ptr)=='1'){
			print("A--> BA1");
			B();
			A1();
		}else{
			System.out.println("error: the "+(ptr+1)+" character is error!");
			System.out.println("error: A--> BA1");
			System.out.println("-------------------------rejected!");
			System.exit(0);
		}
	}
	static void A1(){
		if(str.charAt(ptr)=='|'){
			print("A1--> v BA1");
			match('|');
			B();
			A1();
		}else if(str.charAt(ptr)==')'||str.charAt(ptr)=='#'){
			print("A1-->null");
		}else{
			System.out.println("error: the "+(ptr+1)+" character is error");
			System.out.println("error: A1--> v BA1|null");
			System.out.println("---------------------------rejected!");
			System.exit(0);
		}
	}
	static void B(){
		if(str.charAt(ptr)=='~'||str.charAt(ptr)=='('||str.charAt(ptr)=='0'||str.charAt(ptr)=='1'){
			print("B--> CB1");
			C();
			B1();
		}else{
			System.out.println("error: the "+(ptr+1)+" character is error!");
			System.out.println("error: B--> CB1");
			System.out.println("----------------------------rejected!");
			System.exit(0);
		}
	}
	static void B1(){
		if(str.charAt(ptr)=='&'){
			print("B1--> ^ CB1");
			match('&');
			C();
			B1();
		}else if(str.charAt(ptr)=='|'||str.charAt(ptr)==')'||str.charAt(ptr)=='#'){
			print("B1-->null");

		}else{
			System.out.println("error: the "+(ptr+1)+" character is error!");
			System.out.println("error: B1--> ^ CB1|null");
			System.out.println("-------------------------------rejected!");
			System.exit(0);
		}
	}
	static void C(){
		if(str.charAt(ptr)=='~'){
			print("C--> ~ D");
			match('~');
			D();
		}else if(str.charAt(ptr)=='('||str.charAt(ptr)=='0'||str.charAt(ptr)=='1'){
			print("C-->D");
			D();
		}else{
			System.out.println("error: the "+(ptr+1)+" character is error!");
			System.out.println("error: C--> ~D|D");
			System.out.println("--------------------------------rejected!");
			System.exit(0);
		}	
	}
	static void D(){
		if(str.charAt(ptr)=='('){
			print("(A)");
			match('(');
			A();
			match(')');
		}else if(str.charAt(ptr)=='0'){
			print("0");
			match('0');
		}else if(str.charAt(ptr)=='1'){
			print("1");
			match('1');
		}else if(str.charAt(ptr)=='|'||str.charAt(ptr)==')'||str.charAt(ptr)=='#'||str.charAt(ptr)=='&'){

		}else{
			System.out.println("error: the "+(ptr+1)+" haracter is error!");
			System.out.println("error: D-->0|1|(A)");
			System.out.println("----------------------------------rejected!");
			System.exit(0);
		}
	}
	static String getString(String info){
		String temp=null;
		
		System.out.print(info);
		try{
			temp=buf.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return temp;
	}
	public static void main(String[]args){
		boolean flag=true;
		while(flag){
		str=getString("please input the String:");
		ptr=step=0;
		A();
		System.out.println("----------------------------------accepted!");


	}
	}

}


