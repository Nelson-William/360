package edu.nelson.mvc;

public class AgeCalculator {
	
	private AgeView theView;
	private AgeModel theModel;
	
	public AgeCalculator(AgeView theView, AgeModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
				
			new AgeView().setVisible(true);
	}

}
