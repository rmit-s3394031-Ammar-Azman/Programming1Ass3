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
	
	
}