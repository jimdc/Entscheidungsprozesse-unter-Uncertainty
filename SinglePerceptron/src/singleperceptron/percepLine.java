package singleperceptron;

public class percepLine{
	/* 0 coordinates to the bias.
	 * 1 coordinates to weight 1.
	 * 2 coordinates to weight 2.
	 * Misses indicates how many misclassified samples there are.
	 */
	double[] weights = new double[3];
	double slopeVal;
	double biasVal;
	int misses;

	public percepLine(double w0, double w1, double w2){
		weights[0] = w0;
		weights[1] = w1;
		weights[2] = w2;
		slopeVal = -(w1/w2);
		biasVal = (w0/w2);
	}
	
	public double getSlope(){
		return slopeVal;
	}
	
	public double getBias(){
		return biasVal;
	}
	
	public double[] getWeights(){
		return weights;
	}
	
	public void setMisses(int missIn){
		misses = missIn;
	}
	
	public int getMisses(){
		return misses;
	}
	
	public String toString(){
		return ("w0: " + weights[0] + " w1: " + weights[1] + " w2: " + weights[2] + " misses: " + misses +
				"\n\t\tslope: " + slopeVal + " bias/w2: " + biasVal);
	}
}