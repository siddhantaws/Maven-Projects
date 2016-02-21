package com.manh.test;

public class GraphMain 
{
	public static void main(String[] args) 
	{
		Graph<String> graph=new Graph<>(true);
		graph.addEdge("A" , "B" , 5);
		graph.addEdge("A" , "C" , 6);
		graph.addEdge("C" , "D" , 3);
		graph.addEdge("B" , "D" , 2);
		graph.addEdge("D" , "E" , 4);
	}
}
