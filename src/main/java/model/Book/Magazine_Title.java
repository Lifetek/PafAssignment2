package model.Book;

/**
 * Created by fatih on 27-11-2017.
 */
public class Magazine_Title extends Title {
    private int lendingTime; // in dagen

    private Magazine_Title() {
        lendingTime = 3;
    }

    @Override
    public String toString() {
        return "Magazine_Title{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", itemList=" + itemList +
                ", reservationList=" + reservationList +
                ", lendingTime=" + lendingTime +
                '}';
    }
}
