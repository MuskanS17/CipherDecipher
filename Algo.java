import java.util.*;
public class Algo {

    public static void main(String[] args) {
        System.out.println(caesarCipher("M uskanAZ"));
        System.out.println(caesarDecipher("PXvndQDcAZ"));
        System.out.println(vigenereCipher("Muskan",7));
        System.out.println(vigenereDecipher("tBzRHu",7));

        System.out.println(VernamCipher("oak","son"));
        System.out.println(VernamCipher("}oh","son"));

        System.out.println(railFenceEncrypt("Defendtheeas t", "3"));
        System.out.println(railFenceDecrypt("Dne tEEDHESfta","3"));

        System.out.println(RowColCipher("kill all virus","43125"));
        System.out.println(RowColDecipher("LIZlvzkLuIlsarz", "43125"));
    }

    public static String  VernamCipher(String pt, String key) {
        // Ensure both strings are the same length
        if (pt.length() != key.length()) {
            throw new IllegalArgumentException("The length of the plaintext and key must be the same.");
        }

        StringBuilder ct = new StringBuilder();  // To store the ciphertext

        // Iterate over the characters in the plaintext
        for (int i = 0; i < pt.length(); i++) {
            // Convert characters 'a' to 'z' to numbers 0 to 25
            int ptNum = pt.charAt(i) - 'a';
            int keyNum = key.charAt(i) - 'a';

            // Convert numbers to binary (we'll represent them as 5-bit binary for 'a' to 'z')
            String ptBinary = String.format("%5s", Integer.toBinaryString(ptNum)).replace(' ', '0');
            String keyBinary = String.format("%5s", Integer.toBinaryString(keyNum)).replace(' ', '0');

            // Perform bitwise XOR on each binary digit
            StringBuilder resultBinary = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                // XOR each corresponding bit
                char resultBit = (ptBinary.charAt(j) == keyBinary.charAt(j)) ? '0' : '1';
                resultBinary.append(resultBit);
            }

            // Convert the resulting binary back to a number
            int resultNum = Integer.parseInt(resultBinary.toString(), 2);

            // Convert the resulting number back to a character
            char resultChar = (char) (resultNum + 'a');
            ct.append(resultChar);  // Append to ciphertext
        }

        return ct.toString();  // Return the resulting ciphertext
    }

    public static String caesarCipher(String pt) {
        pt=pt.toUpperCase();
        String ct="";
        char ch;
        for(int i=0;i<pt.length();i++) {
            if(pt.charAt(i)=='X')
                ch='A';
            else if(pt.charAt(i)=='Y')
                ch='B';
            else if(pt.charAt(i)=='Z')
                ch='C';
            else if(pt.charAt(i)==' ')
                ch=' ';
            else
                ch=(char) ((int)pt.charAt(i)+3);

            ct+=ch;
        }
        return ct;
    }

    public static String caesarDecipher(String ct) {
        ct=ct.toUpperCase();
        String pt="";
        char ch;
        for(int i=0;i<ct.length();i++) {
            if(ct.charAt(i)=='A')
                ch='X';
            else if(ct.charAt(i)=='B')
                ch='Y';
            else if(ct.charAt(i)=='C')
                ch='Z';
            else if(ct.charAt(i)==' ')
                ch=' ';
            else
                ch=(char) ((int)ct.charAt(i)-3);

            pt+=ch;
        }
        return pt;
    }

    public static String vigenereCipher(String pt, int key) {
        pt=pt.toUpperCase();
        String ct="";
        char ch;
        for(int i=0;i<pt.length();i++) {
            int n = ((pt.charAt(i) - 'A' + key) % 26) + 'A';
            ch=(char)n;
            ct+=ch;
        }
        return ct;
    }

    public static String vigenereDecipher(String ct, int key) {
        ct=ct.toUpperCase();
        String pt="";
        char ch;
        for(int i=0;i<ct.length();i++) {
            int n = ((ct.charAt(i) - 'A' - key+26) % 26) + 'A';
            ch=(char)n;
            pt+=ch;
        }
        return pt;
    }

    public static String vernamCipher(String pt, String key) {
        pt=pt.toUpperCase();
        key=key.toUpperCase();
        String ct="";
        char ch;
        for(int i=0; i<pt.length();i++) {
            String binary1 = Integer.toBinaryString(pt.charAt(i));
            String binary2 = Integer.toBinaryString(key.charAt(i));
            int num1 = Integer.parseInt(binary1);
            int num2 = Integer.parseInt(binary2);
            ch = (char)(num1^num2);
            //char ch = (char)(pt.charAt(i)^key.charAt(i));
            ct+=ch;
        }
        return ct;
    }



    public static String RowColDecipher(String ct, String key) {
        ct=ct.toUpperCase();
        ct = removeSpace(ct);
        int col = key.length();
        int row = (int)Math.ceil((double)ct.length() / col);
        char[][] mat = new char[row][col];
        char[] arr = key.toCharArray();
        int idx = 0;
        String pt="";

        for (int k = 0; k < arr.length; k++) {
            int n = (arr[k] - '0') - 1;
            for (int i = 0; i < row; i++) {
                mat[i][n] = ct.charAt(idx);
               // System.out.println(i+" "+n);
                idx++;

            }
        }

//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++){
//                System.out.print(mat[i][j]);
//
//            }
//            System.out.println();
//        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pt += mat[i][j];
            }
        }

        return pt;
    }

    public static String RowColCipher(String pt, String key){
        int col = key.length();
        pt = pt.toUpperCase();
        pt = removeSpace(pt);
        int row = (int)Math.ceil((double)pt.length()/col);
        String ct="";

        char mat[][] = new char[row][col];
        int idx=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(idx<pt.length()){
                    mat[i][j]=pt.charAt(idx);
                    idx++;}
                else
                    mat[i][j]='Z';

            }
        }

