# Posterior-Probabilities
The compute_a_posteriori implements the below task: a. Determine the posterior probability of different hypotheses, given priors for these hypotheses, and given a sequence of observations. b. Determine the probability that the next observation will be of a specific type, priors for different hypotheses, and given a sequence of observations.  The result is then written into a txt file.

The five possible hypotheses for our bag are:
	h1 (prior: 10%): This type of bag contains 100% cherry candies.
	h2 (prior: 20%): This type of bag contains 75% cherry candies and 25% lime candies. 
	h3 (prior: 40%): This type of bag contains 50% cherry candies and 50% lime candies. 
	h4 (prior: 20%): This type of bag contains 25% cherry candies and 75% lime candies. 
	h5 (prior: 10%): This type of bag contains 100% lime candies.

**Output:**
The program creates a text file called "result.txt", that is formatted  as shown below. ??? is used where the program will print values that depend on its command line argument.

  Observation sequence Q: ???
  Length of Q: ???

  After Observation ??? = ???: (This and all remaining lines are repeated for every observation)

	P(h1 | Q) = ???
	P(h2 | Q) = ???
	P(h3 | Q) = ???
	P(h4 | Q) = ???
	P(h5 | Q) = ???

Probability that the next candy we pick will be C, given Q: ???
Probability that the next candy we pick will be L, given Q: ???
