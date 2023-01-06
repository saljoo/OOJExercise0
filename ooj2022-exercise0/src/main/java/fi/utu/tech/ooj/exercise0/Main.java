package fi.utu.tech.ooj.exercise0;

import java.util.Scanner;

public class Main {

    /**
     * Taulukot, joita voi käyttää mikäli ei teen kaikkia tehtäviä. Ohjeet tehtävänannossa.
     */
    static int[][] teht4Array = {{1,456,6,-5678,23},{23,22,6,-2,2},{3,1,-5,44,6},{55,3,-8,3,2}};
    static String[][] teht5Array = {{"1","456","6","5678","23"},{"23","22","6","2","2"},{"3","1","5","44","6"},{"55","3","8","3","2"}};

    /**
     * Tehtävä 2
     *
     * Metodi lukee syötteenä kaksi lukua 1 suurempaa kokonaislukua ja palauttaa ne taulukkona.
     *
     * @return Kokonaislukutyyppinen taulukko, jossa on kaksi arvoa 1 suurempaa alkiota
     */

    // TEE TÄHÄN TEHTÄVÄ 2
    
    public static int[] readArraySize(){
    	//Luodaan lukija, jolla luetaan syötetyt arvot
    	Scanner lukija = new Scanner(System.in);
    	//Alustetaan tyhjä taulukko, johon mahtuu kaksi lukua
    	int taulukko[] = new int[2];
    	
    	//Suoritetaan silmukkaa kunnes on saatu kaksi hyväksyttävää lukua
    	for(int i = 0; i < 2;)
    	{
    		//Pyydetään käyttäjältä luku
    		System.out.print("Anna luku 1 tai suurempi kokonaisluku: ");
    		String syote = lukija.nextLine();
    		try
    		{
    			//Muutetaan syöte luvuksi jos mahdollista ja tarkistetaan, että luku on riittävän suuri
    			int luku = Integer.parseInt(syote);
    			if(luku < 1)
    			{
    				System.out.println("Luku annettu väärin!");
    			}
    			else
    			{
    				taulukko[i] = luku;
        			i ++;
    			}
    		}
    		catch (NumberFormatException e)
    		{
    			System.out.println("Luku annettu väärin!");
    		}
    	}
    	//Palautetaan taulukko
    	return taulukko;
    }

    /**
     * Tehtävä 3
     *
     * Metodi lukee syötteenä xSize*ySize kappaletta kokonaislukuja ja sijoittaa ne kokonaislukutyyppiseen
     * taulukkoon, joka palautetaan metodista.
     *
     * @param xSize Taulukon sarakemäärä
     * @param ySize Taulukon rivimäärä
     * @return xSize*ySize kokoinen kokonaislukutyyppinen taulukko, joka on täytetty kokonaisluvuilla
     */

    // TEE TÄHÄN TEHTÄVÄ 3
    
    public static int[][] readArrayData(int xSize, int ySize) {
    	//Luodaan halutun kokoinen taulukko ja uusi lukija käyttäjän syötettä varten
    	int[][] taulukko = new int[xSize][ySize];
    	Scanner lukija = new Scanner(System.in);
    	
    	//Suoritetaan silmukkaa kunnes hyväksyttäviä lukuja on riittävästi
    	for(int i = 0; i < xSize;) {
    		for(int j = 0; j < ySize;)
    		{
    			System.out.print("Anna kokonaisluku: ");
        		String syote = lukija.nextLine();
        		try
        		{
        			int luku = Integer.parseInt(syote);
        			taulukko[i][j] = luku;
        			j++;
        		}
        		catch (NumberFormatException e)
        		{
        			System.out.println("Luku annettu väärin!");
        		}
    		}
    		i++;
    	}
    	//Palautetaan taulukko
    	return taulukko;
    }

    /**
     * Tehtävä 4
     *
     * Metodi tarkastaa, että argumenttina saadun taulukon kaikki alkiot ovat positiivisia. Jos jokin luku ei ole
     * positiivinen, se vaihdetaan itseisarvokseen.
     *
     * @param inputArray Kokonaislukutyyppinen taulukko
     * @return parametrinä saadun taulukon kokoinen merkkijonotyyppinen taulukko
     */

