import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card {
    public String suit;
    public int rank;
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s,%d]",suit,rank);
    }
}

class CardDemo{
    public static final String[] SUITS = {"♠","♥","♦","♣"};
    //买牌
    public List<Card> buyDeck() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0;i < 4;i++) {
            for (int j = 1;j <= 13;j++) {
                String suit = SUITS[i];
                Card card = new Card(suit,j);
                cards.add(card);
            }
        }
        return cards;
    }

    private void swap(List<Card> cards,int i,int index) {
        Card tmp = cards.get(i);
        cards.set(i,cards.get(index));
        cards.set(index,tmp);
    }
    //洗牌
    public void shuffle(List<Card> cards) {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int index = random.nextInt(i);
            swap(cards,i,index);
        }
    }
}

class Test1 {
    public static void main(String[] args) {
        CardDemo cardDemo = new CardDemo();
        List<Card> cards = cardDemo.buyDeck();
        System.out.println(cards);
        //洗牌
        System.out.println("洗牌");
        cardDemo.shuffle(cards);
        System.out.println(cards);
        //发牌
        System.out.println("发牌");
        List<List<Card>> hands = new ArrayList<>();
        //第一个人手里的牌
        List<Card> list1 = new ArrayList<>();
        //第二个人手里的牌
        List<Card> list2 = new ArrayList<>();
        //第三个人手里的牌
        List<Card> list3 = new ArrayList<>();
        hands.add(list1);
        hands.add(list2);
        hands.add(list3);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card removeCard = cards.remove(0);
                hands.get(j).add(removeCard);
            }
        }
        System.out.println("第一个人手里的牌");
        System.out.println(list1);
        System.out.println("第二个人手里的牌");
        System.out.println(list2);
        System.out.println("第三个人手里的牌");
        System.out.println(list3);
        System.out.println("剩下的牌");
        System.out.println(cards);
    }
}


