package com.collectionmasterassignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * There is arraylist which contains objects of class BookSale { Book b , int copiesSold }
Book { int bookid , String author , float price } 
There is also a hashmap which contains information about business done by each book.
Map<int bookid , float amount> Map already has information about all books and business
done till now. You can take hardcoded values in map. Write a program to update map using
new information in given array. If book is present in map calculate its business amount (price
* copiessold) and add to existing amount in map. If book is not present add its entry in map.
 */

public class Q1_BookSale {
	Book b;
	int copiesSold;
	
	Q1_BookSale(Book b,int copiesSold)
	{
		this.b=b;
		this.copiesSold=copiesSold;
	}

	@Override
	public String toString() {
		return "Q1_BookSale [b=" + b + ", copiesSold=" + copiesSold + "]";
	}
	
	public static void main(String[] args) {
		ArrayList<Q1_BookSale> bs=new ArrayList<>();
		bs.add(new Q1_BookSale(new Book(1, "gul", 5f), 4));
		bs.add(new Q1_BookSale(new Book(2, "priyanka", 4f), 6));
		bs.add(new Q1_BookSale(new Book(3, "rasika", 6f), 3));
		bs.add(new Q1_BookSale(new Book(4, "neha", 3f), 7));
		bs.add(new Q1_BookSale(new Book(1, "gul", 6f), 2));
		
		HashMap<Integer, Float> hm=new HashMap<>();
		 
		Iterator<Q1_BookSale> itr=bs.iterator();
		while(itr.hasNext())
		{
			Q1_BookSale b1=itr.next();
			int bid=b1.b.bookid;
			float amt=b1.copiesSold*b1.b.price;
			
			Set set=hm.entrySet();
			Iterator itr1=set.iterator();
			while(itr1.hasNext())
			{
				Map.Entry e=(Entry) itr1.next();
				
				int newbid=(int) e.getKey();
				if(bid==newbid)
				{
					float updateamt=(float) e.getValue();
					amt=amt + updateamt;
				}
			}
			hm.put(bid, amt);
		}
		System.out.println(hm);
	}
	

}
