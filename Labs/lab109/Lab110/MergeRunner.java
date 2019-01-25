
/**
 * Write a description of class MergeRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MergeRunner
{
   public static void merge(int[] a, int[] l, int[] r, int left, int right) {
      int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }else {
            a[k++] = r[j++];
        }
    }
    while (i < left) { a[k++] = l[i++];}
    while (j < right) {a[k++] = r[j++];}
}

}
