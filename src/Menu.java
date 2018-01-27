import java.io.Console;
import java.util.Random;
import java.util.Scanner;

public class Menu {

	int numer;
	Wybierz wybierz;
	Console konsola;
	String imie;
	String info;
	boolean infobool = false;
	Scanner input;
	
 	public Menu(int i)
	{	
 		numer = i;
 		imie = wybierz.ListaImion.get(numer);
		input = new Scanner(System.in);
		WyswietlMenu();
		
	}
	
	public void WyswietlMenu()
	{
//		konsola.
		System.out.println("######################################");
		if(infobool) 
			{
			System.out.println(info);
			infobool = false;
			}
		System.out.println("######################################");
		System.out.println("Oryginalne imie: " + wybierz.ListaImion.get(numer));
		System.out.println("Obecne: " + imie);
		System.out.println("	### MENU ###	");
		System.out.println("1. Zmien	");
		System.out.println("2. Wyswietl samo nazwisko ");
		System.out.println("3. Wyswietl samo imie ");
		System.out.println("4. Obróæ imie i/lub nazwisko");
		System.out.println("5. losuj kolejnosc liter");
		System.out.println("6. Dodaj Litery");
		System.out.println("7. Zapisz Zmiany");
		System.out.println("8. Wróæ");
		switch(input.nextInt())
		{
		case 1: Zmien();
		break;
		case 2: WyswietlNazwisko();
		break;
		case 3: WyswietlImie();
		break;
		case 4: WypiszOdwrotnie();
		break;
		case 5: LosujKolejnosc();
		break;
		case 6: DodajLitery();
		break;
		case 7: ZapiszZmiany();
		break;
		case 8: Wybierz.MenuImion();
		break;
		default: WyswietlMenu();
		}
	}
	
	
	private void Zmien()
	{ 
		System.out.println("Podaj nowe imie: ");
		Scanner skan = new Scanner(System.in);
		
		imie = new String(skan.nextLine());
		wybierz.ListaImion.set(numer, new String(imie));
		info = "Imie zmienione pomyœlnie!";
		infobool = true;
		WyswietlMenu();
	}
	private void WyswietlImie()
	{
		if(wybierz.ListaImion.get(numer).indexOf(" ") == -1 || wybierz.ListaImion.get(numer).indexOf(" ") == 0)  
		{
		}
		else 
		{
			imie = new String(wybierz.ListaImion.get(numer).substring(0,wybierz.ListaImion.get(numer).indexOf(" ")));
		} 
		WyswietlMenu();
	}
	private void WyswietlNazwisko()
	{
		if(wybierz.ListaImion.get(numer).indexOf(" ") == -1)  
		{
			info = "Nie podales nazwiska!";
			infobool = true;
		}
		else 
		{
			imie = new String(wybierz.ListaImion.get(numer).substring(wybierz.ListaImion.get(numer).indexOf(" ")+1));
		} 
		WyswietlMenu();
	}
	private void WypiszOdwrotnie()
	{
		int i = 0;
		int l = imie.length() - 1;
		char[] chars = imie.toCharArray();
		while(i<l)
		{
			char temp = chars[i];
			chars[i] = chars[l];
			chars[l] = temp;
			i++;
			l--;
		}
		imie = String.valueOf(chars);
		WyswietlMenu();
	}
	private void LosujKolejnosc()
	{
		Random generator = new Random();
		int l = imie.length();
		char[] chars = imie.toCharArray();
		char[] newchar = new char[l];
		for(int i=0; i<=l-1; i++)
		{
			//if(chars[i] == ' ') newchar[i] = chars[i];
			 newchar[i] = '0';
		}
		for(int i=0; i<=l-1; i++)
		{
			do {
				int r = generator.nextInt(l);
				if(newchar[r] == '0')
				{
				newchar[r] = chars[i];
				break;
				}
			}while(true);
		}
		imie = String.valueOf(newchar);
		WyswietlMenu();
	}
	private void DodajLitery()
	{
		int sum = 0;
		info = "";
		char[] chars = imie.toCharArray();
		for(int i=0; i< imie.length(); i++)
		{
			sum += (int)chars[i];
			if(i==imie.length()-1)
			{
				info += chars[i] +"("+(int)chars[i]+") = "+ sum;
			}
			else info += chars[i] +"("+(int)chars[i]+")+";
		}
		infobool = true;
		WyswietlMenu();
	}
	private void ZapiszZmiany()
	{
		wybierz.ListaImion.set(numer, imie);
		WyswietlMenu();
	}
}
