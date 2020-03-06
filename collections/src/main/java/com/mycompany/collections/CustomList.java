package com.mycompany.collections;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CustomList<E>
{
	private int size = 0;
	
	private int defaultSize = 10;
	
	private Object[] elements;
	
	public CustomList()
	{
		elements = new Object[defaultSize];
	}
	
	public void add(int value)
	{
		if(size == elements.length)
			increaseSize();
		elements[size++] = value;
	}
	
    private void increaseSize() 
    {
    	int newSize = elements.length+1;
    	elements = Arrays.copyOf(elements,newSize);
	}

    public E get(int i)
    {
    	try 
    	{
    		if (i>size || i<0)
    			throw new IndexOutOfBoundsException();
    	}
    	catch(IndexOutOfBoundsException e)
    	{
    		System.out.println("Given index os out of bound");
    	}
    	return (E) elements[i];
    }
    
    public E remove(int i)
    {
    	try 
    	{
    		if (i>size || i<0)
    			throw new IndexOutOfBoundsException();
    	}
    	catch(IndexOutOfBoundsException e)
    	{
    		System.out.println("Given index os out of bound");
    	}
    	Object ele = elements[i];
    	int num = elements.length-(i+1);
    	System.arraycopy(elements,i+1,elements,i,num);
    	size--;
    	return (E) elements[i];
    }
    
    public int size()
    {
    	return size;
    }
    
    public String print()
    {
    	StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size ;i++) 
        {
            sb.append(elements[i].toString());
            if(i<size-1)
            {
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }
	public static void main( String[] args )
    {
		Scanner scan = new Scanner(System.in);
        CustomList<Integer> custominput = new CustomList<>();
        
        custominput.add(10);
        custominput.add(20);
        custominput.add(30);
        custominput.add(40);
        custominput.add(50);
        custominput.add(60);
        custominput.add(70);
        custominput.add(80);
        custominput.add(90);
        custominput.add(100);
        
        
        System.out.println(custominput.print());
        
        while(true)
        {
        	System.out.println("\n1.Insert\n2.Delete\n3.Display\n4.Fetch\n5.Exit");
        	int ch = scan.nextInt();
        	if(ch==1)
        	{
        		System.out.println("Enter the element you want to insert");
        		int ele = scan.nextInt();
        		custominput.add(ele);
        	}
        	if(ch==2)
        	{
        		System.out.println("Enter the index at which you want to delete");
        		int ele = scan.nextInt();
        		custominput.remove(ele);
        	}
        	if(ch==3)
        	{
        		System.out.println(custominput.print());
        	}
        	if(ch==4)
        	{
        		System.out.println("Enter the index at which you want to fetch element");
        		int ele = scan.nextInt();
        		System.out.println(custominput.get(ele));
        	}
        	if(ch==5)
        	{
        		System.exit(0);
        	}
        }
    }
}
