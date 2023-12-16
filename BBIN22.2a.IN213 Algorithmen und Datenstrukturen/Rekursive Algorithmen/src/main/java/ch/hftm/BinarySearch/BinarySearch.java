package ch.hftm.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int elementToFind = 6;
        int result = binarySearch(intArray, elementToFind);

        if (result != -1) {
            System.out.println("Element " + elementToFind + " gefunden an Index " + result);
        } else {
            System.out.println("Element " + elementToFind + " nicht im Array vorhanden.");
        }
    }


    private static int binarySearch(int[] iarr, int elem){
        return bSearch(iarr, elem, 0, iarr.length - 1);
    }


    private static int bSearch(int[] iarr, int elem, int lowerIdx, int upperIdx) {

        int mid = lowerIdx + (upperIdx - lowerIdx) / 2;
        if (lowerIdx > upperIdx) { // Fall 1: Es gibt kein mittleres Element, Rückgabe von -1
            return -1;
        } else if (iarr[mid] == elem) { // Fall 2: Das mittlere Element ist das gesuchte, Rückgabe des Index
            return mid; 
        } else if (iarr[mid] > elem) { // Fall 3: Element ist kleiner, Suche in unterer Hälfte
            return bSearch(iarr, elem, lowerIdx, mid - 1);
        } else { // Fall 4: Element ist größer, Suche in oberer Hälfte
            return bSearch(iarr, elem, mid + 1, upperIdx); 
        }
    }
}