import java.util.Scanner;
public class StudentGradeTracker{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
{
System.out.println("Student Grade Tracker");
System.out.println("Enter the number of students");
int n=sc.nextInt();
String[]names=new String[n];
int[] grades=new int[n];
for(int i=0;i<n;i++)
{
System.out.println("Enter student"+(i+1)+"name:");
names[i]=sc.next();
System.out.println("Enter student"+(i+1)+"grade:");
grades[i]=sc.nextInt();
}
int total=0;
for(int i=0;i<n;i++)
{
total=total+grades[i];
}
double average=(double) total/n;
int highest=grades[0];
for(int i=1;i<n;i++)
{
if(grades[i]>highest)
{
highest=grades[i];
}
}
int lowest=grades[0];
for(int i=1;i<n;i++)
{
if(grades[i]<lowest)
{
lowest=grades[i];
}
}
System.out.println("\n-----Student Grade Report-----");
for(int i=0;i<n;i++)
{
System.out.println(names[i]+":"+grades[i]);
}
System.out.println("Average:"+average);
System.out.println("Highest:"+highest);
System.out.println("Lowest:"+lowest);
}
}
}