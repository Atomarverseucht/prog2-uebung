#ifndef BUCH_HPP
#define BUCH_HPP

#include <iostream>
#include <string>

class buch {
private:
  person* entleiher;

public:
  std::string name;
  buch(const std::string&);
  buch(const buch&) = delete;
  buch &operator=(const buch&) = delete;
  buch(buch&&) = delete;
  buch &operator=(buch&&) = delete;
  // ~buch() = default;

  // member functions
  void printf(void) {
    std::cout << name
              << (entleiher == nullptr ? ": nicht ausgeliehen"
                                       : "ausgeliehen von " << entleiher);
  }
  std::string getName(void) { return name; }
  person* getEntleiher(void) { return entleiher; }
  bool wirdAusgeliehen(person* p) {
    if (entleiher != nullptr) {
      return false;
    }
    entleiher = p;
    p.leihtAus(this);
    return true;
  }
  bool wirdZurueckGegeben(void) {
    if (entleiher == nullptr) {
      return false;
    }
    entleiher.gibtZurueck(this);
    entleiher = nullptr;
    return true;
  }
};

#endif
