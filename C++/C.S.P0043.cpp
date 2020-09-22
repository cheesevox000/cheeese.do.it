#include <stdio.h>

void display(int a[], int i){
	printf("Output array: ");
	for(int j=0; j<i;j++){
		printf("%d ",a[j]);
			}
	printf("\n");
}

void input(int a[], int &i){
	printf("Enter an integer number: ");
	scanf("%d",&a[i++]);
	display(a,i);
}

void search(int a[], int i){
	int numSearch,check=0;
	printf("Enter an integer number to search: ");
	scanf("%d",&numSearch);
	for(int j=0; j<i; j++){
		if(a[j]==numSearch){
			check=1;
		}	
	}
	if(check==1){
		printf("This number at: ");
		for(int j=0; j<i; j++){
			if(a[j]==numSearch){
				printf("%d\n",j+1);
			}	
		}
	}
	if(check==0){
		printf("This array no have this number\n");
	}
}

void swap(int &a, int &b){
	int c;
	c=a; a=b; b=c;
}

void dele1(int a[],int &i){
	int numSearch,check=0;
	printf("Enter an integer number to delete: ");
	scanf("%d",&numSearch);
	for(int j=0; j<i; j++){
		if(a[j]==numSearch){
			check=1;
		}	
	}
	if(check==1){
		int k;
		for(int j=0; j<i; j++){
			if(a[j]==numSearch){
				for(int q=j; q<i; q++){
					swap(a[q],a[q+1]);
				}
				i--; break;
			}
		}
		display(a,i);
		printf("Delete done!!!\n");
	}
	if(check==0){
		printf("This array no have this number\n");
	}
	
}

void dele2(int a[],int &i){
	int numSearch,check=0;
	printf("Enter an integer number to delete: ");
	scanf("%d",&numSearch);
	for(int j=0; j<i; j++){
		if(a[j]==numSearch){
			check=1;
		}	
	}
	if(check==1){
		int k;
		for(int j=0; j<i; j++){
			if(a[j]==numSearch){
				for(int q=j; q<i; q++){
					swap(a[q],a[q+1]);
				}
				i--;
			}
		}
		printf("Delete done!!!\n");
		display(a,i);
	}
	if(check==0){
		printf("This array no have this number\n");
	}
}

void increase(int a[], int i){
	int b[100];
	for(int j=0; j<i; j++){
		b[j]=a[j];
	}
	for(int k=0; k<i; k++){	
		for(int q=k; q<i;q++){
			if(b[k]>b[q])
			swap(b[k],b[q]);
		}
	}
	display(b,i);
}

void decrease(int a[], int i){
	int b[100];
	for(int j=0; j<i; j++){
		b[j]=a[j];
	}
	for(int k=0; k<i; k++){	
		for(int q=k; q<i;q++){
			if(b[k]<b[q])
			swap(b[k],b[q]);
		}
	}
	display(b,i);
}

void function2(int a[], int n, int &i){
	switch(n){
		case 1:{
			input(a,i); break;
		}
		case 2:{
			search(a,i); break;
		}
		case 3:{
			dele1(a,i); break;
		}
		case 4:{
			dele2(a,i); break;
		}
		case 5:{
			display(a,i); break;
		}
		case 6:{
			increase(a,i); break;
		}
		case 7:{
			decrease(a,i); break;
		}
	}
}

void function1(int a[]){
	int option, i=0;
	do{
		printf("1- Add a value\n");
		printf("2- Search a value\n");
		printf("3- Remove the first existence of a value\n");
		printf("4- Remove all existences of a value\n");
		printf("5- Print out the array \n");
		printf("6- Sort the array in ascending order\n");
		printf("7- Sort the array in descending order\n");
		scanf("%d",&option);
		function2(a,option,i);
		if(option<1||option>7) return;
	}while(1);
}

int main(){
	int a[100];
	function1(a);
}
