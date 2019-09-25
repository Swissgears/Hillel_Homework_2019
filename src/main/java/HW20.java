
import java.util.List;

    public class HW20 {
        public static void main(String[] args) {
            ApiService service = ApiService.getInstance();

            List<Post> posts = service.getPosts();
            System.out.println("Posts");
            System.out.println(posts.toString());

            List<Comment> comments = service.getComments();
            System.out.println("Comments");
            System.out.println(comments.toString());

            List<Album> albums = service.getAlbums();
            System.out.println("Albums");
            System.out.println(albums.toString());

            List<Photo> photos = service.getPhotos();
            System.out.println("Photos");
            System.out.println(photos.toString());

            List<User1> users = service.getUsers();
            System.out.println("Users");
            System.out.println(users.toString());

            List<Todo> todos = service.getTodos();
            System.out.println("Todos");
            System.out.println(todos.toString());
        }
    }

//    РќР°РїРёСЃР°С‚СЊ РєР»Р°СЃСЃ MyApiService СЃ РёСЃРїРѕР»СЊР·РѕРІР°РЅРёРµРј РїР°С‚С‚РµСЂРЅР° СЃРёРЅРіР»С‚РѕРЅ РґР»СЏ РґРѕСЃС‚СѓРїР° Рє API:
//
//        (РїСЂРµРґРІР°СЂРёС‚РµР»СЊРЅРѕ СЃРѕР·РґР°С‚СЊ РІСЃРµ РЅРµРѕР±С…РѕРґРёРјС‹Рµ РјРѕРґРµР»Рё List, Post, User1...)
//
//        РџСЂРёРјРµСЂ:
//
//        ApiService service = ApiService.getInstance();
//
//        List<Post> posts = service.getPosts();
//
//        Р”Р»СЏ СЃР»РµРґСѓСЋС‰РёС… Р·Р°РїСЂРѕСЃРѕРІ:
//
//        Posts https://jsonplaceholder.typicode.com/posts
//
//        Comments https://jsonplaceholder.typicode.com/comments
//
//        Albums https://jsonplaceholder.typicode.com/albums
//
//        Photos https://jsonplaceholder.typicode.com/photos
//
//        Users https://jsonplaceholder.typicode.com/users
//
//        Todos https://jsonplaceholder.typicode.com/todos