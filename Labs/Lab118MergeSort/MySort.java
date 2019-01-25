/**
 * Write a description of class MySort here.
 *
 * @author (Steven Nguyen)
 * @version (110)
 */
public class MySort
{
   



    void sort(int arr[])

    {

        int n = arr.length;

  

        // One by one move boundary of unsorted subarray

        for (int i = 0; i < n-1; i++)

        {

            // Find the minimum element in unsorted array

            int min_idx = i;

            for (int j = i+1; j < n; j++)

                if (arr[j] < arr[min_idx])

                    min_idx = j;

  


            int temp = arr[min_idx];

            arr[min_idx] = arr[i];

            arr[i] = temp;

        }

    }

  

    // Print

    void printArray(int arr[])

    {

        int n = arr.length;

        for (int i=0; i<n; ++i)

            System.out.print(arr[i]+" ");

        System.out.println();

    }

  



    public static void main(String args[])

    {

        MySort ob = new MySort();

        int arr[] = {64,25,12,22,11};

        ob.sort(arr);

        System.out.println("Sorted array");

        ob.printArray(arr);

    }

}




