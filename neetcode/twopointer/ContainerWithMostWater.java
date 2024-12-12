package datastructures.src.com.neetcode.twopointer;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // Example input

        // Call the maxArea method and print the result
        int result = maxArea(height);
        System.out.println("The maximum area of water that can be contained is: " + result);
    }

    public static int maxArea(int[] height){

        // BruteForce
/*
        int max = 0;

        for (int i = 0; i < height.length; i++){
            for (int j = 0; j < height.length; j++){
                int currentArea = Math.min(height[i],height[j]) * (j - i);
                max = Math.max(currentArea, max);
            }
        }
        return max;
        */

        int max = 0;

        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int currentArea = Math.min(height[left],height[right]) * (right - left);
            max = Math.max(currentArea,max);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
