//209011501
//wardashekh yousef
package StackClass;
public class Stack1 {
	private int[] data; 
	private int top1; 
	public Stack1(){
		top1 = -1; 
		data = new int[7]; 
	} 
	boolean isEmpty(){ 
	        return (top1 < 0); 
	} 

	public void push(int x) {
		if(data.length-1==top1) {
			int[] temp=new int[data.length+5];
			for(int i=0;i<data.length;i++)
				temp[i]=data[i];
			data=temp;
		}
		data[++top1]=x;
	}
	int pop(){ 
        if (top1 < 0){ 
            System.out.println("Stack Underflow"); 
            return 0; 
            } 
        else { 
            int x = data[top1--]; 
            return x; 
            } 
        } 
 
	int Top(){ 
        if (top1 < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
            } 
        else { 
            int x = data[top1]; 
            return x;
            } 
         } 
	@Override
	public String toString() {
		String arr="";
		for(int i=0;i<=top1;i++)
			arr+=(data[i]+" ");
		return arr;
	}
	
} 

