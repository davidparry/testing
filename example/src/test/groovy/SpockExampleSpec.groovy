import com.davidparry.luck.SpockExample

class SpockExampleSpec extends spock.lang.Specification {
    def "test value being set in constructor works"() {
        expect:
        spockexample.value == val

        where:
        spockexample | val
        new SpockExample(23)  | 23
        new SpockExample(45)  | 45
        new SpockExample(-12) | -12
    }
}