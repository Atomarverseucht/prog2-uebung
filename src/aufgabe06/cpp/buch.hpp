#ifndef BUCH_HPP
#define BUCH_HPP

#include "person.hpp"
#include <iostream>
#include <string>

namespace aufgabe6 {

class Person;

class Buch {
private:
  Person *entleiher;
  std::string name;

public:
  Buch(const std::string &);
  Buch(const Buch &) = delete;
  Buch &operator=(const Buch &) = delete;
  Buch(Buch &&) = delete;
  Buch &operator=(Buch &&) = delete;
  // ~Buch() = default;

  // member functions
  void print();
  std::string getName() const;
  Person *getEntleiher();
  bool wirdAusgeliehen(Person *p);
  bool wirdZurueckGegeben();
  friend std::ostream& operator<<(std::ostream& os, const Buch& b);
};
// std::ostream &operator<<(std::ostream &os, const Buch &b);
} // namespace aufgabe6

#endif
