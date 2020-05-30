package Assignment4;

//Class for IllegalInputException (when you enter something other than A,C,T,G into sequence
class IllegalInputException extends Exception {
	public IllegalInputException(char c) {
		super("Character input is invalid.");
	}

}

public class Genome {
	// ----------
	// ATTRIBUTE OF GENOME
	private String sequence;
	private String species;
	private int numGenes;

	// ----------
	// GETSEQUENCE METHOD -> get sequence
	public String getSequence() {
		return this.sequence;
	}

	// ----------
	// GETSPECIES METHOD -> get species
	public String getSpecies() {
		return this.species;
	}

	// ----------
	// GETNUMGENES METHOD -> get numGenes
	public int getNumGenes() {
		return this.numGenes;
	}

	// ----------
	// CONSTRUCTOR -> get two String parameters
	public Genome(String sequence, String species) throws IllegalInputException {
		// Assign species
		this.species = species;

		// Assign sequence
		// Check sequence character by character
		for (int i = 0; i < sequence.length(); i++) {
			char c = sequence.charAt(i);
			// If any character not A,C,T,G, throw exception and break
			if (!checkNucleotide(c)) {
				throw new IllegalInputException(c);
			}
		}
		// If all characters A,C,T,G, assign sequence
		this.sequence = sequence;
	}

