package com.example.demo.study;

public class Test {
		// 冒泡排序
		void BubbleSort(int arr[], int length)
		{
			for (int i = 0; i < length; i++)
			{
				for (int j = 0; j < length -  i - 1; j++)
				{
					if (arr[j] > arr[j + 1])
					{
						int temp;
						temp = arr[j + 1];
						arr[j + 1] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}

}
