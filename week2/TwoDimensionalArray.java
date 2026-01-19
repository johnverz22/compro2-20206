package week2;

public class TwoDimensionalArray {
    public static void main(String[] args){
        String[] clothTypes = {"Shirts", "Pants"};
        /* 1ST alternative, if data is not yet known initially, only structure
        String[][] clothColors = new String[2][3];
        //for first row
        clothColors[0][0] = "red";
        clothColors[0][1] = "blue";
        clothColors[0][2] = "green";

        //for second row
        clothColors[1][0] = "orange";
        clothColors[1][1] = "yellow";
        clothColors[1][2] = "violet";
        */

        /* 2ND alternative if data is know initially */
        String[][] clothColors = {
            {"red", "blue", "green"},
            {"orange", "yellow  ", "violet"},
        };

        for(int i = 0; i < clothColors.length; i++){
            System.out.println(clothTypes[i]);
            for(int j = 0; j < clothColors[i].length; j++){
                System.out.printf("%-8s", clothColors[i][j]);
            }
            System.out.println();
        }

    }
}
