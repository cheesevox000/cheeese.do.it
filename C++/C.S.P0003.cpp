#include <stdio.h>

void input(int &n, int a[]){
	printf("Please enter size of array: ");
	scanf("%d",&n);
	for(int i=0; i<n; i++){
		printf("Enter element[%d]: ", i);
		scanf("%d",&a[i]);
	}
}

void swap(int &a, int &b){
	int c;
	c=a; a=b; b=c;
}

void sort(int n, int a[]){
	for(int i=0; i<n; i++){
		for(int j=i+1; j<n; j++){
			if(a[j]<a[i])	swap(a[i],a[j]);
		}
	}
}

void add(int &n, int a[]){
	printf("\nPlease enter new value: ");
	scanf("%d", &a[n++]);
}

void output(int n, int a[]){
	for(int i=0; i<n; i++){
		printf("%d ",a[i]);
	}
}


int main(){
	int n, a[100];	
	input(n,a);
	sort(n,a);
	printf("The array after sorting:\n");
	output(n,a);
	add(n,a);
	sort(n,a);
	printf("New array:\n");
	output(n,a);
	return 0;
}
