import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import static java.lang.Math.round;

public class JsonPathApp {
    public static void main(String[] args) throws IOException {
        String json = """
                {"store": {
                        "book": [
                            {
                                "category": "reference",
                                "author": "Nigel Rees",
                                "title": "Au bord de l'eau",
                                "price": 8.95
                            },
                            {
                                "category": "fiction",
                                "author": "Evelyn Waugh",
                                "title": "Sword of Honour",
                                "price": 12.99
                            },
                            {
                                "category": "fiction",
                                "author": "Herman Melville",
                                "title": "Moby Dick",
                                "isbn": "0-553-21311-3",
                                "price": 8.99
                            },
                            {
                                "category": "fiction",
                                "author": "J. R. R. Tolkien",
                                "title": "The Lord of the Rings",
                                "isbn": "0-395-19395-8",
                                "price": 22.99
                            }
                        ],
                        "bicycle": {
                            "color": "red",
                            "price": 19.95
                        }
                    },
                    "expensive": 10}""";

        //Parse JSON
        ReadContext ctx = JsonPath.parse(json);

        //Bookstore
        List<String> authorsOfBooksWithISBN = ctx.read("$.store.book[?(@.isbn)].author"); //authors of books with an isbn
        String author0 = ctx.read("$.store.book[0].author"); //author of first book
        List<String> authors = ctx.read("$.store.book[*].author"); //all authors of books with authors
        List<String> books = ctx.read("$.store.book[*]"); //all books

        System.out.println(author0);
        System.out.println(authorsOfBooksWithISBN);
        System.out.println(authors);
        System.out.println(books);
    }
}
