package com.vedha.collections.heaperror;

import org.apache.commons.io.FileUtils;
import org.openjdk.jol.info.ClassLayout;

public class HeapOutOfMemErrorDemo {

    public static void main(String[] args) {

        // -Xms8m - initial heap size set in jvm
        // -Xmx16m - maximum heap size set in jvm

        System.out.println("free memory in jvm: " + FileUtils.byteCountToDisplaySize(Runtime.getRuntime().freeMemory()));
        System.out.println("total memory allocated to jvm: " + FileUtils.byteCountToDisplaySize(Runtime.getRuntime().totalMemory()));
        System.out.println("maximum memory that jvm can use: " + FileUtils.byteCountToDisplaySize(Runtime.getRuntime().maxMemory()));
        System.out.println("total free memory in jvm: " + FileUtils.byteCountToDisplaySize((Runtime.getRuntime().freeMemory() + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()))));
        String[] array = new String[1000000];

        System.out.println("Array Object Size: " + FileUtils.byteCountToDisplaySize(ClassLayout.parseInstance(array).instanceSize()));
        System.out.println("--array created--");

        System.out.println("free memory in jvm: " + FileUtils.byteCountToDisplaySize(Runtime.getRuntime().freeMemory()));
        System.out.println("total memory allocated to jvm: " + FileUtils.byteCountToDisplaySize(Runtime.getRuntime().totalMemory()));
        System.out.println("maximum memory that jvm can use: " + FileUtils.byteCountToDisplaySize(Runtime.getRuntime().maxMemory()));
        System.out.println("total free memory in jvm: " + FileUtils.byteCountToDisplaySize((Runtime.getRuntime().freeMemory() + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()))));

        // This will throw java.lang.OutOfMemoryError: Java heap space
        // because we are trying to create an array of 10000000 elements
        String[] array2 = new String[10000000];

        System.out.println("Array2 Object Size: " + FileUtils.byteCountToDisplaySize(ClassLayout.parseInstance(array2).instanceSize()));
        System.out.println("--array2 created--");
    }
}
