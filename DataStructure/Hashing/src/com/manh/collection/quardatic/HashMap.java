package com.manh.collection.quardatic;

public class HashMap<K, V> implements Map<K, V> 
{


	static final Entry<?, ?>[] EMPTY_TABLE = {};

	/**
	 * The table, resized as necessary. Length MUST Always be a power of two.
	 */
	transient Entry<K, V>[] table = (Entry<K, V>[]) EMPTY_TABLE;
	
	
	public HashMap() 
	{
		table=new Entry[10];
		
	}
	@Override
	public void put(K k, V v) 
	{
		createNewNode(k, v);
	}

	protected int hash(K k)
	{
		return k.hashCode();
	}
	protected int getIndex(int hash , int tlength,int i)
	{
		return (hash+i*i)%tlength;
	}
	
	protected void createNewNode(K k, V v)
	{
		int hash=hash(k);
		int index=getIndex(hash(k) , table.length , 0);
		int i=0;
		boolean bucketFound=false;
		do{
				if(table[index]==null)
				{
					table[index]=new Entry<>(k, v, hash);
					bucketFound=true;
					
				}else{
					hash=hash(k);
					index=getIndex(hash(k) , table.length , ++i);
					if(table[index]==null)
					{
						table[index]=new Entry<>(k, v, hash);
						bucketFound=true;
					}
						
				}
		}while(!bucketFound);

	}
	
	@Override
	public void remove(K k) 
	{
			
	}

	public V get(K k)
	{
		int hash=hash(k);
		int index=getIndex(hash , table.length , 0);
		boolean found=false;
		int i=0;
		do{
			if(table[index].getKey().equals(k))
				found=true;
			else
				index=getIndex(hash , table.length , ++i);
		}while(!found);
		return table[index].getValue();
	}
	
	static class Entry<K,V> implements Map.Entry<K, V>
	{
		K k;
		V v;
		int hash;
		
		Entry(K k , V v , int hash)
		{
			this.k=k;
			this.v=v;
			this.hash=hash;
		}
		
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return this.k;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return this.v;
		}

		@Override
		public V setValue(V value) 
		{
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
