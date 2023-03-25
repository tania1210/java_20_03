import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static String camelCase(String input) {
        ArrayList list = new ArrayList();
        String upInput = input.toUpperCase();

        char [] upstr = upInput.toCharArray(); // I,L,I,K,E,Y,O,U
        char [] str = input.toCharArray(); // I,L,i,k,e,Y,o,u
        int i = 0;

        while(i < input.length()) {
            if(upstr[i] == str[i] && i != 0) {
                list.add(" ");
                list.add(str[i]);
            }else {
                list.add(str[i]);
            }
            i++;
        }
        input = "";
        for(int p = 0; p < list.size(); p++) {
            input += list.get(p);
        }
        return input;
    }
    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        String text = s.next();
        System.out.print(camelCase(text));
    }
}
