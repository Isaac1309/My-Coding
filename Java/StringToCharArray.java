public class StringToCharArray{
	public static void main(String arg[]){
        String input = "Lo estoy probando";
        char[] charArray = input.toCharArray();
        for(int i=0; i<input.length(); i++){
            System.out.print(charArray[i]);
        }
	}
}