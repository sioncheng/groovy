
def boxer = new Expando()

boxer.takeThis = 'ouch!'
boxer.fightBack = {times -> takeThis * times}

assert boxer.fightBack(3) == 'ouch!ouch!ouch!'

//println String.metaClass
String.metaClass.low = {-> delegate.toLowerCase()}
//println String.metaClass

assert "AefG".low() == "aefg"

class MyGroovy1  {
}

def before = new MyGroovy1()

MyGroovy1.metaClass.myProp = "MyGroovy prop"
MyGroovy1.metaClass.test = {-> myProp}

try {
    before.test()
    assert false, 'should throw MME'
} catch(mme) {}

assert new MyGroovy1().test() == "MyGroovy prop"

Integer.metaClass.static.answer = {->42}

assert Integer.answer() == 42

class MySupperGroovy {}
class MySubGroovy extends MySupperGroovy {}

MySupperGroovy.metaClass.added = { -> true }

assert new MySubGroovy().added()

Map.metaClass.toTable = {-> 
    delegate.collect { [it.key, it.value] }
}

assert [a:1, b:2].toTable() == [
    ['a', 1],
    ['b', 2]
]