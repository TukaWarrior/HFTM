import 'package:media_organizer/models/db_service.dart';
import 'package:media_organizer/models/media.dart';

Future<void> main(List<String> arguments) async {

    var db = DatabaseService();
    
    await db.addBook(Book("Gedichte", 2011, "Johann Wolfgang von Goethe")); // , "Lyrik", "978-3-87291-226-8"
    await db.addBook(Book("Grimms Märchen - Die schönsten Geschichten", 2016, "Brüder Grimm")); // , "Lyrik", "978-3-74311-867-6"
    await db.addBook(Book("Gesammelte Werke", 2013, "Oscar Wilde")); // , "Lyrik", "978-3-86647-927-2"
    await db.addBook(Book("Der Herr der Ringe. Bd. 1 - Die Gefährten", 2012, "J. R. R. Tolkien")); // , "Fantasy", "978-3-608-93981-1"
    await db.addBook(Book("Kamasutra", 2015, "Kalashatra Govinda")); // , "hmmmmm", "978-3-8310-4528-0"

    print('All books:');
    var books = await db.getAllBooks();
    books.forEach(print);

    print("\nBooks by Johann Wolfgang von Goethe:");
    var orwellBooks = await db.findBooks(author: "Johann Wolfgang von Goethe");
    orwellBooks.forEach(print);

    print("\nDeleting Gedichte:");
    var deleted = await db.deleteBook("Gedichte");
    print("Deleted: $deleted");

    print('\nAll books after deletion:');
    books = await db.getAllBooks();
    books.forEach(print);
}


