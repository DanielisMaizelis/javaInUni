package se.hkr.poker;
import java.util.*;

public class Hand
{
    private ArrayList<ArrayList<String>> hand;

    public Hand(ArrayList<ArrayList<String>> hand)
    {
        this.hand = hand;
    }

    public void evaluate()
    {
        ArrayList<String> highCards  = new ArrayList<String>();
        ArrayList<String> pairs      = new ArrayList<String>();
        this.getHighCards(highCards);
        this.getPairs(pairs);
        this.printData(pairs,highCards);
    }


    private void getPairs(ArrayList<String> pairs)
    {
        // Temporary array, which is the same arraylist as this.hand
        // This is used to see if there are any matches in this.hand
        ArrayList<ArrayList<String>> tempHand = new ArrayList<>(this.hand);

        for (ArrayList<String> card : this.hand)
        {
            // How many cards with the same value are found
            int     matches      = 0;
            // Flag for when the pair is found
            boolean pairFound    = false;

            // Value of the card (Ace, Jack, etc...)
            String  value        = card.get(0);

            for (ArrayList<String> cardTemp : tempHand)
            {
                // If the card in the temporary array is not set to null yet:
                // This is to prevent errors when extracting the get method.
                if(!Objects.equals(cardTemp,null))
                {
                    // Card value match is found in the temporary array
                    if (Objects.equals(value,cardTemp.get(0)))
                    {
                        // Sets the card in the temporary array to null
                        tempHand.set(tempHand.indexOf(cardTemp),null);

                        // Increments a match. Each card gets 1 match
                        matches++;
                    }
                }
                // There are 2 matches in the temporary array:
                if (matches == 2 && !pairFound)
                {
                    // Sets the flag, so that the "if" statement does not repeat itself
                    pairFound = true;
                    // Adds the value of the card pairs to the pair arraylist
                    pairs.add(value);
                }
            }
        }
    }

    // Private method for getting the high cards
    private void getHighCards(ArrayList<String> highCards)
    {
        // Goes through each card in the hand:
        for (ArrayList<String> card : this.hand)
        {
            String cardValue = card.get(0);
            String cardSuit  = card.get(1);

            // The card has any of the high ranking values:
            if(cardValue.contains("ACE") || cardValue.contains("KING") || cardValue.contains("QUEEN")  || cardValue.contains("JACK")  || cardValue.contains("TEN"))
            {
                // Adds the high cards:
                highCards.add(cardValue+" of "+cardSuit);
            }
        }
    }


    // Prints all the hand data onto the terminal:
    private void printData(ArrayList<String> pairs, ArrayList<String> highCards)
    {
        System.out.println("--- Poker Hand Evaluation ---");
        System.out.println("Your hand:");

        // Prints each hand's value and suit
        for (ArrayList<String> cards: this.hand)
        {
            String value = cards.get(0);
            String suit  = cards.get(1);
            System.out.println(value+" of "+suit);
        }
        System.out.println("\nEvaluation result:");

        this.printEvaluationResult(highCards,"High cards: ");
        this.printEvaluationResult(pairs,"\nPairs: ");

        // Extra space if another hands are printed
        System.out.println();
        System.out.println();
    }
    // Template for printing found pairs ot high cards
    private void printEvaluationResult(ArrayList<String> pairsOrHighCards, String menuText)
    {
        System.out.print(menuText);
        if(pairsOrHighCards.isEmpty())
        {
            System.out.print("None");
        }
        else
        {
            for (String pairOrHighCard: pairsOrHighCards)
            {
                // It is the last object in the array, so no comma is written
                if(Objects.equals(pairOrHighCard, pairsOrHighCards.get(pairsOrHighCards.size()-1)))
                {
                    System.out.print(pairOrHighCard);
                }
                // Otherwise, the comma is written after the object listed
                else
                {
                    System.out.print(pairOrHighCard+", ");
                }
            }
        }
    }
}
