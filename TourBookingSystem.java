/*
 * class TourBookingSystemV3
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

import java.util.Scanner;

public class TourBookingSystem
{
   // Declare the array of Tour references in which the Tour and
   // GuidedTour objects that the user adds will be stored in and
   // the corresponding tour count.
   //
   // Note that this array and the corresponding counter will be
   // accessible both from within the main method as well as from
   // within any helper methods you may decide to implement.

   private static final Tour[] tours = new Tour[100];
   private static int tourCount = 0;
   private static final EquipmentHire[] hires = new EquipmentHire[100];
   private static int hireCount = 0;

   // Declaring a shared scanner just in case you choose to
   // implement some helper methods in your application class
   // that need access to one.

   private static final Scanner sc = new Scanner(System.in);

   public static void main(String[] args)
   {
      // variables required to process user's menu selection
      String input;
      char selection = '\0';

      // keep repeating the menu until the user chooses to exit
      do
      {
         // display menu options
         System.out.println("******* Tour Booking System Menu *******");
         System.out.println("");
         System.out.println("A - Add New Tour");
         System.out.println("B - Display Tour Summary");
         System.out.println("C - Add Tour Booking(s)");
         System.out.println("D - Cancel Tour Booking(s)");
         System.out.println("E - Add New Guided Tour");
         System.out.println("F - Update Guided Tour Group Size");
         System.out.println("G - Add Equipment Hire Booking");
         System.out.println("H - Display All Equipment Hire Bookings");
         System.out.println("X - Exit Program");
         System.out.println();

         // prompt the user to enter their selection
         System.out.print("Enter your selection: ");
         input = sc.nextLine();

         System.out.println();

         // check to see if the user failed to enter exactly one character
         // for their menu selection

         if (input.length() != 1)
         {
            System.out.println("Error - selection must be a single character!");

         }
         else
         {
            // extract the user's menu selection as a char value and
            // convert it to upper case so that the menu becomes
            // case-insensitive

            selection = Character.toUpperCase(input.charAt(0));

            // process the user's selection
            switch (selection)
            {
               case 'A':
                  
                  // call addTour() helper method
                  addTour();
                  break;

               case 'B':

                  // call displayTourSummary() helper method
                  displayTourSummary();
                  break;

               case 'C':

                  // call addTourBookings() helper method
                  addTourBookings();
                  break;

               case 'D':

                  // call cancelTourBookings() helper method
                  cancelTourBookings();
                  break;

               case 'E':

                  // call cancelTourBookings() helper method
                  addGuidedTour();
                  break;
                  
               case 'F':

                  // call cancelTourBookings() helper method
                  updateTourGroupSize();
                  break;
                  
               case 'G':

                  // call cancelTourBookings() helper method
                  addEquipmentHire();
                  break;
                  
               case 'H':

                  // call cancelTourBookings() helper method
                  displayEquipmentHireSummary();
                  break;
               case 'X':

                  System.out.println("Tour system shutting down ñ goodbye!");
                  break;

               default:

                  // default case - handles invalid selections
                  System.out.println("Error - invalid selection!");

            }
         }
         System.out.println();

      } while (selection != 'X');

   }
   
   /*
    * findTour()
    * 
    * Helper method which attempts to locate a Tour in the tours array
    * with the specified tourID that has been passed in as a parameter.
    * 
    * Returns the matching Tour if one is found, otherwise returns null
    * to indicate a failed search.
    * 
    * You may invoke this helper method wherever a search for a Tour
    * needs to be done elsewhere in the program if you wish.
    */
   private static final Tour findTour(String targetID)
   {
      // temporary Tour reference to be attached to the matching Tour object
      Tour t = null;

      // iterate through Tour objects currently stored in array until
      // match is found or last Tour object has been reached
      for (int i = 0; i < tourCount && t == null; i++)
      {
         // check to see if current Tour object is a match
         if (tours[i].getTourID().equals(targetID))
         {
            t = tours[i];
         }
      }
      
      // if a match was found then this will return that object, otherwise
      // if no match was found then this will return the initial value (null)
      return t;
   }
   
   /*
    * addTour()
    * 
    * Allows the user to enter details for a new Tour and then creates and
    * adds a new Tour object with the specified details to the tours array.
    */
   private static final void addTour()
   {   
      String tourID, desc;
      double tourFee;
      
      // prompt user to enter details for new Tour
      System.out.print("Enter Tour ID: ");
      tourID = sc.nextLine();
      
      System.out.print("Enter Tour description: ");
      desc = sc.nextLine();
      
      System.out.print("Enter Tour fee: ");
      tourFee = sc.nextDouble();
      
      // consume trailing newline
      sc.nextLine();
      
      // create new Tour object and store it in next empty spot in array
      tours[tourCount] = new Tour(tourID, desc, tourFee);
      
      // increment tourCount as we now have one more tour in the array
      tourCount++;
      
      
   }

   /*
    * displayTourSummary()
    * 
    * Iterates through the tours array and displays details for each Tour
    * object currently stored within it.
    */
   private static final void displayTourSummary()
   {
      // iterate through Tour objects currently stored in array
      for (int i = 0; i < tourCount; i++)
      {
         tours[i].printDetails();
         System.out.println();
      }

   }
   
   private static final void addTourBookings()
   {
      Tour t;
      String tourID;
      int tourists;
      double bookingFee;
      
      // prompt user to enter target Tour ID to search for
      System.out.println("Enter Tour ID to add bookings for: ");
      tourID = sc.nextLine();
      
      // use helper method to try to locate a matching Tour in the array
      t = findTour(tourID);
      
      // if the result returned by findTour() was null then the a matching
      // Tour was not found in the array
      if (t == null)
      {
         System.out.println("Error - tour ID \"" + tourID + "\" was not found!");
      }
      else
      {
         
         // inform the user that a matching tour was found - not strictly required
         // but it improves the user-friendliness of the feature a little
         System.out.println("Tour found: " + 
                            t.getTourDescription() + " [" + t.getTourID() + "]");

         //  prompt user for number of bookings to add for the tour in question
         System.out.print("Enter number of tourists to make bookings for: ");
         tourists = sc.nextInt();
         
         // consume trailing newline()
         sc.nextLine();
         
         // attempt to add the specified number of bookings to the matching tour
         // by invoking the addBookings() method and trapping the result it returns
         bookingFee = t.addBookings(tourists);
         
         // check the result returned to determine if the attempt to add
         // bookingsfor the tour failed or was successful
         if (Double.isNaN(bookingFee))
         {
            System.out.println("Error - number of tourists must be >= 0!");
         }
         else
         {
            System.out.printf("Booking successful - booking fee: $%.2f\n", 
                              bookingFee);
         }
      }
   }
   
   private static final void cancelTourBookings()
   {
      Tour t;
      String tourID;
      int tourists;
      double refund;
      
      // prompt user to enter target Tour ID to search for
      System.out.print("Enter Tour ID to cancel bookings for: ");
      tourID = sc.nextLine();
      
      // use helper method to try to locate a matching Tour in the array
      t = findTour(tourID);
      
      // if the result returned by findTour() was null then the a matching
      // Tour was not found in the array
      if (t == null)
      {
         System.out.println("Error - tour ID \"" + tourID + "\" was not found!");
      }
      else
      {
         
         // inform the user that a matching tour was found - not strictly required
         // but it improves the user-friendliness of the feature a little
         System.out.println("Tour found: " + 
                            t.getTourDescription() + " [" + t.getTourID() + "]");

         //  prompt user for number of bookings to add for the tour in question
         System.out.print("Enter number of tourists to cancel bookings for: ");
         tourists = sc.nextInt();
         
         // consume trailing newline()
         sc.nextLine();
         
         // attempt to cancel the specified number of bookings to the matching tour
         // by invoking the cancelBookings() method and trapping the result it returns
         refund = t.cancelBookings(tourists);
         
         // check the result returned to determine if the attempt to cancel
         // bookings for the tour failed or was successful
         if (Double.isNaN(refund))
         {
            System.out.println("Error - number of tourists must be >= 0 AND " +
                               "cannot exceed than total bookings for tour!");
         }
         else
         {
            System.out.printf("Cancellation successful - refund due: $%.2f\n", 
                              refund);
         }
      }
   }
   

   /***********************************************
    * Helper methods for Assignment 3 Menu Features
    ************************************************/

   /*
    * Helper method for the Add New Guided Tour feature
    */
   private static void addGuidedTour()
   {

      System.out.println("Add New Guided Tour Option Selected!");
      
      // remove the println() above (and this comment) and implement 
      // your code for this feature here...

   }
   
   /*
    * Helper method for the Update Tour Group Size feature
    */
   private static void updateTourGroupSize()
   {
      System.out.println("Update Tour Group Size Option Selected!");
      
      // remove the println() above (and this comment) and implement 
      // your code for this feature here...
      
   }
   
   /*
    * Helper method for the Add Equipment Hire Booking feature
    */
   private static void addEquipmentHire()
   {
      System.out.println("Add Equipement Hire Booking Option Selected!");
      
      // remove the println() above (and this comment) and implement 
      // your code for this feature here...
      
   }

   /*
    * Helper method for the Display All Equipment Hire Bookings feature
    */
   private static void displayEquipmentHireSummary()
   {
      System.out.println("Display All Equipement Hire Bookings Option Selected!");
      
      // remove the println() above (and this comment) and implement 
      // your code for this feature here...
      
   }
}
