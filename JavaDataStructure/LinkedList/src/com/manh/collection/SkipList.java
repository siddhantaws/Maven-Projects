package com.manh.collection;

import java.util.Random;

public class SkipList {
	public SkipListEntry head; // First element of the top level
	public SkipListEntry tail; // Last element of the top level
	public int n; // number of entries in the Skip List
	public int h; // Height
	public Random r; // Coin toss

	public SkipList() // Constructor...
	{
		SkipListEntry p1, p2;
		/*
		 * ----------------------------------- Create an -oo and an +oo object
		 * -----------------------------------
		 */
		p1 = new SkipListEntry(SkipListEntry.negInf, null);
		p2 = new SkipListEntry(SkipListEntry.posInf, null);
		/*
		 * -------------------------------------- Link the -oo and +oo object
		 * together ---------------------------------------
		 */
		p1.right = p2;
		p2.left = p1;
		/*
		 * -------------------------------------- Initialize "head" and "tail"
		 * ---------------------------------------
		 */
		head = p1;
		tail = p2;
		/*
		 * -------------------------------------- Other initializations
		 * ---------------------------------------
		 */
		n = 0; // No entries in Skip List
		h = 0; // Height is 0

		r = new Random(); // Make random object to simulate coin toss
	}

	/*
	 * ------------------------------------------------------ findEntry(k): find
	 * the largest key x <= k on the LOWEST level of the Skip List
	 * ------------------------------------------------------
	 */

	public SkipListEntry findEntry(String k) {
		SkipListEntry p;

		/*
		 * ----------------- Start at "head" -----------------
		 */
		p = head;
		while (true) {
			/*
			 * ------------------------------------------------ Search RIGHT
			 * until you find a LARGER entry
			 * 
			 * E.g.: k = 34
			 * 
			 * 10 ---> 20 ---> 30 ---> 40 ^ | p must stop here p.right.key = 40
			 * ------------------------------------------------
			 */
			while ((p.right.key) != SkipListEntry.posInf
					&& (p.right.key).compareTo(k) <= 0) {
				p = p.right; // Move to right
			}
			/*
			 * --------------------------------- Go down one level if you can...
			 * ---------------------------------
			 */
			if (p.down != null) {
				p = p.down; // Go downwards
			} else {
				break; // We reached the LOWEST level... Exit...
			}
		}
		return (p);
	}

	/** Returns the value associated with a key. */
	public Integer get(String k) {
		SkipListEntry p;
		p = findEntry(k);
		if (k.equals(p.key))
			return (p.value);
		else
			return (null);
	}

	/** Put a key-value pair in the map, replacing previous one if it exists. */
	public Integer put(String k, Integer v) {
		SkipListEntry p, q;
		int i;
		p = findEntry(k);
		/*
		 * ------------------------ Check if key is found
		 * ------------------------
		 */
		if (k.equals(p.getKey())) {
			Integer old = p.value;

			p.value = v;

			return (old);
		}
		/*
		 * ------------------------ Insert new entry (k,v)
		 * ------------------------
		 */
		q = new SkipListEntry(k, v);
		q.left = p;
		q.right = p.right;
		p.right.left = q;
		p.right = q;
		i = 0; // Current level = 0
		while (r.nextDouble() < 0.5) {
			// Coin flip success: make one more level....
			/*
			 * --------------------------------------------- Check if height
			 * exceed current height. If so, make a new EMPTY level
			 * ---------------------------------------------
			 */
			if (i >= h) {
				SkipListEntry p1, p2;
				h = h + 1;

				p1 = new SkipListEntry(SkipListEntry.negInf, null);
				p2 = new SkipListEntry(SkipListEntry.posInf, null);
				p1.right = p2;
				p1.down = head;
				p2.left = p1;
				p2.down = tail;
				head.up = p1;
				tail.up = p2;

				head = p1;
				tail = p2;
			}
			/*
			 * ------------------------- Scan backwards...
			 * -------------------------
			 */
			while (p.up == null) {
				// System.out.print(".");
				p = p.left;
			}
			p = p.up;
			/*
			 * --------------------------------------------- Add one more (k,v)
			 * to the column ---------------------------------------------
			 */
			SkipListEntry e;

			e = new SkipListEntry(k, null); // Don't need the value...
			/*
			 * --------------------------------------- Initialize links of e
			 * ---------------------------------------
			 */
			e.left = p;
			e.right = p.right;
			e.down = q;
			p.right.left = e;
			p.right = e;
			q.up = e;

			q = e; // Set q up for the next iteration

			i = i + 1; // Current level increased by 1
		}
		n = n + 1;

		return (null);
	}
	public void printHorizontal()
	{
		 String s = "";
	     int i;

	     SkipListEntry p;

	     /* ----------------------------------
		Record the position of each entry
		---------------------------------- */
	     p = head;

	     while ( p.down != null )
	     {
	        p = p.down;
	     }

	     i = 0;
	     while ( p != null )
	     {
	        p.pos = i++;
	        p = p.right;
	     }

	     /* -------------------
		Print...
		------------------- */
	     p = head;

	     while ( p != null )
	     {
	        s = getOneRow( p );
		System.out.println(s);

	        p = p.down;
	     }
	}
	public String getOneRow( SkipListEntry p )
	  {
	     String s;
	     int a, b, i;

	     a = 0;

	     s = "" + p.key;
	     p = p.right;


	     while ( p != null )
	     {
	        SkipListEntry q;

	        q = p;
	        while (q.down != null)
		   q = q.down;
	        b = q.pos;

	        s = s + " <-";


	        for (i = a+1; i < b; i++)
	           s = s + "--------";
	 
	        s = s + "> " + p.key;

	        a = b;

	        p = p.right;
	     }

	     return(s);
	  }
}
