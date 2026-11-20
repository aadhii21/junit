package com.adhi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class reverseString_test {
    reverseString obj2=new reverseString();
    @Test
    void TEST() {
        //reverseString obj = new reverseString();
        //assertEquals("olleh", obj.reverseString1("hello"));
        assertEquals("AVAJ", obj2.reverseString1("JAVA"));
        assertEquals("MALAYALAM", obj2.reverseString1("MALAYALAM"));
    }
    @Test
    void Test2(){
        assertEquals("ysae si avaJ", obj2.reverseString1("Java is easy"));
    }
}