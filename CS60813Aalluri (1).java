import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;




public class CS60813Aalluri {
	static int q=1;
	public static void main(String[]args)throws Exception
	{
		CS60813Aalluri ob =new CS60813Aalluri();
		try
		{
		System.out.println("Name:vineetha Alluri");
		System.out.println("course id:CS608");
		System.out.println(java.time.LocalDate.now());
		FileReader fr=new FileReader("C:\\Users\\Vineetha\\Desktop\\LUPEx.txt");
		BufferedReader br=new BufferedReader(fr);
		FileInputStream fs=new FileInputStream("C:\\Users\\Vineetha\\Desktop\\LUPEx.txt");
		Scanner sc=new Scanner(fs);
while(sc.hasNextLine()==true)
{

int[] input = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
ob.calculation(input);
q++;
}	
sc.close();
br.close();
}
catch(Exception e)
{
			
}
}
void calculation(int[] arr)
{

	ArrayList<Integer> list=new ArrayList<Integer>();
	for(int i=0;i<arr.length;i++)
	{
		list.add(arr[i]);
	}
list.add(0,0);


int[] SL=new int[arr.length+1];
int[] PH=new int[arr.length+1];
int[] fin = list.stream().mapToInt(i -> i).toArray();
System.out.println("\n");
System.out.println("Evaluation of line "+q+" :");
System.out.println(Arrays.toString(fin));
for(int j=0;j<fin.length;j++)
{
if(fin[j]==0)
{
	SL[j]=0;
	PH[j]=0;
}
else if(fin[j]>0) 
{
	int p=0;
	int n=fin[j];
	p=find_SL(fin,n,j,SL);
	SL[j]=p+1;
	int x=find_PH(fin,n,j,SL);
	PH[j]=x;
}
}
System.out.println(Arrays.toString(SL));
System.out.println(Arrays.toString(PH));
print_elements(fin,SL,PH);
}
int find_SL(int[] fin,int n,int j,int[] SL)    
{
	int t=0;
for(int k=0;k<j;k++)
{    
	if(fin[k]<fin[j] && SL[k]>t)
	{   
	t=SL[k];
	}
}return t;
}
int find_PH(int[] fin,int n,int j,int[] SL)    
{
	int t=0;
	int count=0;
for(int k=0;k<j;k++)
{    
	if(fin[k]<fin[j] && SL[k]>t)
	{   
	t=SL[k];
	count=fin[k];
	}
}return count;
}
void print_elements(int[] fin,int[] SL,int[] PH)
{    
     ArrayList<Integer> output=new ArrayList<Integer>();
	int n=max_SL(SL);
	System.out.println("Length of the subsequence is:"+n);
	int p=initialize(SL);
	
	output.add(fin[p]);
	int x=PH[p];
	find(fin,PH,x,output);
	
}
void find(int[] fin,int[] PH,int x,ArrayList<Integer> output)
{
	int count=0;
for(int l=0;l<fin.length;l++)
{
	if(fin[l]!=0 && fin[l]==x)
	{   
		count=l;
	    output.add(fin[l]);
		
	}
}
int val=PH[count];
if(val!=0)
{
find(fin,PH,val,output);
}
else if(val==0)
{
ListIterator<Integer> li=output.listIterator(output.size());
System.out.println("Longest up sequence is:");
while(li.hasPrevious())
{
	System.out.println(li.previous());
}
}
}
int max_SL(int[] SL)
{ int max=SL[0];
	for(int z=0;z<SL.length;z++)
	{
		if(max<SL[z])
		{
			max=SL[z];
		}
		
	}return max;
}
int initialize(int[] SL)
{
	int max=SL[0];
	int count=0;
	for(int z=0;z<SL.length;z++)
	{
		if(max<SL[z])
		{
			max=SL[z];
			count=z;
		}
		
	}return count;
}

}