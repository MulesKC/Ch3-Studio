package Studio;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.lang.Character;


public class CharCounter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("What text would you like to count character occurrences of? Press enter to use some default text.");
        String response = input.nextLine();
        input.close();


        String defaultText = "If the product of two terms is zero then common sense " +
                "says at least one of the two terms has to be zero to start with. So if " +
                "you move all the terms over to one side, you can put the quadratics into " +
                "a form that can be factored allowing that side of the equation to equal " +
                "zero. Once you’ve done that, it’s pretty straightforward from there.";

        char[] stringToSearch;

        if (response.equals("")) {
            System.out.println("For reference, here is the default text: " + defaultText);
            stringToSearch = defaultText.toCharArray();
        } else {
            stringToSearch = response.toCharArray();
        }

        Map<String, Integer> charCountMap = new HashMap<>();
        int total = 0;
        for (char letter : stringToSearch) {
            String letterStr = Character.toString(letter);
            String letterLC = letterStr.toLowerCase();

            char letterChar = letterLC.charAt(0);
            int letterAscii = (int) letterChar;


            if (charCountMap.containsKey(letterLC)) {

                charCountMap.put(letterLC, charCountMap.get(letterLC)+1);
            } else {
                if (letterLC.equals(" ") || letterAscii < 97 || letterAscii > 122) {
                    continue;
                }
                charCountMap.put(letterLC, 1);
            }
        }

        for (Map.Entry<String, Integer> letterFinal : charCountMap.entrySet()) {
            System.out.println(letterFinal.getKey() + " : " + letterFinal.getValue());
        }
    }
}
