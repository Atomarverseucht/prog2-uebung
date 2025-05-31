#ifndef PERSON_HPP
#define PERSON_HPP

#include <iostream>
#include <list>
#include <ostream>
#include <string>

namespace aufgabe6 {

class Buch;

class Person {
private:
  std::string name;
  std::list<Buch *> ausgB;

public:
  Person(const std::string &);
  Person(const Person &) = delete;
  Person &operator=(const Person &) = delete;
  Person(Person &&) = delete;
  Person &operator=(Person &&) = delete;
  // ~Person() = default;

  // member functions
  void print() const;
  size_t getAnzahlAusgelieheneBuecher() const;
  bool leihtAus(Buch *b);
  bool gibtZurueck(Buch *b);
  std::string getName() const;
  friend std::ostream &operator<<(std::ostream &os, const Person &p);
};
// std::ostream &operator<<(std::ostream &os, const Person &p);

} // namespace aufgabe6
#endif
