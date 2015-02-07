
import java.util.*;

public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame() {
		//Создадим несколько "сайтов" и присвоим им адреса
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		
		System.out.println("Vasha cel' - potopit' 3 saita");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Potopite ix za minimal'noe collichestvo xodov");
		
		for (DotCom dotComToSet : dotComList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {
		while(!dotComList.isEmpty()) {
			String userGuess = helper.getUserInput("Sdelai xod");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "LOOSER!!!";
		
		for (DotCom dotComToSet : dotComList) {
			result = dotComToSet.checkYourself(userGuess);
			if (result.equals("EST' KONTAKT!!!")) {
				break;
			}
			if (result.equals("BOOM!!!")) {
				dotComList.remove(dotComToSet);
				break;
			}
			}
			System.out.println(result);
		}
		
		private void finishGame() {
			System.out.println("BINGO! BOOM!!! BOOM!!! BOOM!!!");
			if (numOfGuesses <=18) {
				System.out.println("Eto zanjalo vsego " + numOfGuesses+ " poputok");
				System.out.println("Vashi berega spasenu");
			}
		}
		
		public static void main (String[] args) {
			DotComBust game = new DotComBust();
			game.setUpGame();
			game.startPlaying();
		}
	}