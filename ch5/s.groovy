println 'He said, "That is Groovy"'

str = 'A string'
println str.getClass().name

value = 25
println 'The value is ${value}'
println "The value is ${value}"

paid = 12
println "He paid \$${paid} for that."

what = new StringBuilder('fence')
text = "The cow jumped over the $what"
println text

what.replace(0, 5, "moon")
println text

println text.getClass().name

memo = ''' Several of you raised concerns about long meetings.
To discuss this, we will be holding a 3 hour meeting starting
at 9AM tomorrow. All getting this memo are required to attend.
'''

println memo

langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']

content = ''
langs.each {language, author -> 
    fragment = """
        <language name="${language}">
            <author>${author}</author>
        </language>
    """

    content += fragment
}
xml = "<languages>${content}</languages>"
println xml

for (str in 'sa' .. 'sd') {
    println str
}

regex = ~"hello"
println regex.getClass().name