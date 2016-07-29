import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 7/28/16.
 */
public class BucketSort {

    public static void main(String[] args) {
        bucketSort(Arrays.asList("hello", "world","there"));
    }

    public static void bucketSort(List<String> s) {
        bucketSort(new ArrayList<>(), s);
    }

    public static void bucketSort(List<String> buckets, List<String> s) {
//        List<String>
    }

}
