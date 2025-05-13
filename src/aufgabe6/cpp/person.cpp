#include "buch.hpp"

#include "person.hpp"
#include <algorithm>
#include <iostream>

namespace aufgabe6 {

Person::Person(const std::string &name) : name(name) {}

void Person::print() const {
  std::cout << name << " hat ausgeliehen: ";

  if (ausgB.empty()) {
    std::cout << "[]";
  } else {
    std::cout << "[";
    std::for_each(ausgB.begin(), ausgB.end(),
                  [](const Buch *b) { std::cout << b->getName() << ", "; });
    std::cout << "]";
  }
  std::cout << std::endl;
}

size_t Person::getAnzahlAusgelieheneBuecher() const { return ausgB.size(); }

bool Person::leihtAus(Buch *b) {
  if ((b->getEntleiher() != nullptr && b->getEntleiher() != this) ||
      (std::find(ausgB.begin(), ausgB.end(), b) != ausgB.end()))
    return false;
  ausgB.push_back(b);
  b->wirdAusgeliehen(this);
  return true;
}
bool Person::gibtZurueck(Buch *b) {
  if (!(std::find(ausgB.begin(), ausgB.end(), b) != ausgB.end()))
    return false;
  ausgB.remove(b);
  b->wirdZurueckGegeben();
  return true;
}
std::string Person::getName() const { return name; }

std::ostream &operator<<(std::ostream &os, const Person &p) {
  return os << p.name;
}

} // namespace aufgabe6
