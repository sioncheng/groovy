
import groovy.time.TimeCategory

def janFirst1970 = new Date(0)
use TimeCategory, {
    Date xmas = janFirst1970 + 1.year - 7.days
    assert xmas.month == Calendar.DECEMBER
    assert xmas.date == 25
}

// class Marshal {
//     static String mashal(Integer self) {
//         self.toString()
//     }

//     static Integer unmashal(String self) {
//         self.toInteger()
//     }
// }

// use Marshal, {
//     assert 1.mashal() == "1"
//     assert "1".unmashal() == 1
// }


@Category(Integer)
class IntergerMarshal {
    String marshal() {
        toString()
    }
}

@Category(String)
class StringMarshal {
    Integer unmashal() {
        this.toInteger()
    }
}

use ([IntergerMarshal, StringMarshal]) {
    assert 1.marshal() == "1"
    assert "1".unmashal() == 1
}