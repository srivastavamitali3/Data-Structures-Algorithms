package amazonOnlineAssessment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Amazon Music Pairs
 * <p>
 * Amazon Music is working on a new "community radio station" feature which will allow users to iteratively populate
 * the playlist with their desired songs. Considering this radio station will also have other scheduled shows to be
 * aired, and to make sure the community soundtrack will not run over other scheduled shows, the user-submitted songs
 * will be organized in full-minute blocks. Users can choose any songs they want to add to the community list, but
 * only in pairs of songs with durations that add up to a multiple of 60 seconds (e.g. 60, 120, 180).
 * <p>
 * As an attempt to insist on the highest standards and avoid this additional burden on users, Amazon will let them
 * submit any number of songs they want, with any duration, and will handle this 60-second matching internally. Once
 * the user submits their list, given a list of song durations, calculate the total number of distinct song pairs that
 * can be chosen by Amazon Music.
 * <p>
 * Example
 * <p>
 * n = 3
 * <p>
 * songs = [37, 23, 60]
 * One pair of songs can be chosen whose combined duration is a multiple of a whole minute (37 + 23 = 60) and the
 * return value would be 1. While the third song is a single minute long, songs must be chosen in pairs.
 * Function Description
 * <p>
 * Complete the function getSongPairCount in the editor below.
 * <p>
 * getSongPairCount has the following parameter:
 * <p>
 * int songs[n]: array of integers representing song durations in seconds
 * <p>
 * Returns:
 * <p>
 * long: the total number of songs pairs that add up to a multiple of 60 seconds. If there are no suitable pairs,
 * return 0.
 * <p>
 * Constraints
 * <p>
 * 1 ≤ n ≤ 105
 * 1 ≤ songs[i] ≤ 1000, where 0 ≤ i < n
 * <p>
 * Input Format For Custom Testing
 * Input from stdin will be processed as follows and passed to the function.
 * <p>
 * The first line contains an integer, n, that denotes the number of elements in songs.
 * <p>
 * The next n lines each contain an integer that describes songs[i] and denotes the duration of the ith song
 * (in seconds).
 * <p>
 * Sample Case 0
 * Sample Input For Custom Testing
 * <p>
 * STDIN Function
 * <p>
 * 4 -> songs[] size n = 4
 * 10 -> songs = [10, 50, 90, 30]
 * 50
 * 90
 * 30
 * Sample Output
 * <p>
 * 2
 * Explanation
 * <p>
 * The first and second songs pair to 60 seconds. The third and fourth songs pair to 120 seconds. No other pairs
 * will satisfy the requirement.
 * <p>
 * Sample Case 1
 * Sample Input For Custom Testing
 * <p>
 * STDIN Function
 * <p>
 * 5 -> songs[] size n = 5
 * 30 -> songs = [30, 20, 150, 100, 40]
 * 20
 * 150
 * 100
 * 40
 * Sample Output
 * <p>
 * 3
 * Explanation
 * <p>
 * There are three pairs of songs whose whole duration is a multiple of a whole minute. They are 20 + 100, 30 + 150,
 * and 20 + 40 corresponding to (1, 3), (0, 2) and (1, 4).
 * <p>
 * Sample Case 2
 * Sample Input For Custom Testing
 * <p>
 * STDIN Function
 * <p>
 * 3 -> songs[] size n = 3
 * 60 -> songs = [60, 60, 60]
 * 60
 * 60
 * Sample Output
 * <p>
 * 3
 * Explanation
 * <p>
 * There are three pairs of songs that end in whole minutes. They are (0, 1), (1, 2) and (0, 2).
 */
public class AmazonMusicPairs {
    public static void main(String[] args) {

    }

    public static long getSongPairCount(List<Integer> songs) {
        /*int k = 60;
        int n = songs.size();
        int ans = 0;
        // sort the given list
        Collections.sort(songs);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
            {
                if (((songs.get(i) + songs.get(j)) % k) == 0) {
                    ans++;
                }
            }
        }
        return ans;*/

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int n : songs) {
            n = n % 60;
            if (map.containsKey(60 - n == 60 ? 0 : 60 - n))
                res += map.get(60 - n == 60 ? 0 : 60 - n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return res;
    }
}
