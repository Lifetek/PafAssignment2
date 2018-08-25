package model.Book;

/**
 * Created by fatih on 27-11-2017.
 */
public class Book_Title extends Title {
    private int lendingTime; // in dagen

    private Book_Title() {
        lendingTime = 14;
    }

    @Override
    public String toString() {
        return "Book_Title{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", itemList=" + itemList +
                ", reservationList=" + reservationList +
                ", lendingTime=" + lendingTime +
                '}';
    }
}
