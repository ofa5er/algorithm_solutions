/*
K-Messed Array Sort

Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.

Analyze the time and space complexities of your solution.

Example:

input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ 100
[input] integer k

1 ≤ k ≤ 20
[output] array.integer
*/

int[] sortKMessedArray(int[] arr, int k) {
    
	if (arr == null || arr.length == 0) {
      return new int[0];
    }
	
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    
	int[] result = new int[arr.length];
    int i = 0;
	
    for (int elt : arr) {
      pq.add(elt);
      if (pq.size() > k) {
        result[i] = pq.remove();
        i++;
      }
    }

    while (!pq.isEmpty()) {
      result[i] = pq.remove();
      i++;
    }

    return result;
}