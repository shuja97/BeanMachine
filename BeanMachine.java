/*
* Bean Machine
* Written by: Muhammad Shuja
* First Written: 11/02/2016
* Last Updated: 13/02/2016
*/

import java.util.Scanner;

public class BeanMachine {
	// Class constants
	private static final char left = 'L';
	private static final char right = 'R';
	private static final char space = ' ';
	private static final char base = '_';
	private static final char ball = '*';

	// Instance Variables
	int balls;
	int buckets;
	int pinLayers;
	int pinElem;
	int midElement;
	double direction;
	int destElem;
	int destBucket;
	int ballHeight;
	int ballsLeft;
	int buckNo;
	int mode;
	int maxValue;
	double mean;
	int[] buckCount;
	char[][] bucketDisp;
	char[][] bucketSet;
	char[][] path;

	// Accessor Methods
	/**
	* @author Muhammad Shuja
	* Accessor, returns the number of balls
	* @return	int 	Number of balls
	*/
	public int getBalls() {
		return balls;
	}

	/**
	* @author Muhammad Shuja
	* Accessor, returns the number of buckets
	* @return	int 	Number of buckets
	*/
	public int getBuckets() {
		return buckets;
	}

	/**
	* @author Muhammad Shuja
	* Accessor, returns a decimal value for the direction of the ball
	* @return	double	Decimal Value for direction
	*/
	public double getDirection() {
		return direction;
	}

	/**
	* @author Muhammad Shuja
	* Accessor, returns an index value for a particular bucket
	* @return 	int 	The bucket index
	*/
	public int getBuckNo() {
		return buckNo;
	}

	/**
	* @author Muhammad Shuja
	* Accessor, returns the number of balls in one bucket
	* @return 	int 	Number of balls in the bucket
	*/
	public int getBallHeight() {
		return ballHeight;
	}

	/**
	* @author Muhammad Shuja
	* Accessor, returns the number of balls left
	* @return 	int 	Number of balls left
	*/
	public int getBallsLeft() {
		return ballsLeft;
	}

	/**
	* @author Muhammad Shuja
	* Accessor, returns the maximum number of balls in a bucket
	* @return 	int 	The maximum number of balls
	*/
	public int getMaxValue() {
		return maxValue;
	}

	/**
	* @author Muhammad Shuja
	* Accessor, returns the mean bucket
	* @return 	double 	The mean bucket
	*/
	public double getMean() {
		return mean;
	}

	/**
	* @author Muhammad Shuja
	* Accessor, returns the modal bucket
	* @return 	int 	the modal bucket
	*/
	public int getMode() {
		return mode;
	}

	// Mutator Methods
	/**
	* @author Muhammad Shuja
	* Mutator, changes number of balls
	* @param 	int 	New number of balls
	*/
	public void setBalls(int ballNo) {
		balls = ballNo;
	}

	/**
	* @author Muhammad Shuja
	* Mutator, changes number of buckets
	* @param 	int 	New number of buckets
	*/
	public void setBuckets(int bucketNo) {
		buckets = bucketNo;
	}

	/**
	* @author Muhammad Shuja
	* Mutator, changes the decimal for direction
	* @param 	double	New decimal for direction
	*/
	public void setDirection (double d) {
		direction = d;
	}

	/**
	* @author Muhammad Shuja
	* Mutator, changes index of bucket
	* @param 	int 	New index of bucket
	*/
	public void setBuckNo (int bNo) {
		buckNo = bNo;
	}

	/**
	* @author Muhammad Shuja
	* Mutator, changes number of balls in a bucket
	* @param 	int 	New number of balls in a bucket
	*/
	public void setBallHeight (int bHeight) {
		ballHeight = bHeight;
	}

	/**
	* @author Muhammad Shuja
	* Mutator, changes number of balls left
	* @param 	int 	New number of balls left
	*/
	public void setBallsLeft (int bLeft) {
		ballsLeft = bLeft;
	}

	/**
	* @author Muhammad Shuja
	* Mutator, changes the maximum number of balls in a bucket
	* @param 	int 	New maxmim number of balls
	*/
	public void setMaxValue (int maxV) {
		maxValue = maxV;
	}

	/**
	* @author Muhammad Shuja
	* Mutator, changes the mean bucket
	* @param 	double 	New mean bucket
	*/
	public void setMean(double me) {
		mean = me;
	}

	/**
	* @author Muhammad Shuja
	* Mutator, changes the modal bucket
	* @param 	int 	New modal bucket
	*/
	public void setMode(int mo) {
		mode = mo;
	}

	//Other Methods
	/**
	* @author Muhammad Shuja
	* Returns 'L' to imply left direction
	* @return 	char 	'L'
	*/
	public char goLeft() {
		return left;
	}

	/**
	* @author Muhammad Shuja
	* Returns 'R' to symbolize right direction
	* @return 	char 	'R'
	*/
	public char goRight() {
		return right;
	}

	/**
	* @author Muhammad Shuja
	* Returns '_' to symbolize the base of the bucket
	* @return 	char 	'_'
	*/
	public char putBase() {
		return base;
	}

	/**
	* @author Muhammad Shuja
	* Returns '*' to symbolize the ball
	* @return 	char 	'*'
	*/
	public char putBall() {
		return ball;
	}

