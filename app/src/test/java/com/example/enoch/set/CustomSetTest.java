package com.example.enoch.set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by mainza1992 on 12/04/2018.
 */

public class CustomSetTest {
    CustomSet subject;

    @Before
    public void setup(){
        subject = new CustomSet();
    }

    @Test
    public void isEmpty_setEmpty_returnsTrue() {
        Assert.assertTrue(subject.isEmpty());
    }

    @Test
    public void add_elementSuccessfullyAdded_isEmptyReturnsFalse() {
        subject.add(10);
        //now the subject should not be empty hence AssertFalse
        Assert.assertFalse(subject.isEmpty());
    }

    @Test
    public void size_TwoElementsAdded_returnsTwo() {
        subject.add(10);
        subject.add(20);
        Assert.assertEquals(2, subject.size());
    }

    @Test
    public void size_OneElementRemoved_returnsOne() {
        subject.add(10);
        subject.add(20);
        subject.remove(10);
        Assert.assertEquals(1, subject.size());
    }

    @Test
    public void contains_ReturnsTrue() {
        subject.add(10);
        subject.add(20);
        Assert.assertTrue(subject.contains(10));
    }

    @Test
    public void remove_ReturnsTrue() {
        subject.add(10);
        subject.add(20);
        Assert.assertTrue(subject.remove(10));
    }


    @Test
    public void remove_ReturnsFalse() {
        subject.add(10);
        Assert.assertFalse(subject.remove(20));

    }

    @Test
    public void add_Duplicate_ReturnsFalse() {
        subject.add(10);
        Assert.assertFalse(subject.add(10));
    }

}
