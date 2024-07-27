/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.collectionsapp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author aadik
 */
public class CollectionsApp {

    public static void main(String[] args) {
        String [] names = {"Wayne","Damien","Muhammed", "Simphiwe", "Muhammed", "Aadil", "Dineo", "Abdul", "Kat","Aqeel"};
        CollectionsApp cApp = new CollectionsApp();
        
        cApp.listCollections(Arrays.asList(names));
        cApp.queueCollections(Arrays.asList(names));
        cApp.setCollections(Arrays.asList(names));
        cApp.mapCollections(names);
    }
    
    public void foreachDisplay(Collection <String> list){
        for(String name:list){
            System.out.printf("%-15s", name);            
        }
        System.out.println();
    }
    
    public void iteratorDisplay(Collection <String> list){
        Iterator<String> iterator = list.iterator();
        
        while(iterator.hasNext()){
            System.out.printf("%-15s", iterator.next());            
        }
        System.out.println();
    }
    
    public void mapCreate(Map<String,Integer> map, String[] names, int [] marks){
        for (int i=0; i<names.length;i++){
            map.put(names[i], marks[i]);
        }      
    }
    
    public void mapforDisplay(Map<String, Integer> map){
        System.out.printf("%-20s%4s%n","Name","Mark");
        for(String key : map.keySet()){
            System.out.printf("%-20s%4s%n", key,map.get(key));
        }
    }
    
