package com.company.study.algorithm.lesson02_sort.chap02;

import java.util.Scanner;

public class Merge_Sort1 {
    private static int [] sorted; // 합치는 과정에서 정렬하여 원소를 담을 임시배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        out_put(arr);
        merge_sort(arr);
        out_put(arr);


    }

    public static void merge_sort(int [] a){

        sorted = new int[a.length];
        merge_sort(a,0,a.length-1);
        sorted = null;
    }

    // Top-Down 방식 구현
    private static void merge_sort(int[]a , int left, int right){

        //left ==right 즉, 부분리스트가 1개의 원소만 갖고있는 경우
        // 더이상 쪼갤 수 없으므로 return 한다.

        if (left==right) return;
        int mid = (left+right)/2; // 절반 위치;

        merge_sort(a,left,mid); // 절반 중 왼쪽 부분리스트
        merge_sort(a,mid+1,right); // 절반 중 오른쪽 부분리스트

        merge(a,left,mid,right); // 병합작업


    }

    private static void merge(int[]a, int left, int mid, int right){
        int l = left; //왼쪽 부분리스트 시작점
        int r = mid+1; // 오른쪽 부분리스트의 시작점
        int idx = left; // 채워넣을 배열의 인덱스

        while (l<= mid && r<=right){

            /*
            * 왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
            * 왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1증가시킨다.
            *
            * 오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
            * 오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
            * */
            if (a[l] <= a[r]){
                sorted[idx++] = a[l++];
            }else {
                sorted[idx++] =  a[r++];
            }
        }

        if (l>mid){
            while (r<= right){
                sorted[idx++] = a[r++];
            }
        }else {
            while (l<=mid){
                sorted[idx++] = a[l++];
            }
        }

        for (int i= left; i<= right; i++){
            a[i] = sorted[i];
        }
    }

    private static void out_put(int arr[]){
        for (int x : arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }
}
