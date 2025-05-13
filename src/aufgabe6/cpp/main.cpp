
#include "buch.hpp"
#include "person.hpp"
#include <iostream>

using namespace aufgabe6;

int main() {
  std::cout << "=== Library System Test ===" << std::endl;
  std::cout << "Current Date: 2025-05-13" << std::endl;
  std::cout << "User: Herbert-Haase" << std::endl;
  std::cout << "=========================" << std::endl << std::endl;

  // Create books
  Buch *book1 = new Buch("C++ Programming");
  Buch *book2 = new Buch("Algorithms and Data Structures");
  Buch *book3 = new Buch("Design Patterns");

  // Create people
  Person *person1 = new Person("Herbert");
  Person *person2 = new Person("Anna");

  std::cout << "Initial state:" << std::endl;
  book1->print();
  book2->print();
  book3->print();
  person1->print();
  person2->print();
  std::cout << std::endl;

  // Test borrowing books
  std::cout << "Borrowing books:" << std::endl;
  std::cout << "Herbert borrows 'C++ Programming': "
            << (person1->leihtAus(book1) ? "success" : "failed") << std::endl;
  std::cout << "Herbert borrows 'Algorithms and Data Structures': "
            << (person1->leihtAus(book2) ? "success" : "failed") << std::endl;
  std::cout << "Anna borrows 'Design Patterns': "
            << (person2->leihtAus(book3) ? "success" : "failed") << std::endl;
  std::cout << "Anna tries to borrow 'C++ Programming' (already borrowed): "
            << (person2->leihtAus(book1) ? "success" : "failed") << std::endl;
  std::cout << std::endl;

  // Print state after borrowing
  std::cout << "State after borrowing:" << std::endl;
  book1->print();
  book2->print();
  book3->print();
  person1->print();
  person2->print();
  std::cout << std::endl;

  // Test returning books
  std::cout << "Returning books:" << std::endl;
  std::cout << "Herbert returns 'C++ Programming': "
            << (book1->wirdZurueckGegeben() ? "success" : "failed")
            << std::endl;
  std::cout << "Anna tries to return 'C++ Programming' (not borrowed by her): "
            << (person2->gibtZurueck(book1) ? "success" : "failed")
            << std::endl;
  std::cout << "Anna returns 'Design Patterns': "
            << (person2->gibtZurueck(book3) ? "success" : "failed")
            << std::endl;
  std::cout << std::endl;

  // Print final state
  std::cout << "Final state:" << std::endl;
  book1->print();
  book2->print();
  book3->print();
  person1->print();
  person2->print();
  std::cout << std::endl;

  // Check number of borrowed books
  std::cout << "Herbert has borrowed "
            << person1->getAnzahlAusgelieheneBuecher() << " books."
            << std::endl;
  std::cout << "Anna has borrowed " << person2->getAnzahlAusgelieheneBuecher()
            << " books." << std::endl;

  // Clean up
  delete book1;
  delete book2;
  delete book3;
  delete person1;
  delete person2;

  return 0;
}
