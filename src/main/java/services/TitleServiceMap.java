package services;

import domain_model.Title;
import org.omg.CORBA.UserException;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by fatih on 30-11-2017.
 */
public class TitleServiceMap implements TitleService {
    private HashMap<String, Title> titleMap;

    public TitleServiceMap(){
        titleMap = new HashMap<>();
    }



    @Override
    public void addTitle(Title title) {
        titleMap.put(title.getName(), title);
    }

    @Override
    public Collection<Title> getTitles() {
        return titleMap.values();
    }

    @Override
    public Title getTitle(String name) {
        return titleMap.get(name);
    }

    @Override
    public Title editTitle(Title forEdit) throws UserException, TitleException {
        try {
            if (forEdit.getName() == null)
                throw new TitleException("Name cannot be blank");

            Title toEdit = titleMap.get(forEdit.getName());

            if (toEdit == null)
                throw new TitleException("Title not found");

//            if (forEdit.getId() != null) {
//                toEdit.setId(forEdit.getId());
//            }

            return toEdit;
        } catch (Exception ex) {
            throw new TitleException(ex.getMessage());
        }
    }

    @Override
    public void deleteTitle(String name) {
        titleMap.remove(name);
    }

    @Override
    public boolean TitleExist(String name) {
        return titleMap.containsKey(name);
    }
}
