//package com.MolvenoLakeResort.model.restaurant;
//
//import java.util.Arrays;
//
//public class TimeSlotTest {
//
//    /**
//     *
//     *  The restaurant opens from 8.00 AM until 23.00 PM, so 15 hours per day.
//     *  Time slots consist out of half an hour so 30 time slots in total.
//     *
//     */
//
//    private int opening= 9;
//    private int closing= 23;
//    private int slot= 2;
//
//    int[] booking = new int[(closing - opening) * slot];
//
//    public void main() {
//        // no tables booked
//        Arrays.fill(booking, 0);
//
//        doBooking(3, 0, 8);
//        doBooking(1, 4, 8);
//        doBooking(1, 4, 12);
//    }
//
////    public void doBooking(int tables, int startSlot, int endSlot) {
////        for (int slot= startSlot, slot < endSlot, slot++) {
////            booking[slot] += tables;
////        }
//    }
//
