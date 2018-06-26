/**
 * @author Niya Jaison | UTA ID : 1001562701 | Net ID:nxj2701
 * References:	
 * The compute_a_posteriori implements the below task:
 *   a. Determine the posterior probability of different hypotheses, given priors for these hypotheses, and given a sequence of observations.
 *   b. Determine the probability that the next observation will be of a specific type, priors for different hypotheses, and given a sequence of observations.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class compute_a_posteriori {
	/**
	 * Initializing a list for all the provided values of probabilities
	 * h1 (prior: 10%): This type of bag contains 100% cherry candies.
	 * h2 (prior: 20%): This type of bag contains 75% cherry candies and 25% lime candies. 
	 * h3 (prior: 40%): This type of bag contains 50% cherry candies and 50% lime candies. 
	 * h4 (prior: 20%): This type of bag contains 25% cherry candies and 75% lime candies. 
	 * h5 (prior: 10%): This type of bag contains 100% lime candies. 
	 * */
	
	public static List<Double> priorProbOfBags = Arrays.asList(0.1,0.2,0.4,0.2,0.1);/**The probability for each bag.*/	
	public static List<Double> cherryProbPerBag = Arrays.asList(1.0,0.75,0.50,0.25,0.0);/**The probability of cherry candies in each bag.*/
	public static List<Double> limeProbPerBag = Arrays.asList(0.0,0.25,0.50,0.75,1.0);/**The probability of lime candies in each bag.*/
	public static String Q="";
	public static Integer QLength=0;
	public static String outputToFile="";

	public static void main(String[] args) {
		List<Double> probOfBag=priorProbOfBags;
		Double tempSumCherry=0.0,tempSumLime=0.0;
		if(args.length != 1) {
			System.out.println("The number of arguments should be 1.\n !!Exiting the program..\n");
			System.exit(0);
		}
		Q=args[0];
		QLength=Q.length();

		outputToFile="Observation sequence Q: "+Q;
		outputToFile+="\nLength of Q: "+QLength;

		
		for(int j=0;j<5;j++) {
			tempSumCherry+= (probOfBag.get(j)) * cherryProbPerBag.get(j);
			tempSumLime+=(probOfBag.get(j)) * limeProbPerBag.get(j);
		}
		/**
		 * Repeated for each observation
         */
		for(int i=1;i<=QLength;i++) {
			outputToFile+="\n\nAfter Observation "+i +" = "+Q.charAt(i-1);
			
			if(Q.charAt(i-1)=='C') {
				for(int j=0;j<5;j++) {
					Double temp=((probOfBag.get(j)) * cherryProbPerBag.get(j))/tempSumCherry;/**Calculating the h(j)|Q when Q=C*/

					probOfBag.set(j, temp);
					outputToFile+="\nP(h"+(j+1)+" | Q) = "+String.format("%.10f", temp);
				}
			}
			else {
				for(int j=0;j<5;j++) {
					Double temp=((probOfBag.get(j)) * limeProbPerBag.get(j))/tempSumLime;/**Calculating the h(j)|Q when Q=L*/
					probOfBag.set(j, temp);
					outputToFile+="\nP(h"+(j+1)+" | Q) = "+String.format("%.10f", temp);

				}
			}
			tempSumCherry=0.0;
			tempSumLime=0.0;
			/**Calculating Pt(Qi+1=C or L)*/
			for(int j=0;j<5;j++) {
				tempSumCherry+= (probOfBag.get(j)) * cherryProbPerBag.get(j);
				tempSumLime+=(probOfBag.get(j)) * limeProbPerBag.get(j);
			}

			outputToFile+="\nProbability that the next candy we pick will be C, given Q: "+String.format("%.10f", tempSumCherry);
			outputToFile+="\nProbability that the next candy we pick will be L, given Q: "+String.format("%.10f", tempSumLime);
		}
		writeToFile(outputToFile);
	}
	
	  /**
     * @author Niya Jaison | UTA ID : 1001562701
     * Input : void
     * Output :  void
     * Function: Write the output to a file.
     */
	
	public static void writeToFile(String outputData) {
		System.out.println(outputData);
		try{
			// Create file
			FileWriter fstream = new FileWriter("result.txt",false);/**Uses a fileWriter operator for overwriting the content in the file with the messages pending in the queue*/
			BufferedWriter out = new BufferedWriter(fstream);

			out.write(outputData);/**Writing the output in to the file*/
 

			//Close the output stream
			out.close();/**closing the writer*/
			fstream.close();/**closing the file*/
		}catch (Exception e){//Catch exception if any
			e.printStackTrace();
		}

	}


}
