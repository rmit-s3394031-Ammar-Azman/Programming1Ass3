class EquipmentHire {
	// Step 1: Define instance variables required for a Hire
	private String hireID;
	private String hireName;
	private String equipDescription;
	private double hireFee;
	private int hireQty;
	
	// Step 2: Define a constructor that sets up a new Tour
	public EquipmentHire(String hireID, String hireName, String equipDescription, Double hireFee,
	                     int hireQty)
	                     {
		this.hireID = hireID;
		this.hireName = hireName;
		this.equipDescription = equipDescription;
		this.hireFee = hireFee;
		this.hireQty = hireQty;
	 }
	// Step 3 - Define accessors (getters) for each instance variable
	public String hireID()
	{
		return hireID;
	}
	
	public String hireName()
	{
		return hireName;
	}
	
	public String equipDescription()
	{
		return equipDescription;
	}
	
	public double hireFee()
	{
		return hireFee;
	}
	
	public int hireQty(){
		return hireQty;
	}
	public double getHireFee(int hireQty)
	   {
		
	   }
	public void printDetails()
	{
		System.out.printf("%s %s\n", "Hire ID:", hireID);
	      System.out.printf("%s %s\n", "Description:", tourDescription);
	      System.out.printf("%s $%.2f\n", "Tour Fee:", tourFee);
	      System.out.printf("%s %s\n", "Total Bookings:", totalBookings);
	      
	      // call the calculateBookingFees() method to help figure out the
	      // total fees 
	      System.out.printf("%s $%.2f\n", "Total Booking Fees Received:",
	                                      this.calculateBookingFees(totalBookings));
	}
	
}