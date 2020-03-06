import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class card_sort
{
    public static void main(String[] args) throws Exception
    {
        Scanner fromFile = new Scanner(new File("card_sort.dat"));
        ArrayList<Card> cards = new ArrayList<>();

        while(fromFile.hasNextLine())
        {
            String[] data = fromFile.nextLine().split("/");
            cards.add(new Card(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2])));
        }

        Collections.sort(cards);

        for(int x=cards.size()-1; x>=0;x--)
            System.out.println(cards.get(x));
    }
}

class Card implements Comparable
{
    String name;
    int attack, armor;

    public Card(String name, int attack, int armor) {
        this.name = name;
        this.attack = attack;
        this.armor = armor;
    }

    public int compareTo(Object o)
    {
        Card c = (Card)o;

       if(attack+armor!=(c.armor+c.attack))
           return (attack+armor)-(c.armor+c.attack);
       else if(attack!=c.attack)
           return attack-c.attack;
       else
           return c.name.compareTo(name);
    }

    public String toString()
    {
        return (attack+armor)+" ("+name+"/"+attack+"/"+armor+")";
    }
}