    public void mapentryIterator(Map<String, Integer> map){
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        
        System.out.printf("%-20s%4s%n","Name","Mark");
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.printf("%-20s%4s%n",entry.getKey(),entry.getValue());           
        }
    }
    
    public void listCollections(Collection<String> list){
        ArrayList<String> arrayList = new ArrayList<>(list);
        
        //Array List
        System.out.println("*".repeat(150)); 
        System.out.printf("%72s%n","ARRAY LIST");
        System.out.println("Array List Created: ");        
        foreachDisplay(arrayList);
        Collections.sort(arrayList);
        System.out.println("Array List After Sorting: ");        
        iteratorDisplay(arrayList);
        System.out.printf("Array has %d elements.%n", arrayList.size());
        System.out.println("Array List After Removing Some Elements: ");
        arrayList.removeAll(arrayList.subList(7, 8));
        foreachDisplay(arrayList);
        System.out.printf("Array has %d elements.%n", arrayList.size());
        System.out.println("*".repeat(150));
        
        //Linked List
        System.out.println("*".repeat(150));
        System.out.printf("%72s%n","LINKED LIST");
        LinkedList<String> linkedList = new LinkedList<>(list);
        System.out.println("Linked List Created: ");
        foreachDisplay(linkedList);
        linkedList.addFirst("Rashford");
        System.out.println("Linked List after adding element to the front: ");
        foreachDisplay(linkedList);
        linkedList.removeFirstOccurrence("Muhammed");
        System.out.println("Linked List after removing duplicate: ");
        foreachDisplay(linkedList);
        System.out.println("Linked List after printing in reverse: ");
        // reverses linked list
        Iterator<String> iterator = linkedList.descendingIterator();
        LinkedList<String> reverseList = new LinkedList<>();
        
        iterator.forEachRemaining(reverseList::add);
        iteratorDisplay(reverseList);
        System.out.println("*".repeat(150));      
    }
    
    public void queueCollections(Collection queue){
        ArrayDeque<String> arrayDeque = new ArrayDeque<>(queue);
        
        System.out.println("*".repeat(150));
        System.out.printf("%72s%n","ARRAY DEQUE");
        System.out.println("Array Deque Created: ");
        foreachDisplay(arrayDeque);
        System.out.println("Frequency of Element \"Muhammed\" in Array Deque: " + Collections.frequency(arrayDeque, "Muhammed"));
        System.out.println("What is the element on the tail of the Array Deque: " + arrayDeque.peekLast());
        System.out.printf("The Element %s has %s added to the Array Deque%n", "Modiri",arrayDeque.offer("Modiri")?"been":"NOT been");
        System.out.println("Array Deque after adding another element: ");
        iteratorDisplay(arrayDeque);
        System.out.println("*".repeat(150));
        
        System.out.println("*".repeat(150));
        System.out.printf("%72s%n","PRIORITY QUEUE");
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(queue);
        System.out.println("Priorirty Queue Created: ");
        foreachDisplay(priorityQueue);
        System.out.println("The minimum element is: " + Collections.min(priorityQueue));
        System.out.println("The front element is: "+ priorityQueue.peek());
        System.out.printf("The Element \'%s\' has been removed from the Priority Queue%n",priorityQueue.poll());
        System.out.println("PQ after polling element: ");
        iteratorDisplay(priorityQueue);
        System.out.println("*".repeat(150));        
    }
    
    public void setCollections(Collection<String> values){
        HashSet<String> hashSet = new HashSet<>(values);
        
        System.out.println("*".repeat(150));
        
        System.out.printf("%72s%n","HASH SET");
        System.out.println("Hash Set Created: ");
        foreachDisplay(hashSet);
        System.out.printf("The Hash Set %s %s%n", hashSet.contains("Chris")?"Contains":"Does not contain","\"Chris\"");
        System.out.printf("\"Wayne\" has %s removed from the Hash Set %n", hashSet.remove("Wayne")?"been":"Not been");
        System.out.printf("\"Chris\" has %s added from the Hash Set %n", hashSet.add("Chris")?"been":"Not been");
        System.out.println("Modified Hash Set: ");
        iteratorDisplay(hashSet);
        
        System.out.println("*".repeat(150));
        TreeSet<String> treeSet = new TreeSet<>(values);
        System.out.printf("%72s%n","TREE SET");
        System.out.println("Tree Set Created: ");
        foreachDisplay(treeSet);
        System.out.println("Print the front four names: ");
        iteratorDisplay(treeSet.headSet("Dineo"));
        System.out.println("Print the last five names: ");
        iteratorDisplay(treeSet.tailSet("Dineo"));
        System.out.printf("%s has %s removed from the Tree Set%n", treeSet.pollLast(), treeSet.pollLast()!=null?"been":"Not been");
        System.out.printf("\"Kopano\" has %s added to the Tree Set%n", treeSet.add("Kopano")?"been":"Not been");
        System.out.println("Tree Set after modifications: ");
        iteratorDisplay(treeSet);
        System.out.println("*".repeat(150));
    }
    
    public void mapCollections(String [] names){
        int [] marks = new int[]{55,87,63,76,59,91,70,70,45,52};
        Map<String, Integer> hashMap = new HashMap<>();
        mapCreate(hashMap,names,marks);
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        
        System.out.println("*".repeat(150));
        System.out.printf("%72s%n","HASH MAP");
        System.out.println("Hash Map Created: ");
        mapforDisplay(hashMap);
        System.out.printf("\nAadil's mark has changed from %d to a new mark%n",hashMap.put("Aadil", 99));
        System.out.printf("Wayne's entry with a mark of %d has changed%n", hashMap.remove("Wayne"));
        System.out.println("\nHash Map after the changes: ");
        mapentryIterator(hashMap);
        System.out.println("*".repeat(150));
        
        System.out.println("*".repeat(150));
        System.out.printf("%72s%n","TREE MAP");
        System.out.println("Tree Map Created");
        mapforDisplay(treeMap);
        System.out.printf("The last student entry in the Tree Map is %s.%n",treeMap.lastEntry());
        System.out.println("Print the last five Tree Map entries: ");
        mapentryIterator(treeMap.tailMap("Dineo"));
        System.out.printf("The first student entry %s in the Tree Map has been removed.%n",treeMap.pollFirstEntry());
        System.out.println("Tree Map after modifications: ");
        mapentryIterator(treeMap);
        System.out.println("*".repeat(150));     
    }
    
}