	// ----------
	// CHECKNUCLEOTIDE METHOD -> check if characters of sequence are valid
	public boolean checkNucleotide(char c) {
		// Initialize result as true
		Boolean result = true;

		// Check sequence letter by letter
		// If letter is not A, C, G, or T (all capital), then result = false
		if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
			result = false;
		}
		return result;
	}

	// ----------
	// TOSTRING METHOD -> overwrite default toString() method
	public String toString() {
		String info = "";
		// If number of genes not computed yet, print other attributes but
		// numGenes
		if (numGenes == 0) {
			System.out.println(
					"The number of genes has not been computed for the genome. There is no information about the number of genes at this time.");
			info = "Sequence: " + this.sequence + ", Species: " + this.species;
			System.out.println(info);
			return info;
		}

		// If number of genes computed, print all 3 attributes
		else {
			info = "Sequence: " + this.sequence + ", Species: " + this.species + ", Number of genes: " + this.numGenes;
			System.out.println(info);
			return info;
		}
	}

	// ----------
	// ADDNUCLEOTIDE METHOD -> add nucleotide
	public String addNucleotide(char c, int index) throws IllegalInputException {
		// Retrieve sequence
		this.sequence = getSequence();

		// Create char array for sequence w/ length sequence.length() + 1
		char[] addedSeqChar = new char[sequence.length() + 1];

		// Create char array for sequence chars
		char[] sequenceChar = sequence.toCharArray();

		// Check if nucleotide legal (is A,C,T,G)
		if (checkNucleotide(c) == false) {
			throw new IllegalInputException(c);
		}

		// If nucleotide valid, add Nucleotide at index and shift next one
		// over
		else {
			// Add nucleotides one by one from left
			for (int i = 0; i < addedSeqChar.length; i++) {
				// If i equals inputed index
				if (i == index) {
					addedSeqChar[i] = c;
				}
				// if before added nucleotide
				if (i < index) {
					addedSeqChar[i] = sequenceChar[i];
				}
				// if after added nucleotide
				if (i > index) {
					addedSeqChar[i] = sequenceChar[i - 1];
				}

			}
		}

		// Return sequence
		return String.valueOf(addedSeqChar);
	}

	// ----------
	// NUCLEOTIDEAT METHOD -> find nucleotide at given index
	public char nucleotideAt(int index) {
		// Get sequence
		sequence = getSequence();

		// Turn sequence into char array
		char[] sequenceChar = sequence.toCharArray();

		// Initialize character found at given index
		char character;

		// Find if index in bounds
		// If out of bounds, throw exception
		if (index > sequenceChar.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		// If index in bounds, find character at given index
		else {
			// Find char at index
			character = sequenceChar[index];
		}

		// Return char
		return character;
	}

	// ----------
	// LENGTH METHOD -> find number of nucleotides in Genome
	public int length() {
		// Get sequence
		this.sequence = getSequence();

		// Declare variable
		int seqLength;

		// Assign value to length
		seqLength = sequence.length();

		// Return length
		return seqLength;
	}

	// ----------
	// ISVALID METHOD -> check if DNA sequence is valid
	public boolean isValid(String sequence) {
		// Initialize isValid
		boolean isValidSeq = true;

		// Break sequence into chars
		char[] sequenceChar = sequence.toCharArray();

		// Check sequence character by character
		for (int i = 0; i < sequence.length(); i++) {
			if (checkNucleotide(sequenceChar[i]) == false) {
				isValidSeq = false;
			}
		}

		// Return isValidSeq
		return isValidSeq;
	}

	// ----------
	// CHECKEQUALITY METHOD -> check if 2 Genomes have same elements
	public boolean checkEquality(Genome obj) {
		// Initialize checkEquality
		boolean isEqual = true;

		// Check sequences
		if (obj.sequence != this.sequence) {
			isEqual = false;
		}

		// Check species
		if (obj.species != this.species) {
			isEqual = false;
		}

		// Return checkEquality
		return isEqual;
	}

	// ----------
	// SUBSEQUENCE METHOD -> determines if s is subsequence of t
	public boolean subsequence(String s, String t) {
		// Initialize isSubsequence
		boolean isSubsequence = false;

		// Check if s is subsequence of t
		// Length of strings
		int sLength = s.length();
		int tLength = t.length();

		//
		int i = 0;
		for (int j = 0; j < tLength; j++) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			if (i == sLength) {
				return true;
			}
		}

		// Return isSubsequence
		return isSubsequence;
	}

	// ----------
	// ISGENES METHOD -> check if subsequence is gene
	public boolean isGene(String s) {
		// Initialize isAGene
		boolean isAGene = true;

		// Break string into char array
		char[] sChars = s.toCharArray();

		// Check start codon -> If not starting with ATG, is not a gene
		if (!((sChars[0] == 'A') && (sChars[1] == 'T') && (sChars[2] == 'G'))) {
			isAGene = false;
		}

		// Check length of gene -> if not multiple of 3, not a gene
		// Length of subsequence
		int lengthOfSeq = s.length();

		// If length not multiple of 3, not a gene
		if (lengthOfSeq % 3 != 0) {
			isAGene = false;
		}

		// Check stop codon
		// if 3rd to last char is NOT T, then not a gene

		if (sChars[lengthOfSeq - 3] != 'T') {
			isAGene = false;
		}

		// If 2nd to last char not A or G, not a gene
		if (sChars[lengthOfSeq - 2] == 'C' || sChars[lengthOfSeq - 2] == 'T') {
			isAGene = false;
		}

		// If last char not A or G,
		if (sChars[lengthOfSeq - 1] == 'T' || sChars[lengthOfSeq - 1] == 'C') {
			isAGene = false;
		}

		// Check no stop codons in string
		// i represents 1st position, j reps 2nd position, k reps 3rd position
		for (int i = 0, j = 1, k = 2; k < lengthOfSeq - 3; i++, j++, k++) {
			// Check if TAG in sequence
			if (sChars[i] == 'T' && sChars[j] == 'A' && sChars[k] == 'G') {
				isAGene = false;
			}
			// Check if TAA in sequence
			if (sChars[i] == 'T' && sChars[j] == 'A' && sChars[k] == 'A') {
				isAGene = false;
			}
			// Check if TGA in sequence
			if (sChars[i] == 'T' && sChars[j] == 'G' && sChars[k] == 'A') {
				isAGene = false;
			}

		}

		// Return isAGene
		return isAGene;
	}

	// ----------
	// FINDGENES METHOD
	public void findGenes() {
		// Counter initialized
		int counter = 0;

		// Counting genes
		// Get sequence
		this.sequence = getSequence();

		// If doesn't contain ATG( start codon), NO genes
		if (!(this.sequence.contains("ATG"))) {
			counter = 0;
		}

		// Find start codon
		int start;
		int end;
		/*
		 * Find start (beginning of substring) -> is less than sequence.length()
		 * -2 because need triplet
		 */
		for (int i = 0; i < this.sequence.length() - 2; i++) {
			if ((this.sequence.charAt(i) == 'A') && (this.sequence.charAt(i + 1) == 'T')
					&& (this.sequence.charAt(i + 2) == 'G')) {
				start = i;

				// Extend length by 1 until find end codon
				for (end = start + 3; end > start && end < this.sequence.length(); end++) {
					String s = this.sequence.substring(start, end + 1);
					// Check if is gene -> if it is, break
					if (isGene(s)) {
						counter++;
						break;
					}
				}

			}
		}

		// Assign numGenes equal to number of counted genes
		this.numGenes = counter;

		// Print number of genes
		System.out.println("The number of genes in this sequence is: " + numGenes);

	}

	// ----------
	// ISCIRCULARSHIFT METHOD
	public boolean isCircularShift(String s, String t) {
		// Initialize isACircularShift
		boolean isACircularShift = false;

		// shiftS = shifted S
		String shiftS = s;

		// Shift s n times and, if s = t, then they are isCirculaShift is true
		// Max "shifts" is equal to length of string
		for (int shift = 0; shift < s.length(); shift++) {
			shiftS = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
			if (shiftS.equals(t)) {
				isACircularShift = true;
			}
			s = shiftS;
		}

		// Return isACircularShift
		return isACircularShift;
	}

	// ----------
	// REVERSECOMPLEMENTED METHOD -> returns reverse complement of sequence
	public String reverseComplemented(String sequence) {
		// Create char array of sequence
		char[] seqChar = sequence.toCharArray();

		// Create copy of chars
		char[] seqCopy = sequence.toCharArray();

		// Reverse chars
		// i represents index from beginning (from 0)
		// j represents index from end (from last index)
		for (int i = 0, j = seqCopy.length - 1; i < seqCopy.length; i++, j--) {
			seqChar[i] = seqCopy[j];
		}

		// Create new array to store reversed and complemented chars
		char[] seqRevCopy = new char[seqChar.length];

		// Replace each element with complement
		// Add complement index by index
		for (int i = 0; i < seqChar.length; i++) {
			// If 'A', replace with 'T'
			if (seqChar[i] == 'A') {
				seqRevCopy[i] = 'T';
			}
			// If 'T', replace with 'A'
			if (seqChar[i] == 'T') {
				seqRevCopy[i] = 'A';
			}
			// If 'C', replace with 'G'
			if (seqChar[i] == 'C') {
				seqRevCopy[i] = 'G';
			}
			// If 'G', replace with 'C'
			if (seqChar[i] == 'G') {
				seqRevCopy[i] = 'C';
			}
		}
		// Return reversed and complemented sequence
		return String.valueOf(seqRevCopy);
	}

	// ----------
	/*
	 * LONGESTCOMPLEMENTEDPALINDROME METHOD -> find longest complemented
	 * palindrome
	 */
	public String longestComplementedPalindrome(String s) {
		// If string empty, then no complemented palindrome
		if (s.isEmpty()) {
			return null;
		}

		// If string length is 1, then palindrome is string
		if (s.length() == 1) {
			return s;
		}

		// If string longer than 2 chars
		// Assume longest string is first character unless proven otherwise
		String longest = s.substring(0, 1);

		// i represents center of palindrome
		for (int i = 1; i < s.length() - 1; i++) {
			// For odd length palindrome (ea. 232)
			String revCompPalindrome = intermediatePalindrome(s, i - 1, i + 1);
			if (revCompPalindrome.length() > longest.length()) {
				longest = revCompPalindrome;
			}

			// For even length palindrome (ea. 2332)
			revCompPalindrome = intermediatePalindrome(s, i, i + 1);
			if (revCompPalindrome.length() > longest.length()) {
				longest = revCompPalindrome;
			}
		}

		// Return longest complemented palindrome
		return longest;
	}

	public String intermediatePalindrome(String s, int left, int right) {
		/*
		 * Check beginning and end of palindrome and, if conditions met,
		 * increase/decrease length and return
		 */
		if (left > right) {
			return null;
		}

		while (left >= 0 && right < s.length()
				&& (((s.charAt(left) == 'A') && (s.charAt(right) == 'T'))
						|| ((s.charAt(left) == 'T') && (s.charAt(right) == 'A'))
						|| ((s.charAt(left) == 'C') && (s.charAt(right) == 'G'))
						|| ((s.charAt(left) == 'G') && (s.charAt(right) == 'C')))) {

			left--;
			right++;
		}

		return s.substring(left + 1, right);

	}
}