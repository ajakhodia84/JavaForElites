package com.javaForElites.practice;

public class GetFunctionTime {

	static String[] names = { "anupam", "dhaanvi", "kavita", "pawan", "kartik", "yogendra", "kiran", "manoj", "sharad",
			"vijay", "hanu", "anupam", "pragya" };
	
	public void findName(String[] name){
		
		/*for (int i=0; i<name.length;i++){
			if(name[i]=="anupam"){
				System.out.println("Anupam found");
			}
		}*/
		
		for(String name1 : name){
			if(name1=="anupam"){
				System.out.println("Anupam found");
			}
		}
	}

	public static void main(String[] args) {
		
		long start1 = System.currentTimeMillis();
		
		GetFunctionTime gft=new GetFunctionTime();
		
		gft.findName(names);
		
		 long end1 = System.currentTimeMillis();
		
		 System.out.println("Elapsed Time in milli seconds: "+ (end1-start1)+" milli seconds"); 
	    
	}

}
