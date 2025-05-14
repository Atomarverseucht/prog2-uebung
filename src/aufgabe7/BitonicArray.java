package aufgabe7;

public class BitonicArray {

    static int count;
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 6, 5};
        System.out.println(findPeakIterative(arr));
        System.out.println(findPeakDivideAndConquer(arr));
    }
    public static int findPeakIterative(int[] a) {
        for (int i = 0; i < a.length -1 ; i++) {
            if(a[i] > a[i+1]){
                return i;
            }
        }
        return a.length - 1;
    }


    // Laufzeit: O(log(n))
    public static int findPeakDivideAndConquer(int[] a) {
        count = 0;
        return peakFinder(a, 0, a.length -1);
    }

    private static int peakFinder(int[] a, int l, int r) {
        count++;
        final int difference = r-l;
        if(difference == 0){
            return l;
        }
        final int mid = difference / 2 + l;
        if(a[mid] > a[mid+1]){
            return peakFinder(a,l,mid);
        } else{
            return peakFinder(a, mid+1, r);
        }
    }
}
