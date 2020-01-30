package UIL;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        class Person implements Comparable{
            double heightCp;
            String first;
            String last;
            int height;

            Person(String last,String first, double height){
                this.heightCp = height;
                this.first = first;
                this.last = last;
                this.height = (int)(12 * Math.floor(height) + (height - Math.floor(height)));
            }

            public int compareTo(Object o){
                Person person = (Person)o;
                int comp;
                comp  = last.compareTo(person.last);
                if(comp != 0) return comp;
                comp = first.compareTo(person.first);
                if(comp != 0) return comp;
                if(height > person.height) return 1;
                if(height < person.height) return -1;
                return 0;
            }

            public String toString(){
                DecimalFormat decimalFormat = new DecimalFormat(".##");
                return(String.format("%s %s %s",first,last, decimalFormat.format(heightCp)));
            }
        }

        class RecurSort{
            List<Person> recurSort(List<Person> people){
                if(people.size() == 1){
                    return people;
                }
                else{
                    List slice = people.subList(0,people.size()/2);
                    Collections.sort(slice);
                    List<Person> test = people.subList(people.size() - slice.size() - (people.size() % 2 == 1?1:0), people.size());
                    return slice;
                }
            }
        }

        Scanner dat = new Scanner(new File("sort.dat"));
        StringBuilder res = new StringBuilder();
        ArrayList<Person> people = new ArrayList<Person>();
        while(dat.hasNextLine()){
            Scanner scn = new Scanner(dat.nextLine());
            people.add(new Person(scn.next(),scn.next(),scn.nextDouble()));
        }
        new RecurSort().recurSort(people);
        for(Person person: people){
            res.append(person + "\n");
        }


        System.out.println(res);
    }
}
