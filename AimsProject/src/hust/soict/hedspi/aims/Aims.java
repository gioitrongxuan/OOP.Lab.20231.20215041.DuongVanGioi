package hust.soict.hedspi.aims;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.screen.manager.CartManagerScreen;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;
public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static final Scanner scanner = new Scanner(System.in);
//	Main menu
//	1. View store
//	2. Update store
//	3. See current cart
//	0. Exit
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void main(String[] args) throws LimitExceededException {
		int choice;
		do {
			//////////////// nhap
			//////////////
			//Nhap media
			DigitalVideoDisc dvd1 = new DigitalVideoDisc("D001", "The Matrix", "Action", "Wachowski Brothers", 136, 19.99f);
			DigitalVideoDisc dvd2 = new DigitalVideoDisc("D002", "Inception", "Sci-Fi", "Christopher Nolan", 148, 24.99f);
			DigitalVideoDisc dvd3 = new DigitalVideoDisc("D003", "The Shawshank Redemption", "Drama", "Frank Darabont", 142, 15.99f);
			DigitalVideoDisc dvd4 = new DigitalVideoDisc("D004", "Forrest Gump", "Drama", "Robert Zemeckis", 142, 18.99f);
			DigitalVideoDisc dvd5 = new DigitalVideoDisc("D005", "The Dark Knight", "Action", "Christopher Nolan", 152, 21.99f);
			DigitalVideoDisc dvd6 = new DigitalVideoDisc("D006", "Pulp Fiction", "Crime", "Quentin Tarantino", 154, 17.99f);
			DigitalVideoDisc dvd7 = new DigitalVideoDisc("D007", "The Godfather", "Crime", "Francis Ford Coppola", 175, 22.99f);
			DigitalVideoDisc dvd8 = new DigitalVideoDisc("D008", "Jurassic Park", "Adventure", "Steven Spielberg", 127, 16.99f);
			DigitalVideoDisc dvd9 = new DigitalVideoDisc("D009", "Avatar", "Sci-Fi", "James Cameron", 162, 23.99f);
			DigitalVideoDisc dvd10 = new DigitalVideoDisc("D010", "Titanic", "Romance", "James Cameron", 195, 20.99f);

		    CompactDisc cd1 = new CompactDisc("C001", "Thriller", "Pop", "Michael Jackson", 42, 14.99f, "Various Artists");
		    CompactDisc cd2 = new CompactDisc("C002", "Abbey Road", "Rock", "The Beatles", 47, 18.99f, "The Beatles");
	
		    List<String> authors1 = Arrays.asList("J.K. Rowling","J.K.K Rowling");
		    Book book1 = new Book("B001", "Harry Potter and the Sorcerer's Stone", "Fantasy", 29.99f, authors1);
		    System.out.println(dvd2.toString());
		    List<String> authors2 = Arrays.asList("George Orwell");
		    Book book2 = new Book("B002", "1984", "Dystopian", 19.99f, authors2);
		    store.addMedia(book2);
		    store.addMedia(book1);
		    store.addMedia(cd1);
		    store.addMedia(cd2);
		    store.addMedia(dvd1);
		    store.addMedia(dvd2);
		    store.addMedia(dvd3);
		    store.addMedia(dvd4);
		    store.addMedia(dvd5);
		    store.addMedia(dvd6);
		    store.addMedia(dvd7);
		    store.addMedia(dvd8);
		    store.addMedia(dvd9);
		    store.addMedia(dvd10);
		    new StoreManagerScreen(store);
			new CartManagerScreen(cart);
			////////////////
			//////////
			showMenu();
			System.out.print("Your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); 
			switch (choice) {
				case 1:
					viewStore();
					break;
				case 2:
					updateStore();
					break;
				case 3:
					seeCurrentCart();
					break;
				case 0:
					System.out.println("Exiting AIMS. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please choose again.");
			}
		} while (choice != 0);

		scanner.close();
	}
//	Store menu
//	1. See a media’s details
//	2. Add a media to cart
//	3. Play a media
//	4. See current cart
//	0. Back
	public static void viewStore() throws LimitExceededException {
		int choice;
		do {
			storeMenu();
			new StoreManagerScreen(store);
			store.print();
			System.out.print("Your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); 
			switch (choice) {
				case 1:
					seeMediaDetails();
					break;
				case 2:
					addMediaToCart();
					break;
				case 3:
					playMedia();
					break;
				case 4:
					seeCurrentCart();
					break;
				case 0:
					System.out.println("Returning to main menu.");
					break;
			}
		} while (choice != 0);
		
	}	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
							//	1. See a media’s details
							public static void mediaDetailsMenu() {
								System.out.println("Options: ");
								System.out.println("--------------------------------");
								System.out.println("1. Add to cart");
								System.out.println("2. Play");
								System.out.println("0. Back");
								System.out.println("--------------------------------");
								System.out.println("Please choose a number: 0-1-2");
								}
							public static void seeMediaDetails() throws LimitExceededException {
								String title;
								System.out.println("Enter title of the media: ");
								do {
									title = scanner.nextLine();
								} while (title.isEmpty());
								 
								Media findMedia = store.searchByTitle(title);
								if (findMedia!=null){
									mediaDetailsMenu();
									int choice;
									do{
										choice = scanner.nextInt();
										scanner.nextLine();
										switch (choice) {
											case 1:
												cart.addMedia(findMedia);
												break;
											case 2:
												if(findMedia instanceof Playable)
													((Playable) findMedia).play();
												break;
											case 0:
												System.out.println("Returning to viewstore menu.");
												break;
											default:
												System.out.println("Invalid choice. Please choose again.");
										}
									} while (choice != 0);
								}else {
									System.out.println("Not found!");
								}
							}
							// 2. Add a media to cart
							public static void addMediaToCart() throws LimitExceededException {
								int index;
								System.out.println("Select media:");
								index = scanner.nextInt();
								scanner.nextLine();
								cart.addMedia(store.getItemsInStore().get(index-1));
							}
							// 3. Play a media
							public static void playMedia() {
									int index;
									System.out.println("Select media:");
									index = scanner.nextInt();
									scanner.nextLine();
									if(store.getItemsInStore().get(index-1) instanceof Playable)
									((Playable)store.getItemsInStore().get(index-1)).play();
							}
							
							
							
//	Update MENU:
//		1. Add a media to the store.
//		2. Remove a media from the store
//		0. Back
	public static void updateStore() {
		store.print();
		int choice;
		do {
			System.out.println("Update:");
			System.out.println("1. Add a media to the store.");
			System.out.println("2. Remove a media from the store");
			System.out.println("0. Back");
			System.out.println("Your choice : ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1: 
				addMediaToStore();
				break;
			case 2:
				removeMediaFromStore();
			}
		} while (choice != 0);
	}
							//	1. Add a media to the store.
							public static void addMediaToStore() {
//								//Nhap media
//								DigitalVideoDisc dvd1 = new DigitalVideoDisc("D001", "The Matrix", "Action", "Wachowski Brothers", 136, 19.99f);
//								DigitalVideoDisc dvd2 = new DigitalVideoDisc("D002", "Inception", "Sci-Fi", "Christopher Nolan", 148, 24.99f);
//								DigitalVideoDisc dvd3 = new DigitalVideoDisc("D003", "The Shawshank Redemption", "Drama", "Frank Darabont", 142, 15.99f);
//								DigitalVideoDisc dvd4 = new DigitalVideoDisc("D004", "Forrest Gump", "Drama", "Robert Zemeckis", 142, 18.99f);
//								DigitalVideoDisc dvd5 = new DigitalVideoDisc("D005", "The Dark Knight", "Action", "Christopher Nolan", 152, 21.99f);
//								DigitalVideoDisc dvd6 = new DigitalVideoDisc("D006", "Pulp Fiction", "Crime", "Quentin Tarantino", 154, 17.99f);
//								DigitalVideoDisc dvd7 = new DigitalVideoDisc("D007", "The Godfather", "Crime", "Francis Ford Coppola", 175, 22.99f);
//								DigitalVideoDisc dvd8 = new DigitalVideoDisc("D008", "Jurassic Park", "Adventure", "Steven Spielberg", 127, 16.99f);
//								DigitalVideoDisc dvd9 = new DigitalVideoDisc("D009", "Avatar", "Sci-Fi", "James Cameron", 162, 23.99f);
//								DigitalVideoDisc dvd10 = new DigitalVideoDisc("D010", "Titanic", "Romance", "James Cameron", 195, 20.99f);
//
//							    CompactDisc cd1 = new CompactDisc("C001", "Thriller", "Pop", "Michael Jackson", 42, 14.99f, "Various Artists");
//							    CompactDisc cd2 = new CompactDisc("C002", "Abbey Road", "Rock", "The Beatles", 47, 18.99f, "The Beatles");
//						
//							    List<String> authors1 = Arrays.asList("J.K. Rowling","J.K.K Rowling");
//							    Book book1 = new Book("B001", "Harry Potter and the Sorcerer's Stone", "Fantasy", 29.99f, authors1);
//							    System.out.println(dvd2.toString());
//							    List<String> authors2 = Arrays.asList("George Orwell");
//							    Book book2 = new Book("B002", "1984", "Dystopian", 19.99f, authors2);
//							    store.addMedia(book2);
//							    store.addMedia(book1);
//							    store.addMedia(cd1);
//							    store.addMedia(cd2);
//							    store.addMedia(dvd1);
//							    store.addMedia(dvd2);
//							    store.addMedia(dvd3);
//							    store.addMedia(dvd4);
//							    store.addMedia(dvd5);
//							    store.addMedia(dvd6);
//							    store.addMedia(dvd7);
//							    store.addMedia(dvd8);
//							    store.addMedia(dvd9);
//							    store.addMedia(dvd10);
							    
							}
							// 2. Remove a media from the store
							public static void removeMediaFromStore() {
								store.print();
								int index;
								System.out.println("Select media:");
								index = scanner.nextInt();
								scanner.nextLine();
								store.removeMedia(store.getItemsInStore().get(index-1));
							}
//	See cartMenu (see current cart)
//	1. Filter media in cart
//	2. Sort media in cart
//	3. Remove media from cart
//	4. Play a media
//	5. Place order
//	0. Back
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		}						
	public static void seeCurrentCart() {
		int choice;
		do {
			cartMenu();
			cart.print();
			System.out.println("Your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				filterMediaInCart();
				break;
			case 2:
				sortMediaInCart();
				break;
			case 3:
				removeMediaFromCart();
				break;
			case 4:
				playMedia();
				break;
			case 5:
				placeOrder();
				break;
			case 0:
				System.out.println("Returning to main menu.");
				break;
			default:
				System.out.println("Invalid choice. Please choose again.");
			}
		}while (choice != 0);
	}	
	
							//Filter media in cart	
							public static void filterMediaInCart() {
								
								
							}
							
							// Sort media in cart
							public static void sortMediaInCart() {
								int choice;
								do {
									System.out.println("1. Sort BY COST TITLE");
									System.out.println("2. Sort BY TITLE COST ");
									System.out.println("0. Back");
									System.out.println("Your choice: ");
									choice = scanner.nextInt();
									scanner.nextLine();
									switch (choice) {
									case 1:// Sắp xếp theo Cost, Title
										cart.sortPrint(Media.COMPARE_BY_COST_TITLE);
										break;
									case 2:// Sắp xếp theo Cost, Title
										cart.sortPrint(Media.COMPARE_BY_TITLE_COST);
										break;
									case 0:
										System.out.println("Back");
										break;
									default:
										System.out.println("Invalid choice. Please choose again.");
									}
								}while (choice != 0);
							}
							
							
							//Remove media from cart
							public static void removeMediaFromCart() {
								cart.print();
								int index;
								System.out.println("Select media:");
								index = scanner.nextInt();
								scanner.nextLine();
								cart.removeMedia(cart.getItemsOrdered().get(index-1));
							}
							// Place order
							public static void placeOrder() {
								//Implement logic to play media from cart
								System.out.println("Order placed. Cart is now empty.");
							}

}
	

	
	
	