	/**
	* @author Muhammad Shuja
	* Returns ' ' to symbolize an empty
	* @return 	char 	' '
	*/
	public char putSpace() {
		return space;
	}

	/**
	* @author Muhammad Shuja
	* Fills an array of array with either 'L' or 'R' 
	* to track the ball's path
	*/
	public void ballPath() {
		for (int i=0; i<getBalls(); i++) {
			for (int j=0; j<pinLayers-1; j++) {
				direction = (Math.random());
				if ( direction <= 0.5 ) {
					path[i][j] = goLeft();
				}
				else {
					path[i][j] = goRight();
				}
			}
		}
		System.out.println();
		displayPath();
	}

	/**
	* @author Muhammad Shuja
	* Displays the path taken by each ball
	*/
	public void displayPath() {
		System.out.println("Path taken by each ball: ");
		for (char[] layer : path) {
			for (char n : layer) {
				System.out.print(n);
			}
			System.out.println();
		}
	}

	/**
	* @author Muhammad Shuja
	* Counts the number of balls in each bucket
	*/
	public void countBalls() {
		for (int i=0; i<getBalls(); i++) {
			destElem = midElement;
			for (int j=0; j<pinLayers-1; j++) {
				if (path[i][j] == goLeft()) {
					destElem--;
				}
				else {
					destElem++;
				}
			}
			destBucket = destElem/2;
			buckCount[destBucket-1]++;
		}
	}

	/**
	* @author Muhammad Shuja
	* Initializes empty buckets
	*/
	public void initBuckets() {
		for (int i=0; i<getBuckets(); i++) {
			for (int j=0; j<getBalls(); j++) {
				if ( j == getBalls() - 1 ) {
					bucketSet[i][j] = putBase();
				}
				else {
					bucketSet[i][j] = ' ';
				}
			}
		}
		countBalls();
	}

	/**
	* @author Muhammad Shuja
	* Fills the buckets with balls using the count method
	*/
	public void fillBuckets() {
		for (int i=0; i<buckets; i++) {
			setBallHeight(1);
			setBallsLeft(buckCount[i]);
			while ( getBallsLeft() != 0 ) {
				bucketSet[i][(balls-ballHeight)] = putBall();
				setBallsLeft(getBallsLeft() - 1);
				setBallHeight(getBallHeight() + 1);
			}
		}
		displayBuckets();
	}

	/**
	* @author Muhammad Shuja
	* Prints ball distribution in buckets
	*/
	public void displayBuckets() {
		for (int i=0; i<getBalls(); i++) {
			for (int j=0; j<getBuckets(); j++) {
				bucketDisp[i][j] = bucketSet[j][i];
			}
		}

		//Prints ball distribution
		System.out.println("Distribution of balls: ");
		System.out.println();
		for ( int i=(balls-maxValue); i<balls; i++ ) {
			for ( int j=0; j<buckets; j++) {
				System.out.print(' ');
				System.out.print(bucketDisp[i][j]);
			}
			System.out.println();
		}
	}

	/**
	* @author Muhammad Shuja
	* Calculates mode
	*/
	public void calcMode() {
		for ( int n : buckCount ) {
			if ( n > getMaxValue() ) setMaxValue(n);
		}
		for (int i=0; i<getBuckets(); i++) {
			if (getMaxValue() == buckCount[i]) {
				setMode(i+1);
			}
		}
	}

	/**
	* @author Muhammad Shuja
	* Calculate mean
	*/
	public void calcMean() {
		setBuckNo(1);
		for ( int n : buckCount ) {
			setMean(getMean() + (n * getBuckNo()));
			setBuckNo(getBuckNo()+1);
		}
		setMean(getMean() / getBalls());
	}

	/**
	* @author Muhammad Shuja
	* Prints the modal bucket in a statement
	*/
	public String displayMode() {
		return "The modal bucket is " + getMode();
	}

	/**
	* @author Muhammad Shuja
	* Prints the mean bucket in a statement
	*/
	public String displayMean() {
		return "The mean bucket is " + getMean();
	}

	// Constructors
	/**
	* @author Muhammad Shuja
	* Constructor, initializes instance variables for objects
	* of the BeanMachine Class
	*/
	public BeanMachine (int ba, int bu) {
		balls = ba;
		buckets = bu;
		pinLayers = bu;
		pinElem = 2 * (bu) + 1;
		midElement = (pinElem + 1) / 2;
		direction = 0.0;
		destBucket = 0;
		ballsLeft = 0;
		buckNo = 0;
		buckCount = new int[bu];
		bucketDisp = new char[ba][bu];
		bucketSet = new char[bu][ba];
		path = new char[ba][pinLayers-1];
	}

	// Main Program
	public static void main(String[] args) {
		//Scanner Object
		Scanner keyboard = new Scanner(System.in);
		
		//Asks user for number of balls
		System.out.print("Enter no. of balls: ");
		int balls = keyboard.nextInt();

		// Asks user for number of buckets
		System.out.print("Enter no. of buckets: ");
		int buckets = keyboard.nextInt();

		//Bean Machine Object
		BeanMachine game = new BeanMachine(balls, buckets);

		game.ballPath();
		System.out.println();
		game.initBuckets();
		game.calcMode();
		game.calcMean();
		game.fillBuckets();
		System.out.println();
		System.out.println(game.displayMode());
		System.out.println(game.displayMean());
	}
}