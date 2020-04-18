//209011501
//wardashekh yousef
package StackClass;
import StackClass.Stack1;
import java.util.Stack;

public class MainClass { 
 
		private static Stack<Integer> getReverseStack (Stack<Integer> S){
			Stack<Integer> S1 = new Stack<>();
			while(!S.isEmpty())
				S1.push(S.pop());
			return S1;
		}
		
		private static Stack<Integer> getEvenStack(Stack<Integer> S) {
			Stack<Integer> S1 = new Stack<>();
			while(!S.isEmpty()) {
				int val=S.pop();
				if (val%2==0)
					S1.push(val);
			}
			return S1;
		}
		private static Stack<Integer> getMaxStack(Stack<Integer> S) {
			Stack<Integer> S1 = new Stack<>();
			Stack<Integer> S2 = new Stack<>();

		    int max=0;
		    S1.addAll(S);
		    S1=getReverseStack(S1);
		     while(!S.isEmpty())
			{
		    	int val=S.pop();
				if (val>=max) 
					max=val;
			}
		     S2.push(max);
		     while(!S1.isEmpty())
		    	 
			{
		    	int val=S1.pop();
				if(val!=max)
					S2.push(val);
			}	    
	    	return S2;
		}
	    public static void main(String args[]) 
	    { 
	    	Stack<Integer> stack = new Stack<>(); 
	        Stack1 stack1 = new Stack1();
			stack1.push(0);
			stack1.push(1);
			stack1.push(2);
			stack1.push(3);
			stack1.push(6);
			stack1.push(9);
			stack1.push(12); 
			stack1.toString();
			System.out.println(stack1.isEmpty());
			stack1.pop();
			stack.push(0);
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(6);
			stack.push(9);
			stack.push(12);
			stack=getReverseStack(stack);
			System.out.println(stack);
			stack=getEvenStack(stack);
			System.out.println(stack);
			System.out.println(getMaxStack(stack));
	    }
} 
