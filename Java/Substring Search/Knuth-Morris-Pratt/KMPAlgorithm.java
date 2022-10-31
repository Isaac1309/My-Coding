public class KMPAlgorithm {
    private String text;
	private String pattern;
	private int[] pi;
	
	public KMPAlgorithm(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		this.pi = new int[pattern.length()];
	}
	
	private void constructTable() {
    	int prefixCounter = 0;
    	int i = 1;
    	while(i<pattern.length()) {
    		if(text.charAt(i) == pattern.charAt(prefixCounter)) {
    			prefixCounter++;
    			pi[i] = prefixCounter;
    			i++;
    		} else {
    			if(prefixCounter != 0) {
    				prefixCounter = pi[prefixCounter-1];
    			} else {
    				pi[i] = 0;
    				i++;
    			}
    		}
    	}
    }
    
    public void search() {
        constructTable();
        int i = 0;
    	int j = 0;
        while(i<text.length() && j<pattern.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
    			i++;
    			j++;
    		}
            if(j==pattern.length()) {
    			System.out.println("Found pattern at index: " + (i-j));
    			j = pi[j-1];
    		}
            if(i<text.length() && text.charAt(i) != pattern.charAt(j)) {
                if(j!=0) 
    				j = pi[j-1];
    			else
                    i++;
    		}
    	}
    }
}