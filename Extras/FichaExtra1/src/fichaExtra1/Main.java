package fichaExtra1;

import navio.NavPortaContentor;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		 NavPortaContentor pc1 = new NavPortaContentor("Juan", null, null, 0, 0);
		 NavPortaContentor pc2 = new NavPortaContentor("Juan", null, null, 0, 0);
		 NavPortaContentor pc3 = new NavPortaContentor("pedro", null, null, 0, 0);
		 
		 Porto porto1 = new Porto(null, null);
		 
		 porto1.insereNavio(pc1);
		 porto1.insereNavio(pc2);
		 porto1.insereNavio(pc3);
		 
			System.out.println(porto1.getNavios());
	}
	
}
