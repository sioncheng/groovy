
class MessageFeature {
    def message
    def prefix(String pre) {
        "$pre $message"
    }
}

@Mixin(MessageFeature)
class Message {
    def test() {
        message = "abc"
        prefix("a")
    }
}

assert "a abc" == (new Message()).test()


class EvenSieve {
    def getNo2() {
        removeAll { it % 2 == 0}
        return this
    }
}

class MinusSieve {
    def minus(int num) {
        removeAll { it % num == 0}
        return this
    }
}

ArrayList.mixin EvenSieve, MinusSieve

assert (0..10).toList().no2 - 3 - 5 == [1, 7]