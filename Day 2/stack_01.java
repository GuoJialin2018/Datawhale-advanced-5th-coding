package day2;

import java.util.Arrays;

public class stack_01<T> {
	private final int DEFAULT_SIZE=3;
	private int max_size;
	private T[]array;
	private int top=-1;
	public stack_01() {
		this.max_size=DEFAULT_SIZE;
		this.array=(T[])new Object[this.max_size];
		top=-1;
	}
	public stack_01(int size) {
		this.max_size=size;
		this.array=(T[])new Object[this.max_size];
		top=-1;
	}
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		return false;
	}
	public boolean isFull() {
		if(top==array.length-1) {
			return true;
		}
		return false;
	}
	public Object pop() {
		if(isEmpty()) {
			System.out.println("The stack is null！");
			return null;
		}
		T result=(T)array[top];
		array[top]=null;
		top--;
		return result;
	}
	public void push(Object element)throws Exception{
		if(element==null) {
			throw new Exception("The input can not be null");
		}
		if(isFull()) {
			System.out.println("The stack is full");
		}else {
			this.array[++top]=(T)element;
		}
	}
	public Object top() throws Exception{
		if(isEmpty()) {
			System.out.println("The stack is empty!");
			return null;
		}else {
			return this.array[top];
		}
		  
	}
	public int getLength() {
		return this.top;
	}
	public void setEmpty() {
		Arrays.fill(array, null);
		this.top=-1;
		this.max_size=this.DEFAULT_SIZE;
		this.array=(T[])new Object[max_size];
	}
	public static void main(String[] args) throws Exception {
		stack_01<Character> stack=new stack_01<Character>();
		stack.push('a');
		stack.push('b');
		stack.push('c');
		stack.push('d');
		System.out.println(stack.pop());
		// TODO 自动生成的方法存根

	}

}