    // TEE TÄHÄN TEHTÄVÄ 4
    
    public static String[][] checkArrayData(int[][] taulukko3) {
    	String[][] taulukko = new String[taulukko3.length][taulukko3[0].length];
    	
    	//Käydään läpi koko taulukko ja muutetaan negatiiviset luvut vastaluvuikseen
    	for(int i = 0; i < taulukko3.length; i++)
    	{
    		for(int j = 0; j < taulukko3[i].length; j++)
    		{
    			if(taulukko3[i][j] < 0)
        		{
        			taulukko[i][j] = "" + (taulukko3[i][j] * -1);
        		}
        		else
        		{
        			taulukko[i][j] = "" + taulukko3[i][j];
        		}
    		}
    		
    	}
    	//Palautetaan taulukko
    	return taulukko;
    }

    /**
     * Tehtävä 5
     * Metodi tulostaa argumenttina saamansa taulukon muotoillen sen taulukkomuotoon ja tasaten sarakkeet oikealle.
     *
     * @param inputArray Merkkijonotyyppinen taulukko
     * @return void
     */

    // TEE TÄHÄN TEHTÄVÄ 5
    
    //Metodi jolla sisennetään taulukon tuloste oikealle
    public static int alignRight(String[][] taulukko4, String luku, int j) {
    	int pisin = 0;
    	for(int i = 0; i < taulukko4.length; i++)
    	{
    		if(taulukko4[i][j].length() > pisin)
    		{
    			pisin = taulukko4[i][j].length();
    		}
    	}
    	int sisennys = pisin - luku.length();
    	return sisennys;
    }
    
    public static void printArray(String[][] taulukko4) {
    	String vali = " ";
    	for(int i = 0; i < taulukko4.length; i++)
    	{
    		for(int j = 0; j < taulukko4[i].length; j++)
    		{
    			if(j < taulukko4[i].length - 1)
    			{
    				int sisennys = alignRight(taulukko4, taulukko4[i][j], j);
    				System.out.print(" " + (vali.repeat(sisennys)) + taulukko4[i][j]);
    			}
    			else
    			{
    				int sisennys = alignRight(taulukko4, taulukko4[i][j], j);
    				System.out.println(" " + (vali.repeat(sisennys)) + taulukko4[i][j]);
    			}
    		}
    	}
    }

    /**
     * Main class.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        /*
          FizzBuzz-luokan runFizzBuzz()-metodilla voi tarkistaa harjoitustyöpohjan toimivuuden omassa koneessa
          ennen tehtävien tekemistä. Testin jälkeen alla olevan rivin voi joko kommentoida tai poistaa.
         */

    	//FizzBuzz.runFizzBuzz();
    	
        // Tehtävät 2-5
        // Kirjoita tähän tarvittavat metodikutsu ja muut toiminteet.
    	System.out.println("Tehtävä 2");
    	int[] teht2taulukko = readArraySize();
    	int xSize = teht2taulukko[0];
    	int ySize = teht2taulukko[1];
    	System.out.println("Tehtävä 3");
    	int[][] teht3taulukko = readArrayData(xSize, ySize);
    	String[][] teht4taulukko = checkArrayData(teht3taulukko);
    	System.out.println("Tehtävä 5");
    	printArray(teht4taulukko);
    	
        //Tehtävä 6
        // Kirjoita tähän tarvittavat metodikutsu ja muut toiminteet.
        // Osa tehtävästä 6 tehdään RajoitettuLista luokkaan
    	System.out.println("Tehtävä 6");
    	RajoitettuLista l = new RajoitettuLista(10);
		l.lisaa(6);
		System.out.println(l);
		l.lisaa(5);
		System.out.println(l);
		l.lisaa(3);
		System.out.println(l);
		l.lisaa(1);
		System.out.println(l);
    }
}
