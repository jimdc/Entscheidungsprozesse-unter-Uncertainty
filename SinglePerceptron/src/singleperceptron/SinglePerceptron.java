package singleperceptron;

import java.util.*;
import singleperceptron.percepLine;

public class SinglePerceptron{
	int MAX_ITER = 500;
	double LEARNING_RATE = .5;
	int NUM_INSTANCES = 100;
	
	ArrayList<percepLine> lineList = new ArrayList<percepLine>();
		
	//double[][] classA = {{0.08, 0.72}, {0.26, 0.58}, {0.45, 0.15}, {0.60, 0.30}};
	//double[][] classB = {{0.1, 1.00}, {0.35, 0.95}, {0.70, 0.65}, {0.92, 0.45}};
	
	double[][] classA = {{0.08, 0.72}, {0.20, 0.50}, {0.24, 0.30}, {0.35, 0.35}, {0.45, 0.50}};
	double[][] classB = {{0.36, 0.75}, {0.52, 0.24}, {0.70, 0.65}, {0.80, 0.26}, {0.92, 0.45}, {0.1, 1.00}, {0.02, 0.48}};
	
	
	percepLine initial = new percepLine(0.2, 1, -1);
	
	public SinglePerceptron(){
		lineList.add(initial);
		for(int i = 0; i < MAX_ITER; i++){
			lineList.add(train(lineList.get(i)));
			System.out.println("===================");
			System.out.println("step: " + i + " info: " + lineList.get(i).toString());
			if(lineList.get(i + 1) == null || (lineList.get(i).getMisses() <= 2)){
				break;
			}
		}
	}
	
	percepLine train(percepLine lineIn){
		int currMisses = 0;
		double w0, w1, w2;
		int visited = 0;
		
		w0 = lineIn.getWeights()[0];
		w1 = lineIn.getWeights()[1];
		w2 = lineIn.getWeights()[2];
		for(int i = 0; i < classB.length; i++){
			if(i < classA.length)
			if(classA[i][1] > (lineIn.getSlope() * classA[i][0] - lineIn.getBias())){
				currMisses++;
			}
			if(classB[i][1] < (lineIn.getSlope() * classB[i][0] - lineIn.getBias())){
				currMisses++;
			}
		}
		if(currMisses == 0){
			return null;
		}
		while(visited < 8){
			Random rand = new Random();
			int select = rand.nextInt(classB.length);
			if(select < 5){
				if(classA[select][1] > (lineIn.getSlope() * classA[select][0] - lineIn.getBias())){
					w0 += LEARNING_RATE;
					w1 += LEARNING_RATE * classA[select][0];
					w2 += LEARNING_RATE * classA[select][1];
					break;
				}
			}
			else{
				select -= classA.length;
				if(classB[select][1] < (lineIn.getSlope() * classB[select][0] - lineIn.getBias())){
					w0 -= LEARNING_RATE;
					w1 -= LEARNING_RATE * classB[select][0];
					w2 -= LEARNING_RATE * classB[select][1];
					break;
				}
			}
		}
		lineIn.setMisses(currMisses);
		percepLine newLine = new percepLine(w0, w1, w2);
		return newLine;
	}
	

	public static void main(String[] args){
		SinglePerceptron testPercep = new SinglePerceptron();
	}
}