//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++){
//                System.out.print(mat[i][j]);
//
//            }
//            System.out.println();
//        }


        char arr[] = key.toCharArray();
        for(int k=0;k<arr.length;k++){
            int n = (arr[k]-'0')-1;
            for (int i = 0; i<row; i++) {
                // System.out.println(n);
                ct+=mat[i][n];
            }
        }
        return ct;
    }


    public static String removeSpace(String s) {
        String str="";
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!=' ')
                str+=s.charAt(i);
        }
        return str;
    }

    public static String railFenceEncrypt(String pt, String depth) {
        pt = removeSpace(pt);
        int d = Integer.parseInt(depth);
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 1; i <= d; i++) {
            map.put(i, new ArrayList<>());
        }

        int index = 1;
        boolean ascending = true;
        for (char c : pt.toCharArray()) {
            map.get(index).add(c);
            if (ascending) {
                index++;
                if (index > d) {
                    index = d - 1;
                    ascending = false;
                }
            } else {
                index--;
                if (index < 1) {
                    index = 2;
                    ascending = true;
                }
            }
        }

        StringBuilder ct = new StringBuilder();
        for (int i = 1; i <= d; i++) {
            for (char c : map.get(i)) {
                ct.append(c);
            }
        }

        return ct.toString();
    }

    public static String railFenceDecrypt(String ct, String depth) {
        ct = removeSpace(ct);
        int d = Integer.parseInt(depth);
        Map<Integer, List<Character>> map = new HashMap<>();
        int[] count = new int[d + 1];
        int index = 1;
        boolean ascending = true;

        for (char c : ct.toCharArray()) {
            count[index]++;
            if (ascending) {
                index++;
                if (index > d) {
                    index = d - 1;
                    ascending = false;
                }
            } else {
                index--;
                if (index < 1) {
                    index = 2;
                    ascending = true;
                }
            }
        }

        int pos = 0;
        for (int i = 1; i <= d; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < count[i]; j++) {
                map.get(i).add(ct.charAt(pos++));
            }
        }

        StringBuilder pt = new StringBuilder();
        index = 1;
        ascending = true;
        int totalLength = ct.length();

        while (pt.length() < totalLength) {
            pt.append(map.get(index).remove(0));
            if (ascending) {
                index++;
                if (index > d) {
                    index = d - 1;
                    ascending = false;
                }
            } else {
                index--;
                if (index < 1) {
                    index = 2;
                    ascending = true;
                }
            }
        }

        return pt.toString();
    }

}
