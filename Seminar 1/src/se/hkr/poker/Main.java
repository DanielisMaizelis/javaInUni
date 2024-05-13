package se.hkr.poker;

public class Main
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        deck.generateHand();
        Hand hand1 = new Hand(deck.getHand());
        hand1.evaluate();
    }
}