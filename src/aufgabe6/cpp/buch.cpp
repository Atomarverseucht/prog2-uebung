
#include "buch.hpp"
#include "person.hpp"

namespace aufgabe6 {

Buch::Buch(const std::string &name) : name(name), entleiher(nullptr) {}

void Buch::print(void) {
  if (entleiher == nullptr) {
    std::cout << name << ": nicht ausgeliehen";
  } else {
    std::cout << name << ": ausgeliehen von " << entleiher->getName();
  }
  std::cout << std::endl;
}
std::string Buch::getName() const { return name; }

Person *Buch::getEntleiher() { return entleiher; }

bool Buch::wirdAusgeliehen(Person *p) {
  if (entleiher != nullptr) {
    return false;
  }
  entleiher = p;
  p->leihtAus(this);
  return true;
}
bool Buch::wirdZurueckGegeben() {
  if (entleiher == nullptr) {
    return false;
  }
  entleiher->gibtZurueck(this);
  entleiher = nullptr;
  return true;
}
std::ostream &operator<<(std::ostream &os, const Buch &b) {
  return os << b.name;
}
} // namespace aufgabe6
