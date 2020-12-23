package xmlLessons;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.events.EndElement;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CatalogXMLWorker {

    public static Catalog loadCatalogFromXMLFile(File file){

        Catalog catalog = new Catalog();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element root = document.getDocumentElement();
            NodeList books = root.getChildNodes();

            for(int i = 0; i < books.getLength(); i++){

                Node node = books.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    Book book = getBookFromNode(element);
                    if(book!=null){
                        catalog.addBook(book);
                    }
                }

            }

        }catch (Exception e){
            return null;
        }
        return catalog;
    }
    private static Book getBookFromNode(Element bookElement){
        if( !bookElement.getTagName().equals("book")){
            return null;
        }

        String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
        String title =  bookElement.getElementsByTagName("title").item(0).getTextContent();
        String genre =  bookElement.getElementsByTagName("genre").item(0).getTextContent();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateText      = bookElement.getElementsByTagName("publish_date").item(0).getTextContent();
        Date publishDate = new Date();
        try {
            publishDate     = sdf.parse(dateText);
        } catch (ParseException e) {
            System.out.println("Error load publish_date");
        }

        Node priceNode = bookElement.getElementsByTagName("price").item(0);
        double price = Double.valueOf(priceNode.getTextContent());
        Book book = new Book(author,title,genre,price,publishDate);
        if(priceNode.hasAttributes()){
            Node currencyNode = priceNode.getAttributes().item(0);
            String curr = currencyNode.getNodeValue();
            book.setCur(curr);
        }

        return book;
    }
    private static Element elementFromBook(Book book, Document document){

        Element bookElement = document.createElement("book");
        Element author = document.createElement("author");
        author.setTextContent(book.getAuthor());

        Element title = document.createElement("title");
        title.setTextContent(book.getTitle());

        Element genre = document.createElement("genre");
        title.setTextContent(book.getTitle());

        Element price = document.createElement("price");
        title.setTextContent(book.getTitle());

        if(!book.getCur().name().equals("UAN")){
            price.setAttribute("currency",book.getCur().name());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Element publishDate = document.createElement("publish_Date");
        publishDate.setTextContent(sdf.format(book.getPublishDate()));
        bookElement.appendChild(author);
        bookElement.appendChild(title);
        bookElement.appendChild(genre);
        bookElement.appendChild(price);
        bookElement.appendChild(publishDate);
        return bookElement;
    }

    public static void saveToXML(Catalog catalog, String fileName){

    }


}
