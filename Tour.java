/*
 * class Tour
 * 
 * This code is a sample solution for Assignment 2
 * in Semester 1, 2015.
 * 
 * You may either use this sample solution as the basis
 * for your group's Assignment 3 program or adapt the 
 * Assignment 3 submission from one of the members of your
 * group as you wish.
 * 
 * Note that this is intended to be an exemplar only - it is
 * not indicative of the only acceptable solution for this task.
 * 
 */
public class Tour
{
   // Step 1: Define instance variables required for a Tour
   private String tourID;
   private String tourDescription;
   private double tourFee;
   private int totalBookings;

   // Step 2: Define a constructor that sets up a new Tour
   public Tour(String tourID, String tourDescription, double tourFee)
   {
      this.tourID = tourID;
      this.tourDescription = tourDescription;
      this.tourFee = tourFee;
   }

   // Step 3 - Define accessors (getters) for each instance variable
   public String getTourID()
   {
      return tourID;
   }

   public String getTourDescription()
   {
      return tourDescription;
   }

   public double getTourFee()
   {
      return tourFee;
   }

   public int getTotalBookingss()
   {
      return totalBookings;
   }

   // Step 4: Define operations that can be performed on a Tour
   
   // addBookings()
   //
   // Attempts to add the specified number of tourists to the
   // total booking count for this Tour and return the booking
   // fees charged.
   //
   // Returns a signal of Double.NaN when the number of tourists
   // specified is not a positive value.
   //
   public double addBookings(int numberOfTourists)
   {
      // check for an invalid number of tourists
      if (numberOfTourists <= 0)
      {
         return Double.NaN;
      }
      else
      {
         // update the total number of bookings for this Tour
         totalBookings += numberOfTourists;
         
         // calculate the total booking fees to be charged
         double totalFees = this.calculateBookingFees(numberOfTourists);
         
         // return the total booking fees amount to the caller
         return totalFees;
      }
   }


   // cancelBookings()
   //
   // Attempts to subtract the specified number of tourists from the
   // total booking count for this Tour and return the booking
   // fees to be refunded accordingly.
   //
   // Returns a signal of Double.NaN when the number of tourists
   // specified is not a positive value OR is greater than the current
   // total number of bookings for this Tour.
   //
   public double cancelBookings(int numberOfTourists)
   {
      if (numberOfTourists <= 0 || numberOfTourists > totalBookings)
      {
         return Double.NaN;
      }
      else
      {
         // update the total number of bookings for this Tour
         totalBookings -= numberOfTourists;
         
         // calculate the total booking fees to be refunded
         double refundedFees = this.calculateBookingFees(numberOfTourists);
         
         // return the total booking fees amount to the caller
         return refundedFees;
      }
   }
   
   // Step 5: Define helper methods that we may need
   
   // calculatBookingFees()
   //
   // Helper method which calculates the total booking fees that
   // apply based on the specified number of tourists
   //
   private double calculateBookingFees(int numberOfTourists)
   {
      return numberOfTourists * tourFee;
   }
   
   // displayTourDetails()
   //
   // Helper method which displays the basic details for this Tour,
   // as well as the total fees received for this Tour.
   public void printDetails()
   {
      System.out.printf("%s %s\n", "Tour ID:", tourID);
      System.out.printf("%s %s\n", "Description:", tourDescription);
      System.out.printf("%s $%.2f\n", "Tour Fee:", tourFee);
      System.out.printf("%s %s\n", "Total Bookings:", totalBookings);
      
      // call the calculateBookingFees() method to help figure out the
      // total fees 
      System.out.printf("%s $%.2f\n", "Total Booking Fees Received:",
                                      this.calculateBookingFees(totalBookings));
   }
}
