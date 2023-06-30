
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
class Detective {
    String firstName, lastName
}

def sherlock = new Detective(firstName: 'Sherlock', lastName: 'Holmes')

assert sherlock.toString() == 'Detective(Sherlock, Holmes)'

@ToString(ignoreNulls = true)
@TupleConstructor
class Athlete {
    String firstName, lastName
}

def a1 = new Athlete('Michael')
assert "Michael" == a1.firstName
assert "Athlete(Michael)" == a1.toString()