void main() {
  var name = '''Shah Jahan was the fifth ruler of the Mughal dynasty.
  During his third regnal year, his favorite wife, known as Mumtaz Mahal,
  died due to complications arising from the birth of their fourteenth child.
  Deeply saddened, the emperor started planning the construction of a suitable,
  permanent resting place for his beloved wife almost immediately. The result of 
  his efforts and resources was the creation of what was called the Luminous Tomb 
  in contemporary Mughal texts and is what the world knows today as the Taj Mahal.''';
  var regularExp = RegExp(r"[\\-\s+\\,]");
  var listStr = name.split(regularExp);
  for (var item in listStr) {
    print(item);
  }
}
