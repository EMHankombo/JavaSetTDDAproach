package com.example.enoch.set;

import java.util.Arrays;

/**
 * Created by mainza1992 on 12/04/2018.
 */

public class CustomSet {

    private static final int MAX_CAPACITY = 10;
    private int[] values;
    //#1B private boolean isEmpty = true;
    private int size = 0;

    public CustomSet() {
        values = new int[MAX_CAPACITY];
    }

    //Initially just return true to make it pass
    public boolean isEmpty() {
        //#1C return isEmpty
        return size == 0;
    }
    //add has to be boolean so it can return false if we try to add a duplicate,set cant have duplicates
    //thinking points: whats my set going to be stored in? array for primitive (private int []values )
    //since its an array we'll need to initialise it (private static final int max_capacity)
    //we'll initialise in the constructor
    //our add method should know when to return true or false,lets create a boolean isEmpty = true;
    //instead of empty returning true,we'll return the isEmpty boolean #1A ******
    public boolean add(int value) {
        //for the duplicate use case
        if (contains(value)) return false;
        //Check if size == MAX_CAPACTIY  increaseSize()
        //when someone adds something,we set the isEmpty to false;
        //*** isEmpty = false;
        //size++;
        //  return true;
        //adding to the array
        values[size] = value;
        size++;
        return true;
    }

    //now we need a variable to keep track of our size class. lets create a variable called size (private int size)
    //this will also have the added benefit of tracking the position in the array. since its an array we need to have a proper push
    //its not an arraylist where you can just call 'add'
    //size needs to be incremented in our add method
    public int size() {
        return size;
    }
//NOTE: if he wants to use void then just ingore the returns
    public boolean remove(int value) {
        //decrement the size
        //size--; //return true;
        //Removing items from array
       for (int i=0; i < values.length; i++) {
           if (values[i]==value) {
               deleteAndReorderArray(i);
               size--;
               return true;
           }
       }
        return false;
    }

    //at this point we need our array to store something
    //follow uncommented add() if not yet implemented
    public boolean contains(int value) {
       for (int i: values) {
           if (i == value) {
               return true;
           }
       }
       return false;
    }


    //AS opposed clustering all this logic lets just create a class to deleteAnd Reorder the array
    //deleting items in an array means that we have to reorder them as we're basically managing it ourselves
    //e.g if I have 5 items in the array and delete the 3rd element,4 and 5 should move a place to the left
    //cant just leave the 3rd item as empty
    private void deleteAndReorderArray(int position){
        for(int i = position; i<size; i++){
            values[i] = values[i+1];
        }
        size--;
    }

    private void increaseArraySize(){
        int newSize = values.length*2;
        values = Arrays.copyOf(values, newSize);
    }
}
