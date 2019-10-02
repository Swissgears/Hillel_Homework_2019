package HTTP.Homework_21;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileStorage implements Storage {
    private Integer startUserId;
    private Integer lastUserId;
    private List<User> storage;
    private File file;

    public FileStorage(String fileName) {
        startUserId = -1;
        lastUserId = startUserId;
        storage = new ArrayList();
        file = new File("target/" + fileName);
        loadFromStorage();
    }

    private void loadFromStorage() {
        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                storage = objectMapper.readValue(file, new TypeReference<List<User>>() {
                });
                if (!storage.isEmpty()) {
                    lastUserId = storage.get(storage.size() - 1).getId();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Storage not found!");
        }
    }

    private void saveToStorage() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer createUserId() {
        return lastUserId += 1;
    }

    @Override
    public void addUser(User user) {
        if (storage.contains(user)) {
            System.out.println("User " + user.getName() + " already exist!");
        } else {
            user.setId(createUserId());
            storage.add(user);
            saveToStorage();
        }
    }

    @Override
    public void updateUser(User user) {
        if (storage.contains(user)) {
            for (int i = 0; i < storage.size(); i++) {
                if (storage.get(i).equals(user)) {
                    user.setId(storage.get(i).getId());
                    storage.set(i, user);
                    break;
                }
            }
            saveToStorage();
        } else {
            System.out.println("User " + user.getName() + " was not found!");
        }
    }

    @Override
    public User getUser(int id) {
        User user = (User) storage.get(id);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return storage;
    }

    @Override
    public void removeUser(int id) {
        storage.remove(id);
        saveToStorage();
    }

    @Override
    public void removeUserByName(String name) {
        User user = new User(name, 0);
        if (storage.contains(user)) {
            for (int i = 0; i < storage.size(); i++) {
                if (storage.get(i).equals(user)) {
                    storage.remove(i);
                    break;
                }
            }
            saveToStorage();
        } else {
            System.out.println("User " + name + " was not found!");
        }
    }

    @Override
    public void removeAll() {
        storage.clear();
        saveToStorage();
    }
}