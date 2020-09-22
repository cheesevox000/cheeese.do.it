#include <stdio.h>
#include <string.h>

void input(char a[]){
	printf("Please enter string: ");
	gets(a);
}

void dele(char a[], int &n, int position){
	for(int i=position; i<n; i++){
		a[position]=a[position+1];
	}
	a[n-1]='\0';
}

void outputText(char a[], int len){
	for(int i=0; i<len-1; i++){
		printf("%c\t",a[i]);
	}
	printf("%d\n",len);
}
void outputNumber(char a[], int b[], int len){
	printf("\n");
	for(int i=0; i<len-1; i++){
		printf("%d\t",b[i]);
	}
	printf("%d\n",len);
}

void count(char a[], int b[], int &len){
	int n=0;
	for(int i=0; i<len; i++){
		if((int)a[i]==32)	continue;
		b[n]=1;
		for(int j=i+1; j<len; j++){
			if((int)a[i]==(int)a[j] || (int)a[i]==(int)a[j]+65){
				b[n]++;
				dele(a,len,j);
			}
		}
		n++;
	}
}

int main(){
	char a[100];
	int len,b[100];
	input(a);
	len=strlen(a);
	count(a,b,len);
	outputText(a,len);
	outputNumber(a,b,len);
}
