
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.ByteStreams;

    public class ApiService {
        private static final String urlPosts = "http://jsonplaceholder.typicode.com/posts";
        private static final String urlComments = "http://jsonplaceholder.typicode.com/comments";
        private static final String urlAlbums = "http://jsonplaceholder.typicode.com/albums";
        private static final String urlPhotos = "http://jsonplaceholder.typicode.com/photos";
        private static final String urlUsers = "http://jsonplaceholder.typicode.com/users";
        private static final String urlTodos = "http://jsonplaceholder.typicode.com/todos";

        //Singleton
        public static ApiService instance;

        private ApiService() {
        }

        public static ApiService getInstance() {
            if (instance == null) {
                instance = new ApiService();
            }
            return instance;
        }
        //

        //Connection
        private static String connect(String urlInput) {
            String result = null;
            HttpURLConnection connection = null;

            try {
                URL url = new URL(urlInput);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                connection.connect();

                try (InputStream in = connection.getInputStream()) {
                    result = new String(ByteStreams.toByteArray(in));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }

            return result;
        }

        //Get and parse objects
        public static List<Post> getPosts() {
            List<Post> posts = new ArrayList<>();
            try {
                String s = connect(urlPosts);
                ObjectMapper objectMapper = new ObjectMapper();
                posts = objectMapper.readValue(s, new TypeReference<List<Post>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return posts;
        }

        public static List<Comment> getComments() {
            List<Comment> comments = new ArrayList<>();
            try {
                String s = connect(urlComments);
                ObjectMapper objectMapper = new ObjectMapper();
                comments = objectMapper.readValue(s, new TypeReference<List<Comment>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return comments;
        }

        public static List<Album> getAlbums() {
            List<Album> albums = new ArrayList<>();
            try {
                String s = connect(urlAlbums);
                ObjectMapper objectMapper = new ObjectMapper();
                albums = objectMapper.readValue(s, new TypeReference<List<Album>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return albums;
        }

        public static List<Photo> getPhotos() {
            List<Photo> photos = new ArrayList<>();
            try {
                String s = connect(urlPhotos);
                ObjectMapper objectMapper = new ObjectMapper();
                photos = objectMapper.readValue(s, new TypeReference<List<Photo>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return photos;
        }

        public static List<User1> getUsers() {
            List<User1> users = new ArrayList<>();
            try {
                String s = connect(urlUsers);
                ObjectMapper objectMapper = new ObjectMapper();
                users = objectMapper.readValue(s, new TypeReference<List<User1>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return users;
        }

        public static List<Todo> getTodos() {
            List<Todo> todos = new ArrayList<>();
            try {
                String s = connect(urlTodos);
                ObjectMapper objectMapper = new ObjectMapper();
                todos = objectMapper.readValue(s, new TypeReference<List<Todo>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return todos;
        }
    }