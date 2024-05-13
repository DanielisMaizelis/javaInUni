package se.hkr.poker;

import java.util.ArrayList;

public class Deck
{
    final int PAIR_CARD_AMOUNT = 5;
    private ArrayList<ArrayList<String>> deck;
    private ArrayList<ArrayList<String>> hand;
    private final String[] suits = {"HEARTS","DIAMONDS","SPADES","CLUBS"};
    private final String[] ranks = {"TWO","THREE","FOUR","FIVE","SIX",
                     "SEVEN","EIGHT", "NINE", "TEN",
                     "JACK","QUEEN", "KING", "ACE"};

    public Deck()
    {
        this.deck = new ArrayList<>();
        this.hand = new ArrayList<>();
    }

    private void createDeck()
    {
        for(String suit: suits)
        {
            for (String rank: ranks)
            {
                // Inside the value list array, the rank and the suit is added:
                ArrayList<String> values = new ArrayList<>();
                values.add(rank);
                values.add(suit);
                // This ArrayList containing the card values is added to the deck
                // The result is 52 cards, containing each a rank and a suit.
                this.deck.add(values);
            }
        }
    }

    public void generateHand()
    {
        this.hand = new ArrayList<>();
        this.createDeck();
        java.util.Random rand = new java.util.Random();

        for (int j = 0; j<PAIR_CARD_AMOUNT; j++)
        {
            ArrayList<String> randomCard = new ArrayList<>();
            String rank;
            String suit;

            // Random number is made
            int randomNum  = rand.nextInt(this.deck.size());
            // random card is received from the deck of the random index
            randomCard     = this.deck.get(randomNum);

            // Value and suit is added to an arrayList
            rank = this.deck.get(randomNum).get(0);
            suit  = this.deck.get(randomNum).get(1);
            randomCard.add(rank);
            randomCard.add(suit);

            // The arrayList with the card's value and suit is added
            this.hand.add(randomCard);
            // The deck's card, that was chose is removed from the deck, to prevent duplicates
            this.deck.remove(randomCard);
        }
    }


    public ArrayList<ArrayList<String>> getHand()
    {
        return this.hand;
    }
}
